package com.temboo.core;

public class TembooHttpException extends TembooException {

	private static final long serialVersionUID = -8874926707769668778L;
	private final int httpStatus;

	public TembooHttpException(String message, int httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public int getStatus() {
		return this.httpStatus;
	}
}
