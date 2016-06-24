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
CreateThread

Creates a new thread.
*/
public class CreateThread extends Choreography {

	/**
	Create a new instance of the CreateThread Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateThread(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Threads/CreateThread"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) A valid OAuth 2.0 access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Category input for this Choreo. 

	@param String - (optional, string) The id of a category associated with the thread being created.
	*/
	public void setCategory(String value) {
		this.inputs.setInput("Category", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, date) The date to be associated with this thread (as a unix timestamp or ISO datetime format).
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the Forum input for this Choreo. 

	@param String - (required, string) Forum Short Name (i.e., the subdomain of the Disqus Site URL).
	*/
	public void setForum(String value) {
		this.inputs.setInput("Forum", value);
	}


	/** 
	Set the value of the Identifier input for this Choreo. 

	@param String - (optional, string) An optional string identifier for the thread. Maximum length is 300.
	*/
	public void setIdentifier(String value) {
		this.inputs.setInput("Identifier", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) A message for the new thread.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the PublicKey input for this Choreo. 

	@param String - (required, string) The Public Key provided by Disqus (AKA the API Key).
	*/
	public void setPublicKey(String value) {
		this.inputs.setInput("PublicKey", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (required, string) The title of the thread.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (optional, string) A URL to be associated with the thread. Maximum length is 500.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateThreadResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateThreadResultSet(result);
	}
	
}
