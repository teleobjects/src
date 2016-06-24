package com.temboo.core;

import com.temboo.core.Choreography.ResultSet;

import java.util.concurrent.*;

public class FutureResultSet implements Future<ResultSet> {
	private ResultSet resultSet = null;
	private final ChoreographyExecution exec;
	private final ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
	private final int secondsPerPoll;
	private final CountDownLatch latch;
	private Poller command = null;
	private Boolean cancelled = false;
	
	FutureResultSet(ChoreographyExecution choreoExecution,
			int secondsPerPoll) throws TembooException {
		if (choreoExecution == null) {
			throw new NullPointerException();
		}
		exec = choreoExecution;
		this.secondsPerPoll = secondsPerPoll;
		latch = new CountDownLatch(1);
	}

	@Override
	/* 
	 * (non-Javadoc)
	 * This cancel does not cancel the running choreo, it
	 * just cancels the polling by this FutureChoreoResultSet
	 * @see java.util.concurrent.Future#cancel(boolean)
	 */
	public boolean cancel(boolean arg0) {
		if (isDone()) {
			return true;
		}
		cancelled = true;
		stopPolling();
		latch.countDown();
		return true;
	}

	@Override
	public ResultSet get() throws InterruptedException,
			ExecutionException {
		synchronized (this) {
			if (resultSet != null) {
				return resultSet;
			}
		}
		synchronized (cancelled) {
			if (cancelled == true)
				return null;
		}
		startPolling();
		latch.await();
		stopPolling();
		synchronized (this) {
			return resultSet;
		}
	}

	@Override
	public ResultSet get(long arg0, TimeUnit arg1)
			throws InterruptedException, ExecutionException, TimeoutException {
		synchronized (this) {
			if (resultSet != null) {
				return resultSet;
			}
		}
		synchronized (cancelled) {
			if (cancelled == true)
				return null;
		}
		startPolling();
		latch.await(arg0, arg1);
		stopPolling();
		synchronized (this) {
			return resultSet;
		}
	}

	private void startPolling() throws ExecutionException {
		synchronized (this) {
			if (resultSet == null) {
				command = new Poller();
				pool.scheduleAtFixedRate(command, 0, secondsPerPoll,
						TimeUnit.SECONDS);
			}
		}
	}
	
	private void stopPolling() {
		if (command != null) {
			pool.remove(command);
			pool.purge();
			command = null;
		}
		if (!pool.isShutdown()) {
			pool.shutdownNow();
		}
	}

	@Override
	public boolean isCancelled() {
		synchronized (cancelled) {
			return cancelled=true;
		}
	}

	@Override
	public boolean isDone() {
		synchronized (cancelled) {
			if (cancelled == true)
				return true;
		}
		synchronized (this) {
			if (resultSet != null)
				return true;
		}
		return false;
	}

	private class Poller implements Runnable {

		@Override
		public void run() {
			try {
				ResultSet rs = exec.getResultSet();
				synchronized (FutureResultSet.this) {
					if (rs != null) {
						resultSet = rs;
						latch.countDown();
					}
				}
			} catch (TembooException e) {
				cancel(false);
			}

		}

	}
}
