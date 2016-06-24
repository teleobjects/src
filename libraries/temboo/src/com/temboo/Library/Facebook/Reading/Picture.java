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
Picture

Retrieves a person's profile picture.
*/
public class Picture extends Choreography {

	/**
	Create a new instance of the Picture Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Picture(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Reading/Picture"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The access token retrieved from the final step of the OAuth process. This is not required when providing a ProfileID.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Height input for this Choreo. 

	@param Integer - (optional, integer) Restricts the picture height to this size in pixels.
	*/
	public void setHeight(Integer value) {
		this.inputs.setInput("Height", value);
	}

	/** 
	Set the value of the Height input for this Choreo as a String. 

	@param String - (optional, integer) Restricts the picture height to this size in pixels.
	*/
	public void setHeight(String value) {
		this.inputs.setInput("Height", value);	
	}
	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (conditional, string) The id of the profile to retrieve a profile picture for. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the Redirect input for this Choreo. 

	@param Boolean - (optional, boolean) By default, the picture itself is returned as Base64 encoded data.and not a JSON. To return a JSON response, set Redirect to "false".
	*/
	public void setRedirect(Boolean value) {
		this.inputs.setInput("Redirect", value);
	}

	/** 
	Set the value of the Redirect input for this Choreo as a String. 

	@param String - (optional, boolean) By default, the picture itself is returned as Base64 encoded data.and not a JSON. To return a JSON response, set Redirect to "false".
	*/
	public void setRedirect(String value) {
		this.inputs.setInput("Redirect", value);	
	}
	/** 
	Set the value of the ReturnSSLResources input for this Choreo. 

	@param Boolean - (optional, boolean) Deprecated (retained for backward compatibility only).
	*/
	public void setReturnSSLResources(Boolean value) {
		this.inputs.setInput("ReturnSSLResources", value);
	}

	/** 
	Set the value of the ReturnSSLResources input for this Choreo as a String. 

	@param String - (optional, boolean) Deprecated (retained for backward compatibility only).
	*/
	public void setReturnSSLResources(String value) {
		this.inputs.setInput("ReturnSSLResources", value);	
	}
	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) The size of the image to retrieve. Valid values: square (50x50), small (50 pixels wide, variable height), normal (100 pixels wide, variable height), and large (about 200 pixels wide, variable height)
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the Width input for this Choreo. 

	@param Integer - (optional, integer) Restricts the picture width to this size in pixels. When Height and Width are both used, the image will be scaled as close to the dimensions as possible and then cropped down.
	*/
	public void setWidth(Integer value) {
		this.inputs.setInput("Width", value);
	}

	/** 
	Set the value of the Width input for this Choreo as a String. 

	@param String - (optional, integer) Restricts the picture width to this size in pixels. When Height and Width are both used, the image will be scaled as close to the dimensions as possible and then cropped down.
	*/
	public void setWidth(String value) {
		this.inputs.setInput("Width", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PictureResultSet run() {
		JSONObject result = super.runWithResults();
		return new PictureResultSet(result);
	}
	
}
