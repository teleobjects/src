package com.temboo.Library.Dropbox.FilesAndMetadata;

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
LongPollDelta

Used in conjunction with the Delta Choreo, this allows you to perform a long-poll request to wait for changes on an account.
*/
public class LongPollDelta extends Choreography {

	/**
	Create a new instance of the LongPollDelta Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public LongPollDelta(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/LongPollDelta"));
	}

	/** 
	Set the value of the Cursor input for this Choreo. 

	@param String - (required, string) A delta cursor as returned from a call to the Delta Choreo.
	*/
	public void setCursor(String value) {
		this.inputs.setInput("Cursor", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Timeout input for this Choreo. 

	@param String - (optional, string) An integer indicating the amount of time, in seconds, to wait for a response. The default value is 30 seconds, which is also the minimum allowed value. The maximum is 480 seconds.
	*/
	public void setTimeout(String value) {
		this.inputs.setInput("Timeout", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LongPollDeltaResultSet run() {
		JSONObject result = super.runWithResults();
		return new LongPollDeltaResultSet(result);
	}
	
}
