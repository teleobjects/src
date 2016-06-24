package com.temboo.Library.Utilities.Callback;

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
RegisterCallback

Allows you to generate a unique URL that can "listen" for incoming data from web request.
*/
public class RegisterCallback extends Choreography {

	/**
	Create a new instance of the RegisterCallback Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RegisterCallback(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Callback/RegisterCallback"));
	}

	/** 
	Set the value of the CustomCallbackD input for this Choreo. 

	@param String - (optional, string) This value is used to register a unique URL associated with your account. If omitted, a random identifier is generated. Using a custom value here is useful when you need the URL to be static.
	*/
	public void setCustomCallbackD(String value) {
		this.inputs.setInput("CustomCallbackD", value);
	}


	/** 
	Set the value of the FilterName input for this Choreo. 

	@param String - (optional, string) When using a Custom Callback ID, it can be useful to filter requests using a query parameter. This value is used as a query parameter name, and can be used to lookup request data.
	*/
	public void setFilterName(String value) {
		this.inputs.setInput("FilterName", value);
	}


	/** 
	Set the value of the FilterValue input for this Choreo. 

	@param String - (optional, string) When using a Custom Callback ID, it can be useful to filter requests using a query parameter. This value is used as a query parameter value, and can be used to lookup request data.
	*/
	public void setFilterValue(String value) {
		this.inputs.setInput("FilterValue", value);
	}


	/** 
	Set the value of the ForwardingURL input for this Choreo. 

	@param String - (optional, string) The URL that Temboo will redirect a users to after they visit your URL. This should include the "https://" or "http://" prefix and be a fully qualified URL.
	*/
	public void setForwardingURL(String value) {
		this.inputs.setInput("ForwardingURL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RegisterCallbackResultSet run() {
		JSONObject result = super.runWithResults();
		return new RegisterCallbackResultSet(result);
	}
	
}
