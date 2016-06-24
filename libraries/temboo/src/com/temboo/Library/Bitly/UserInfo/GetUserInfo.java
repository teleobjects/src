package com.temboo.Library.Bitly.UserInfo;

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
GetUserInfo

Returns information about a specified user.
*/
public class GetUserInfo extends Choreography {

	/**
	Create a new instance of the GetUserInfo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetUserInfo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bitly/UserInfo/GetUserInfo"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The OAuth access token provided by Bitly.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the FullName input for this Choreo. 

	@param String - (optional, string) The users full name value (only available for the authenticated user).
	*/
	public void setFullName(String value) {
		this.inputs.setInput("FullName", value);
	}


	/** 
	Set the value of the Login input for this Choreo. 

	@param String - (optional, string) The Bitly login of the user whose info to look up. If not given, the authenticated user will be used.
	*/
	public void setLogin(String value) {
		this.inputs.setInput("Login", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in. Accepted values are "json" or "xml". Defaults to "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetUserInfoResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetUserInfoResultSet(result);
	}
	
}
