package com.temboo.Library.Nexmo.Search;

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
SearchRejectedMessages

Search for a previously sent message by Message ID.  Note that a sent message won't be immediately available for search.
*/
public class SearchRejectedMessages extends Choreography {

	/**
	Create a new instance of the SearchRejectedMessages Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchRejectedMessages(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Nexmo/Search/SearchRejectedMessages"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) Your API Key provided to you by Nexmo.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) Your API Secret provided to you by Nexmo.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (required, string) Date message was sent in the form of YYYY-MM-DD. (e.g. 2013-07-01)
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the MessageID input for this Choreo. 

	@param String - (required, string) Your Message ID.
	*/
	public void setMessageID(String value) {
		this.inputs.setInput("MessageID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "json" (the default) and "xml".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) The recipient's phone number.  (e.g. 123456780)
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchRejectedMessagesResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchRejectedMessagesResultSet(result);
	}
	
}
