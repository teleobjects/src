package com.temboo.Library.Bugzilla;

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
SearchForBugs

Searches bugs by Mozilla product name.
*/
public class SearchForBugs extends Choreography {

	/**
	Create a new instance of the SearchForBugs Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchForBugs(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bugzilla/SearchForBugs"));
	}

	/** 
	Set the value of the BugChangeDate input for this Choreo. 

	@param String - (optional, string) Retrieve bugs that were changed within a certain date range. For example: 25d will return all bugs changed from 25 days ago untill today.  Or: 3h, to return all bugs entered with 3 hours.
	*/
	public void setBugChangeDate(String value) {
		this.inputs.setInput("BugChangeDate", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (optional, password) Your Bugzilla password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Priority input for this Choreo. 

	@param Integer - (optional, integer) Filter results by priority: For example: enter P1, to get Priority 1 bugs assoicated with a Product.
	*/
	public void setPriority(Integer value) {
		this.inputs.setInput("Priority", value);
	}

	/** 
	Set the value of the Priority input for this Choreo as a String. 

	@param String - (optional, integer) Filter results by priority: For example: enter P1, to get Priority 1 bugs assoicated with a Product.
	*/
	public void setPriority(String value) {
		this.inputs.setInput("Priority", value);	
	}
	/** 
	Set the value of the Product input for this Choreo. 

	@param String - (required, string) Enter the Mozilla product for which bugs will be retrieved. For example: Bugzilla
	*/
	public void setProduct(String value) {
		this.inputs.setInput("Product", value);
	}


	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (optional, string) The base URL for the Bugzilla server to access. Defaults to https://api-dev.bugzilla.mozilla.org/latest. To access the test server, set to https://api-dev.bugzilla.mozilla.org/test/latest.
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the Severity input for this Choreo. 

	@param String - (optional, string) Filter results by severity. For example: blocker
	*/
	public void setSeverity(String value) {
		this.inputs.setInput("Severity", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) Your Bugzilla username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchForBugsResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchForBugsResultSet(result);
	}
	
}
