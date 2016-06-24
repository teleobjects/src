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
UpdatePhoto

Updates the user's profile photo.
*/
public class UpdatePhoto extends Choreography {

	/**
	Create a new instance of the UpdatePhoto Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdatePhoto(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Users/UpdatePhoto"));
	}

	/** 
	Set the value of the ContentType input for this Choreo. 

	@param String - (required, string) The content type of the image. Valid types are: image/jpeg, image/gif, or image/png.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API Oauth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the Photo input for this Choreo. 

	@param String - (conditional, string) The Base64-encoded contents of the image you want to upload. Total Image size (before encoding) must be under 100KB.
	*/
	public void setPhoto(String value) {
		this.inputs.setInput("Photo", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ImageAlias input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdatePhotoResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdatePhotoResultSet(result);
	}
	
}
