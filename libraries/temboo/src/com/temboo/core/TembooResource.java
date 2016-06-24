package com.temboo.core;


public abstract class TembooResource {

	protected final TembooSession session;
	protected final TembooPath uri;

	public TembooResource(TembooSession session, TembooPath uri) {
		this.session = session;
		this.uri = uri;
	}

	protected String getPath() {
		return getBasePath() + uri.toString();
	}

	protected abstract String getBasePath();

	public TembooPath getURI() {
		return uri;
	}
}