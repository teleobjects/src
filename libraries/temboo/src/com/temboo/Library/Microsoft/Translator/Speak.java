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
Speak

Returns a Base64 encoded wave or mp3 file of the passed-in text being spoken in the desired language.
*/
public class Speak extends Choreography {

	/**
	Create a new instance of the Speak Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Speak(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/Translator/Speak"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token. This can be retrieved by running the GetToken Choreo. Required unless providing the ClientID and ClientSecret.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
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
	Set the value of the Format input for this Choreo. 

	@param String - (optional, string) A string specifying the content-type. Currently, "audio/wav" and "audio/mp3" are available. The default value is "audio/wav".
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (required, string) A string representing the supported ISO 639-1 language code to speak the text in (e.g., es). The code must be present in the list of codes returned from the method GetLanguagesForSpeak.
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the Options input for this Choreo. 

	@param String - (optional, string) A string specifying the quality of the audio signals. Valid values are: MaxQuality or MinQuality (the default).
	*/
	public void setOptions(String value) {
		this.inputs.setInput("Options", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (required, string) A string representing the text to translate. The size of the text must not exceed 10000 characters.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SpeakResultSet run() {
		JSONObject result = super.runWithResults();
		return new SpeakResultSet(result);
	}
	
}
