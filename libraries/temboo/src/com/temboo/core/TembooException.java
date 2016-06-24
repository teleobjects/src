package com.temboo.core;


public class TembooException extends Exception {

	public TembooException(String message) {
		super(message);
	}
	
	public TembooException(Throwable e) {
		super((e == null ? null : e.getMessage()), e);
	}

	private static final long serialVersionUID = 368864799315402620L;

}
