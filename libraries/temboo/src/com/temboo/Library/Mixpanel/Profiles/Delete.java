package com.temboo.Library.Mixpanel.Profiles;

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
Delete

Permanently deletes the profile from Mixpanel, along with all of its properties.
*/
public class Delete extends Choreography {

	/**
	Create a new instance of the Delete Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Delete(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/Profiles/Delete"));
	}

	/** 
	Set the value of the DistinctID input for this Choreo. 

	@param String - (required, string) Used to uniquely identify the profile you want to update.
	*/
	public void setDistinctID(String value) {
		this.inputs.setInput("DistinctID", value);
	}


	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (required, string) The token provided by Mixpanel. You can find your Mixpanel token in the project settings dialog in the Mixpanel app.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	/** 
	Set the value of the Verbose input for this Choreo. 

	@param Boolean - (optional, boolean) When set to 1, the response will contain more information describing the success or failure of the tracking call.
	*/
	public void setVerbose(Boolean value) {
		this.inputs.setInput("Verbose", value);
	}

	/** 
	Set the value of the Verbose input for this Choreo as a String. 

	@param String - (optional, boolean) When set to 1, the response will contain more information describing the success or failure of the tracking call.
	*/
	public void setVerbose(String value) {
		this.inputs.setInput("Verbose", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteResultSet(result);
	}
	
}
