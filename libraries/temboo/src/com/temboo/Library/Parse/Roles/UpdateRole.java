package com.temboo.Library.Parse.Roles;

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
UpdateRole

Updates an existing role.
*/
public class UpdateRole extends Choreography {

	/**
	Create a new instance of the UpdateRole Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateRole(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Roles/UpdateRole"));
	}

	/** 
	Set the value of the Role input for this Choreo. 

	@param String - (required, json) A JSON string containing the role information to be updated. See documentation for formatting details.
	*/
	public void setRole(String value) {
		this.inputs.setInput("Role", value);
	}


	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the MasterKey input for this Choreo. 

	@param String - (required, string) The Master Key provided by Parse.
	*/
	public void setMasterKey(String value) {
		this.inputs.setInput("MasterKey", value);
	}


	/** 
	Set the value of the ObjectID input for this Choreo. 

	@param String - (required, string) The ID of the role to update.
	*/
	public void setObjectID(String value) {
		this.inputs.setInput("ObjectID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateRoleResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateRoleResultSet(result);
	}
	
}
