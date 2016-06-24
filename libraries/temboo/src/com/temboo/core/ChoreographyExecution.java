package com.temboo.core;

import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.Choreography.ResultSet.Status;
import processing.data.JSONObject;

import java.net.URISyntaxException;
import java.util.HashMap;

public class ChoreographyExecution extends TembooResource {

	// The ResultSet for this choreography execution, if available
	private ResultSet resultSet = null;

	// The status of this choreography, if it has completed
	private ResultSet.Status finalStatus = null;
	
	/**
	 * Create a new ChoreographyExecution object, which can be used to track the status of a running choreo.
	 * @param session - A session object containing valid Temboo credentials
	 * @param exec_id - The execution ID of a running choreo
	 * @throws URISyntaxException
	 */
	public ChoreographyExecution(TembooSession session, String exec_id)
			throws URISyntaxException {
		super(session, TembooPath.uriFromString("/" + exec_id));
	}

	
	/**
	 * Obtain the current status of the choreography execution represented by this object.
	 * The possible completion status of a choreography is: SUCCESS, ERROR, TERMINATED_MANUALLY, TERMINATED_LIMIT, RUNNING
	 * 
	 * If the status of a choreography is not RUNNING, the getResultSet() method may be used to retrieve a ResultSet for the execution.
	 * 
	 * @return
	 * @throws TembooException
	 */
	public ResultSet.Status getStatus() throws TembooException {

		if(null != finalStatus)
			return finalStatus;
		
		JSONObject doc = null;
		doc = session.getContent(getPath());
		if (doc != null) {
			JSONObject execution = doc.getJSONObject("execution");
	
			String statusString = execution.getString("status");
			
			Status status = Status.valueOf(statusString);
			if (status != ResultSet.Status.RUNNING) {
					
				// If the choreography has completed successfully, retrieve the full set of outputs
				if(status == ResultSet.Status.SUCCESS) {
					HashMap<String, String> paramMap = new HashMap<String, String>();
					paramMap.put("view", "outputs");
					doc = session.getContent(getPath(), paramMap);						
				} 					
				
				resultSet = new ResultSet(doc);
					
				// Mark this execution as completed
				finalStatus = status;
			}
			return status;
		}
		return null;
	}
	
	
	public ResultSet getResultSet() throws TembooException {
		if (null == resultSet) {
			getStatus();
		}
		return resultSet;
	}

	protected static String getStaticBasePath() {
		return TembooSession.BASE_PATH + "/choreo-executions";
	}

	protected String getBasePath() {
		return getStaticBasePath();
	}

	public FutureResultSet getFutureChoreographyResultSet(int secondsPerPoll)
			throws TembooException {
		return new FutureResultSet(this, secondsPerPoll);
	}
}
