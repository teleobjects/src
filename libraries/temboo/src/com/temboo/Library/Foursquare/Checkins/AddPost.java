package com.temboo.Library.Foursquare.Checkins;

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
AddPost

Posts user-generated content from an external app to a Foursquare check-in.
*/
public class AddPost extends Choreography {

	/**
	Create a new instance of the AddPost Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddPost(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Checkins/AddPost"));
	}

	/** 
	Set the value of the CheckinID input for this Choreo. 

	@param String - (required, string) The ID of the check-in to add a post to.
	*/
	public void setCheckinID(String value) {
		this.inputs.setInput("CheckinID", value);
	}


	/** 
	Set the value of the ContentID input for this Choreo. 

	@param String - (optional, string) An ID for the post to be used in a native link. Can be up to 50 characters. The URL input must also be specified when using this parameter.
	*/
	public void setContentID(String value) {
		this.inputs.setInput("ContentID", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
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
	Set the value of the Text input for this Choreo. 

	@param String - (required, string) The text of the post. Max length is 200 characters.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (optional, string) A URL linking to more details. The following URL schemes are supported: http, https, foursquare, mailto, tel, and sms.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddPostResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddPostResultSet(result);
	}
	
}
