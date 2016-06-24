package com.temboo.Library.Google.Drive.Files;

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
Copy

Creates a copy of the specified file.
*/
public class Copy extends Choreography {

	/**
	Create a new instance of the Copy Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Copy(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Drive/Files/Copy"));
	}

	/** 
	Set the value of the RequestBody input for this Choreo. 

	@param String - (optional, json) A JSON representation of fields in a file resource. File metadata information (such as the title) can be set using this input. See documentation for formatting examples.
	*/
	public void setRequestBody(String value) {
		this.inputs.setInput("RequestBody", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Convert input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to convert this file to the corresponding Google Docs format. (Default: false).
	*/
	public void setConvert(Boolean value) {
		this.inputs.setInput("Convert", value);
	}

	/** 
	Set the value of the Convert input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to convert this file to the corresponding Google Docs format. (Default: false).
	*/
	public void setConvert(String value) {
		this.inputs.setInput("Convert", value);	
	}
	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying a subset of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the FileID input for this Choreo. 

	@param String - (required, string) The ID of the file to copy.
	*/
	public void setFileID(String value) {
		this.inputs.setInput("FileID", value);
	}


	/** 
	Set the value of the OCR input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to attempt OCR on .jpg, .png, .gif, or .pdf uploads. (Default: false)
	*/
	public void setOCR(Boolean value) {
		this.inputs.setInput("OCR", value);
	}

	/** 
	Set the value of the OCR input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to attempt OCR on .jpg, .png, .gif, or .pdf uploads. (Default: false)
	*/
	public void setOCR(String value) {
		this.inputs.setInput("OCR", value);	
	}
	/** 
	Set the value of the OcrLanguage input for this Choreo. 

	@param String - (optional, string) If ocr is true, hints at the language to use. Valid values are ISO 639-1 codes.
	*/
	public void setOcrLanguage(String value) {
		this.inputs.setInput("OcrLanguage", value);
	}


	/** 
	Set the value of the Pinned input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to pin the head revision of the uploaded file. (Default: false).
	*/
	public void setPinned(Boolean value) {
		this.inputs.setInput("Pinned", value);
	}

	/** 
	Set the value of the Pinned input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to pin the head revision of the uploaded file. (Default: false).
	*/
	public void setPinned(String value) {
		this.inputs.setInput("Pinned", value);	
	}
	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the SourceLanguage input for this Choreo. 

	@param String - (optional, string) The language of the original file to be translated.
	*/
	public void setSourceLanguage(String value) {
		this.inputs.setInput("SourceLanguage", value);
	}


	/** 
	Set the value of the TargetLanguage input for this Choreo. 

	@param String - (optional, string) Target language to translate the file to. If no sourceLanguage is provided, the API will attempt to detect the language.
	*/
	public void setTargetLanguage(String value) {
		this.inputs.setInput("TargetLanguage", value);
	}


	/** 
	Set the value of the TimedTextLanguage input for this Choreo. 

	@param String - (optional, string) The language of the timed text.
	*/
	public void setTimedTextLanguage(String value) {
		this.inputs.setInput("TimedTextLanguage", value);
	}


	/** 
	Set the value of the TimedTextTrackName input for this Choreo. 

	@param String - (optional, string) The timed text track name.
	*/
	public void setTimedTextTrackName(String value) {
		this.inputs.setInput("TimedTextTrackName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CopyResultSet run() {
		JSONObject result = super.runWithResults();
		return new CopyResultSet(result);
	}
	
}
