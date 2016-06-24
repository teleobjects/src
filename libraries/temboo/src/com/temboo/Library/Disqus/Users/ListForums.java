package com.temboo.Library.Disqus.Users;

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
ListForums

Retrieve a list of forums owned by the specified user.
*/
public class ListForums extends Choreography {

	/**
	Create a new instance of the ListForums Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListForums(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Users/ListForums"));
	}

	/** 
	Set the value of the Cursor input for this Choreo. 

	@param String - (optional, string) Default is set to null.
	*/
	public void setCursor(String value) {
		this.inputs.setInput("Cursor", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of records to return. Defaults to 25.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of records to return. Defaults to 25.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) The sort order for the results. Valid vaues are: asc or desc. Default is set to: asc.
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
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

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default), jsonp, or rss.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SinceID input for this Choreo. 

	@param String - (optional, string) A Unix timestamp to obtain results from. Default is set to null.
	*/
	public void setSinceID(String value) {
		this.inputs.setInput("SinceID", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (conditional, string) The Disqus User ID, for which active forum information will be retrieved.  If UserID is set, then Username must be null.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (conditional, string) A Disqus username.  If Username is being set, then UserID must be null.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListForumsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListForumsResultSet(result);
	}
	
}
