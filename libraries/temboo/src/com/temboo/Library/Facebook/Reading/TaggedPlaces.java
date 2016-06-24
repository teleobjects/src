package com.temboo.Library.Facebook.Reading;

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
TaggedPlaces

Returns a list of tags of a user at a place in a photo, video, post, status or link.
*/
public class TaggedPlaces extends Choreography {

	/**
	Create a new instance of the TaggedPlaces Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TaggedPlaces(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Reading/TaggedPlaces"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the After input for this Choreo. 

	@param String - (optional, string) A cursor that points to the end of the page of data that has been returned. You can pass this cursor to retrievet he next page of results.
	*/
	public void setAfter(String value) {
		this.inputs.setInput("After", value);
	}


	/** 
	Set the value of the Before input for this Choreo. 

	@param String - (optional, string) A cursor that points to the start of the page of data that has been returned. You can pass this cursor to retrieve the previous page of results.
	*/
	public void setBefore(String value) {
		this.inputs.setInput("Before", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return (i.e. id,name).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Limits the number of records returned in the response.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Limits the number of records returned in the response.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The id of the profile to retrieve tagged places for. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TaggedPlacesResultSet run() {
		JSONObject result = super.runWithResults();
		return new TaggedPlacesResultSet(result);
	}
	
}
