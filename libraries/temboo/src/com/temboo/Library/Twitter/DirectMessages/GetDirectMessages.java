package com.temboo.Library.Twitter.DirectMessages;

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
GetDirectMessages

Retrieves the 20 most recent direct messages sent to the authenticating user.
*/
public class GetDirectMessages extends Choreography {

	/**
	Create a new instance of the GetDirectMessages Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetDirectMessages(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/DirectMessages/GetDirectMessages"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) Specifies the number of records to retrieve up to a maximum of 200.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the number of records to retrieve up to a maximum of 200.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the IncludeEntities input for this Choreo. 

	@param Boolean - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(Boolean value) {
		this.inputs.setInput("IncludeEntities", value);
	}

	/** 
	Set the value of the IncludeEntities input for this Choreo as a String. 

	@param String - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(String value) {
		this.inputs.setInput("IncludeEntities", value);	
	}
	/** 
	Set the value of the MaxID input for this Choreo. 

	@param String - (optional, string) Returns results with an ID less than (older than) or equal to the specified ID.
	*/
	public void setMaxID(String value) {
		this.inputs.setInput("MaxID", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Specifies the page of results to retrieve.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the page of results to retrieve.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the SinceID input for this Choreo. 

	@param String - (optional, string) Returns results with an ID greater than (more recent than) the specified ID.
	*/
	public void setSinceID(String value) {
		this.inputs.setInput("SinceID", value);
	}


	/** 
	Set the value of the SkipStatus input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, statuses will not be included in the returned user objects.
	*/
	public void setSkipStatus(Boolean value) {
		this.inputs.setInput("SkipStatus", value);
	}

	/** 
	Set the value of the SkipStatus input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, statuses will not be included in the returned user objects.
	*/
	public void setSkipStatus(String value) {
		this.inputs.setInput("SkipStatus", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetDirectMessagesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetDirectMessagesResultSet(result);
	}
	
}
