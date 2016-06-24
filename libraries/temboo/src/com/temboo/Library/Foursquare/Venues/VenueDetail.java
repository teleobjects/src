package com.temboo.Library.Foursquare.Venues;

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
VenueDetail

Obtain details about venues, including location, mayorship, tags, tips, specials and category.  Users who have authenticated via their oauth_token credential, also receive information about who is at the location being queried.
*/
public class VenueDetail extends Choreography {

	/**
	Create a new instance of the VenueDetail Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public VenueDetail(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Venues/VenueDetail"));
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

	@param String - (conditional, string) The Foursquare API Oauth token string. Required unless specifying the ClientID and ClientSecret.
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
	Set the value of the VenueID input for this Choreo. 

	@param String - (required, string) The ID associated with the venue you want to retrieve details for.
	*/
	public void setVenueID(String value) {
		this.inputs.setInput("VenueID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public VenueDetailResultSet run() {
		JSONObject result = super.runWithResults();
		return new VenueDetailResultSet(result);
	}
	
}
