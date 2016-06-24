package com.temboo.Library.Labs.Social;

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
GetContacts

Retrieves your social contacts from multiple APIs in one API call.
*/
public class GetContacts extends Choreography {

	/**
	Create a new instance of the GetContacts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetContacts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Labs/Social/GetContacts"));
	}

	/** 
	Set the value of the APICredentials input for this Choreo. 

	@param String - (conditional, json) A list of credentials for the APIs you wish to access. See Choreo documentation for formatting examples.
	*/
	public void setAPICredentials(String value) {
		this.inputs.setInput("APICredentials", value);
	}


	/** 
	Set the value of the ScreenName input for this Choreo. 

	@param String - (conditional, string) The Twitter screen name to retrieve followers for.
	*/
	public void setScreenName(String value) {
		this.inputs.setInput("ScreenName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetContactsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetContactsResultSet(result);
	}
	
}
