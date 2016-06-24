package com.temboo.Library.Flickr.Photos;

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
Download

Retrieves a photo from a constructed source URL and returns the file content as Base64 encoded data.
*/
public class Download extends Choreography {

	/**
	Create a new instance of the Download Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Download(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/Download"));
	}

	/** 
	Set the value of the FarmID input for this Choreo. 

	@param Integer - (conditional, integer) The farm id associated with the photo. Required unless providing the URL.
	*/
	public void setFarmID(Integer value) {
		this.inputs.setInput("FarmID", value);
	}

	/** 
	Set the value of the FarmID input for this Choreo as a String. 

	@param String - (conditional, integer) The farm id associated with the photo. Required unless providing the URL.
	*/
	public void setFarmID(String value) {
		this.inputs.setInput("FarmID", value);	
	}
	/** 
	Set the value of the ImageType input for this Choreo. 

	@param String - (optional, string) The image type. Valid values are: jpg, png, or gif. Defaults to "jpg".
	*/
	public void setImageType(String value) {
		this.inputs.setInput("ImageType", value);
	}


	/** 
	Set the value of the PhotoID input for this Choreo. 

	@param Integer - (conditional, integer) The id of the photo you to download.
	*/
	public void setPhotoID(Integer value) {
		this.inputs.setInput("PhotoID", value);
	}

	/** 
	Set the value of the PhotoID input for this Choreo as a String. 

	@param String - (conditional, integer) The id of the photo you to download.
	*/
	public void setPhotoID(String value) {
		this.inputs.setInput("PhotoID", value);	
	}
	/** 
	Set the value of the Secret input for this Choreo. 

	@param String - (conditional, string) The secret associated with the photo. Required unless providing the URL.
	*/
	public void setSecret(String value) {
		this.inputs.setInput("Secret", value);
	}


	/** 
	Set the value of the ServerID input for this Choreo. 

	@param Integer - (conditional, integer) The server id associated with the photo. Required unless providing the URL.
	*/
	public void setServerID(Integer value) {
		this.inputs.setInput("ServerID", value);
	}

	/** 
	Set the value of the ServerID input for this Choreo as a String. 

	@param String - (conditional, integer) The server id associated with the photo. Required unless providing the URL.
	*/
	public void setServerID(String value) {
		this.inputs.setInput("ServerID", value);	
	}
	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) The url to download the photo from. Required unless providing the Secret, ServerID, and FarmID parameters.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DownloadResultSet run() {
		JSONObject result = super.runWithResults();
		return new DownloadResultSet(result);
	}
	
}
