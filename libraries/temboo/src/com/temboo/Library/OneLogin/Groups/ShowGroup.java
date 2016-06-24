package com.temboo.Library.OneLogin.Groups;

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
ShowGroup

Retrieves information for a single group.
*/
public class ShowGroup extends Choreography {

	/**
	Create a new instance of the ShowGroup Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ShowGroup(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/OneLogin/Groups/ShowGroup"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by OneLogin.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param Integer - (required, integer) The id the group you want to return.
	*/
	public void setID(Integer value) {
		this.inputs.setInput("ID", value);
	}

	/** 
	Set the value of the ID input for this Choreo as a String. 

	@param String - (required, integer) The id the group you want to return.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ShowGroupResultSet run() {
		JSONObject result = super.runWithResults();
		return new ShowGroupResultSet(result);
	}
	
}
