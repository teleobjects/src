package com.temboo.Library.Instagram;

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
ModifyRelationship

Modifies the relationship between the authenticating user and the target user.
*/
public class ModifyRelationship extends Choreography {

	/**
	Create a new instance of the ModifyRelationship Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ModifyRelationship(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Instagram/ModifyRelationship"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved during the OAuth 2.0 process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Action input for this Choreo. 

	@param String - (required, string) The type of relationship modification to perform. Valid values are: follow, unfollow, block, unblock, approve, or deny.
	*/
	public void setAction(String value) {
		this.inputs.setInput("Action", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (required, string) The ID of the target user.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ModifyRelationshipResultSet run() {
		JSONObject result = super.runWithResults();
		return new ModifyRelationshipResultSet(result);
	}
	
}
