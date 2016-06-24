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
AddTranslationArray

Adds an array of translations to add translation memory.
*/
public class AddTranslationArray extends Choreography {

	/**
	Create a new instance of the AddTranslationArray Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddTranslationArray(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/Translator/AddTranslationArray"));
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

	@param String - (optional, string) The format of the text being translated. The supported formats are "text/plain" and "text/html".
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (required, string) A string containing the ISO 639-1 language code of the source language (e.g., en). Must be one of the languages returned by the method GetLanguagesForTranslate.
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
	Set the value of the To input for this Choreo. 

	@param String - (required, string) A string containing the ISO 639-1 language code of the target language (e.g., es). Must be one of the languages returned by the method GetLanguagesForTranslate.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	/** 
	Set the value of the Translations input for this Choreo. 

	@param String - (required, json) An array containing translations to add to translation memory. Each translation must contain: OriginalText, TranslatedText, and Rating. See Choreo description for formatting examples.
	*/
	public void setTranslations(String value) {
		this.inputs.setInput("Translations", value);
	}


	/** 
	Set the value of the URI input for this Choreo. 

	@param String - (optional, string) A string containing the content location of this translation.
	*/
	public void setURI(String value) {
		this.inputs.setInput("URI", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (required, string) A string used to track the originator of the submission.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddTranslationArrayResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddTranslationArrayResultSet(result);
	}
	
}
