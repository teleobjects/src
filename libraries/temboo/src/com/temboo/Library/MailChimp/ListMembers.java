package com.temboo.Library.MailChimp;

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
ListMembers

Retrieves the email addresses of members of a MailChimp list. 
*/
public class ListMembers extends Choreography {

	/**
	Create a new instance of the ListMembers Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListMembers(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/MailChimp/ListMembers"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Mailchimp.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Specifies the number of records in a page to be returned. Must be greater than zero and less than or equal to 15000. Defaults to 100.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the number of records in a page to be returned. Must be greater than zero and less than or equal to 15000. Defaults to 100.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the ListId input for this Choreo. 

	@param String - (required, string) The id of the Mailchimp list to retrieve members from.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Indicates the desired format for the response. Accepted values are "json" or "xml" (the default).
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (optional, date) Retrieves records that have changed since this date/time. Formatted like 'YYYY-MM-DD HH:MM:SS.
	*/
	public void setSince(String value) {
		this.inputs.setInput("Since", value);
	}


	/** 
	Set the value of the Start input for this Choreo. 

	@param Integer - (optional, integer) Specifies the page at which to begin returning records. Page size is defined by the limit argument. Must be zero or greater. Defaults to 0.
	*/
	public void setStart(Integer value) {
		this.inputs.setInput("Start", value);
	}

	/** 
	Set the value of the Start input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the page at which to begin returning records. Page size is defined by the limit argument. Must be zero or greater. Defaults to 0.
	*/
	public void setStart(String value) {
		this.inputs.setInput("Start", value);	
	}
	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) Must be one of 'subscribed', 'unsubscribed', 'cleaned', or 'updated'. Defaults to 'subscribed'.
	*/
	public void setStatus(String value) {
		this.inputs.setInput("Status", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListMembersResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListMembersResultSet(result);
	}
	
}
