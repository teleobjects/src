package com.temboo.Library.Delicious;

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
GetRecentBookmarks

Retrieve a list of the most recently posted bookmarks.
*/
public class GetRecentBookmarks extends Choreography {

	/**
	Create a new instance of the GetRecentBookmarks Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetRecentBookmarks(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Delicious/GetRecentBookmarks"));
	}

	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) Specify the number of bookmarks to retrieve, up the maximum of 100. The default is 15.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) Specify the number of bookmarks to retrieve, up the maximum of 100. The default is 15.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The password that corresponds to the specified Delicious account username.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) Return only items tagged with the specified keyword.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A valid Delicious account username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetRecentBookmarksResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetRecentBookmarksResultSet(result);
	}
	
}
