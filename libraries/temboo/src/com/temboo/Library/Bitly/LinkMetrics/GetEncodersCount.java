package com.temboo.Library.Bitly.LinkMetrics;

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
GetEncodersCount

Returns the count of users who have shortened a specified Bitly link.
*/
public class GetEncodersCount extends Choreography {

	/**
	Create a new instance of the GetEncodersCount Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetEncodersCount(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bitly/LinkMetrics/GetEncodersCount"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The OAuth access token provided by Bitly.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (required, string) A Bitly link.
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
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
	public GetEncodersCountResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetEncodersCountResultSet(result);
	}
	
}
