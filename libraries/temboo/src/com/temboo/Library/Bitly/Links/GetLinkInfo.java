package com.temboo.Library.Bitly.Links;

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
GetLinkInfo

Returns the page title for a given Bitly link.
*/
public class GetLinkInfo extends Choreography {

	/**
	Create a new instance of the GetLinkInfo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLinkInfo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bitly/Links/GetLinkInfo"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The OAuth access token provided by Bitly.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in. Accepted values are "json" or "xml". Defaults to "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ShortURL input for this Choreo. 

	@param String - (required, string) One or more Bitly links.
	*/
	public void setShortURL(String value) {
		this.inputs.setInput("ShortURL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLinkInfoResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLinkInfoResultSet(result);
	}
	
}
