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
UnstarGist

Unstars a gist using a specified gist id.
*/
public class UnstarGist extends Choreography {

	/**
	Create a new instance of the UnstarGist Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UnstarGist(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/GistsAPI/Gists/UnstarGist"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (required, string) The id for the gist you want to unstar.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UnstarGistResultSet run() {
		JSONObject result = super.runWithResults();
		return new UnstarGistResultSet(result);
	}
	
}
