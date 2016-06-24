package com.temboo.Library.Disqus.Threads;

/*
Copyright 2014 Temboo, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import processing.data.JSONArray;
import processing.data.JSONObject;
import java.math.BigDecimal;
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
UnsubscribeFromThread

Unsubscribe from a thread.
*/
public class UnsubscribeFromThread extends Choreography {

	/**
	Create a new instance of the UnsubscribeFromThread Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UnsubscribeFromThread(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Threads/UnsubscribeFromThread"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (conditional, string) The email address that will be unsubsribed from the thread.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the Forum input for this Choreo. 

	@param String - (optional, string) Forum Short Name (i.e., the subdomain of the Disqus Site URL) of a thread that is to be unsubscribed from. Required if setting either ThreadByIdentification, or ThreadByLink.
	*/
	public void setForum(String value) {
		this.inputs.setInput("Forum", value);
	}


	/** 
	Set the value of the PublicKey input for this Choreo. 

	@param String - (required, string) The Public Key provided by Disqus (AKA the API Key).
	*/
	public void setPublicKey(String value) {
		this.inputs.setInput("PublicKey", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and jsonp.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ThreadID input for this Choreo. 

	@param Integer - (conditional, integer) The ID of a thread that is to be unsubscribed from. Required unless specifying the ThreadIdentifier or ThreadLink. If using this parameter, ThreadIdentifier cannot be set.
	*/
	public void setThreadID(Integer value) {
		this.inputs.setInput("ThreadID", value);
	}

	/** 
	Set the value of the ThreadID input for this Choreo as a String. 

	@param String - (conditional, integer) The ID of a thread that is to be unsubscribed from. Required unless specifying the ThreadIdentifier or ThreadLink. If using this parameter, ThreadIdentifier cannot be set.
	*/
	public void setThreadID(String value) {
		this.inputs.setInput("ThreadID", value);	
	}
	/** 
	Set the value of the ThreadIdentifier input for this Choreo. 

	@param String - (conditional, string) The identifier for the thread that is to be unsubscribed from.  Note that a Forum must also be provided when using this parameter. If set, ThreadID and ThreadLink cannot be used.
	*/
	public void setThreadIdentifier(String value) {
		this.inputs.setInput("ThreadIdentifier", value);
	}


	/** 
	Set the value of the ThreadLink input for this Choreo. 

	@param String - (conditional, string) A link pointing to the thread that is to be unsubscribed from. Note that a Forum must also be provided when using this parameter. If set, ThreadID and ThreadIdentifier cannot be set.
	*/
	public void setThreadLink(String value) {
		this.inputs.setInput("ThreadLink", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UnsubscribeFromThreadResultSet run() {
		JSONObject result = super.runWithResults();
		return new UnsubscribeFromThreadResultSet(result);
	}
	
}
