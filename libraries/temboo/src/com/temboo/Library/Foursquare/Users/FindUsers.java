package com.temboo.Library.Foursquare.Users;

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
FindUsers

Allows a user to locate friends.
*/
public class FindUsers extends Choreography {

	/**
	Create a new instance of the FindUsers Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindUsers(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Users/FindUsers"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (conditional, string) A comma-delimited list of email addresses to look for. Must specify one of Name, Phone, Email, FacebookID, Twitter, or TwitterSource.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the FacebookID input for this Choreo. 

	@param String - (conditional, string) A comma-delimited list of Facebook ID's to look for. Must specify one of Name, Phone, Email, FacebookID, Twitter, or TwitterSource.
	*/
	public void setFacebookID(String value) {
		this.inputs.setInput("FacebookID", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (conditional, string) A single string to search for in users' names. A single string to search for in users' names. Must specify one of Name, Phone, Email, FacebookID, Twitter, or TwitterSource.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (conditional, string) A comma-delimited list of phone numbers to look for. Must specify one of Name, Phone, Email, FacebookID, Twitter, or TwitterSource.
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Twitter input for this Choreo. 

	@param String - (conditional, string) A comma-delimited list of Twitter handles to look for. Must specify one of Name, Phone, Email, FacebookID, Twitter, or TwitterSource.
	*/
	public void setTwitter(String value) {
		this.inputs.setInput("Twitter", value);
	}


	/** 
	Set the value of the TwitterSource input for this Choreo. 

	@param String - (conditional, string) A single Twitter handle. Results will be users that this handle follows on Twitter who use Foursquare. Must specify one of Name, Phone, Email, FacebookID, Twitter, or TwitterSource.
	*/
	public void setTwitterSource(String value) {
		this.inputs.setInput("TwitterSource", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindUsersResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindUsersResultSet(result);
	}
	
}
