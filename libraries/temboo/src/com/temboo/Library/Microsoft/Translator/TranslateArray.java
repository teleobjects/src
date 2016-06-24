package com.temboo.Library.Microsoft.Translator;

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
TranslateArray

Translates multiple source texts.
*/
public class TranslateArray extends Choreography {

	/**
	Create a new instance of the TranslateArray Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TranslateArray(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/Translator/TranslateArray"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token. This can be retrieved by running the GetToken Choreo. Required unless providing the ClientID and ClientSecret.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Category input for this Choreo. 

	@param String - (optional, string) A string containing the category (domain) of the translation. Defaults to "general".
	*/
	public void setCategory(String value) {
		this.inputs.setInput("Category", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID obtained when signing up for Microsoft Translator on Azure Marketplace. This is required unless providing an AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret obtained when signing up for Microsoft Translator on Azure Marketplace. This is required unless providing an AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the ContentType input for this Choreo. 

	@param String - (optional, string) The format of the text being translated. The supported formats are "text/plain" (the default) and "text/html".
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (optional, string) A string representing the language code of the translation text (e.g., en). If not provided auto-detection is used.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Texts input for this Choreo. 

	@param String - (required, json) An array containing the texts for translation. All strings must be of the same language. The total of all texts must not exceed 10000 characters. The max number of array items is 2000.
	*/
	public void setTexts(String value) {
		this.inputs.setInput("Texts", value);
	}


	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) A string representing the ISO 639-1 language code to translate the text into (e.g., es).
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	/** 
	Set the value of the URI input for this Choreo. 

	@param String - (optional, string) Filter results by this URI. Default: all
	*/
	public void setURI(String value) {
		this.inputs.setInput("URI", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (optional, multiline) Filter results by this user. Default: all
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TranslateArrayResultSet run() {
		JSONObject result = super.runWithResults();
		return new TranslateArrayResultSet(result);
	}
	
}
