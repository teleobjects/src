package com.temboo.Library.GitHub.GistsAPI.Gists;

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
GetGist

Returns an individual gist with a given id.
*/
public class GetGist extends Choreography {

	/**
	Create a new instance of the GetGist Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetGist(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/GistsAPI/Gists/GetGist"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The Access Token retrieved during the OAuth process. Required when accessing a protected resource.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (required, string) The id for the gist you want to retrieve.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetGistResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetGistResultSet(result);
	}
	
}
