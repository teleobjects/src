package com.temboo.Library.Foursquare.Specials;

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
SpecialDetail

Returns details about a special, including text and whether it is unlocked for the current or provided user.
*/
public class SpecialDetail extends Choreography {

	/**
	Create a new instance of the SpecialDetail Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SpecialDetail(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Specials/SpecialDetail"));
	}

	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) Your Foursquare client ID, obtained after registering at Foursquare. Required unless using the OauthToken input.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) Your Foursquare client secret, obtained after registering at Foursquare. Required unless using the OauthToken input.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (conditional, string) The Foursquare API OAuth token string. Required unless specifying the ClientID and ClientSecret.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SpecialID input for this Choreo. 

	@param String - (required, string) The ID of the special to retrieve details for.
	*/
	public void setSpecialID(String value) {
		this.inputs.setInput("SpecialID", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the user to check whether the special is unlocked for.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the VenueID input for this Choreo. 

	@param String - (required, string) The ID of a venue the special is offered at.
	*/
	public void setVenueID(String value) {
		this.inputs.setInput("VenueID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SpecialDetailResultSet run() {
		JSONObject result = super.runWithResults();
		return new SpecialDetailResultSet(result);
	}
	
}
