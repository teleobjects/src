package com.temboo.Library.eBay.Trading;

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
UploadSiteHostedPictures

Allows you to uploads a picture to eBay Picture Services by specifying a binary attachment or image URL.
*/
public class UploadSiteHostedPictures extends Choreography {

	/**
	Create a new instance of the UploadSiteHostedPictures Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadSiteHostedPictures(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/UploadSiteHostedPictures"));
	}

	/** 
	Set the value of the ExtensionInDays input for this Choreo. 

	@param Integer - (optional, integer) The number of days to extend the expiration date for the specified image, after a listing has ended.
	*/
	public void setExtensionInDays(Integer value) {
		this.inputs.setInput("ExtensionInDays", value);
	}

	/** 
	Set the value of the ExtensionInDays input for this Choreo as a String. 

	@param String - (optional, integer) The number of days to extend the expiration date for the specified image, after a listing has ended.
	*/
	public void setExtensionInDays(String value) {
		this.inputs.setInput("ExtensionInDays", value);	
	}
	/** 
	Set the value of the ExternalPictureURL input for this Choreo. 

	@param String - (conditional, string) The URL of an image to upload. Required unless providing PictureData. Max image size is 7 MB. Max URL length is 1024. Formats supported are: JPG, GIF, PNG, BMP, and TIF.
	*/
	public void setExternalPictureURL(String value) {
		this.inputs.setInput("ExternalPictureURL", value);
	}


	/** 
	Set the value of the PictureData input for this Choreo. 

	@param String - (conditional, string) The Base64 encoded string for an the image data. Required unless providing the ExternalPictureURL. Max image size is 7 MB. Formats supported are: JPG, GIF, PNG, BMP, and TIF.
	*/
	public void setPictureData(String value) {
		this.inputs.setInput("PictureData", value);
	}


	/** 
	Set the value of the PictureName input for this Choreo. 

	@param String - (optional, string) The name of the picture.
	*/
	public void setPictureName(String value) {
		this.inputs.setInput("PictureName", value);
	}


	/** 
	Set the value of the PictureSet input for this Choreo. 

	@param String - (optional, string) The image sizes that will be generated. Valid values are: Standard and Supersize.
	*/
	public void setPictureSet(String value) {
		this.inputs.setInput("PictureSet", value);
	}


	/** 
	Set the value of the PictureUploadPolicy input for this Choreo. 

	@param String - (optional, string) Indicates that an uploaded picture is available to a seller on the eBay site. Valid values are: Add and ClearAndAdd.
	*/
	public void setPictureUploadPolicy(String value) {
		this.inputs.setInput("PictureUploadPolicy", value);
	}


	/** 
	Set the value of the PictureWatermark input for this Choreo. 

	@param String - (optional, string) The type of watermark that should be applied to the pictures hosted by the eBay Picture Services. Valid values are: User and Icon.
	*/
	public void setPictureWatermark(String value) {
		this.inputs.setInput("PictureWatermark", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SandboxMode input for this Choreo. 

	@param Boolean - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(Boolean value) {
		this.inputs.setInput("SandboxMode", value);
	}

	/** 
	Set the value of the SandboxMode input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(String value) {
		this.inputs.setInput("SandboxMode", value);	
	}
	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	/** 
	Set the value of the UserToken input for this Choreo. 

	@param String - (required, string) A valid eBay Auth Token.
	*/
	public void setUserToken(String value) {
		this.inputs.setInput("UserToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UploadSiteHostedPicturesResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadSiteHostedPicturesResultSet(result);
	}
	
}
