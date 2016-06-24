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
GetLinkHistory

Returns entries from a user's link history in reverse chronological order.
*/
public class GetLinkHistory extends Choreography {

	/**
	Create a new instance of the GetLinkHistory Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLinkHistory(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bitly/UserInfo/GetLinkHistory"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The OAuth access token provided by Bitly.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Archived input for this Choreo. 

	@param String - (optional, string) Accepted values are: on|off|both.  Whether to include or exclude archived history entries. (on = return only archived history entries). Defaults to "off".
	*/
	public void setArchived(String value) {
		this.inputs.setInput("Archived", value);
	}


	/** 
	Set the value of the CreatedAfter input for this Choreo. 

	@param String - (optional, date) An epoch timestamp representing a date to filter with.
	*/
	public void setCreatedAfter(String value) {
		this.inputs.setInput("CreatedAfter", value);
	}


	/** 
	Set the value of the CreatedBefore input for this Choreo. 

	@param String - (optional, date) An epoch timestamp representing a date to filter with.
	*/
	public void setCreatedBefore(String value) {
		this.inputs.setInput("CreatedBefore", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) An integer in the range of 1 to 100, specifying the max number of results to return. Defaults to 50.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) An integer in the range of 1 to 100, specifying the max number of results to return. Defaults to 50.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (optional, string) The bitly link to return metadata for (when spcified, overrides all other options).
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
	}


	/** 
	Set the value of the ModifiedAfter input for this Choreo. 

	@param String - (optional, date) An epoch timestamp representing a date to filter with.
	*/
	public void setModifiedAfter(String value) {
		this.inputs.setInput("ModifiedAfter", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param String - (optional, string) An integer specifying the numbered result at which to start (used for pagination).
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);
	}


	/** 
	Set the value of the Private input for this Choreo. 

	@param String - (optional, string) Accepted values are: on|off|both.  Whether to include or exclude archived history entries. (on = return only archived history entries). Defaults to "both".
	*/
	public void setPrivate(String value) {
		this.inputs.setInput("Private", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in. Accepted values are "json" or "xml". Defaults to "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (optional, string) The user for whom to retrieve history entries (if different from authenticated user).
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLinkHistoryResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLinkHistoryResultSet(result);
	}
	
}
