package com.temboo.Library.Nexmo.Voice;

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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the CaptureTextToSpeechPrompt Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class CaptureTextToSpeechPromptResultSet extends ResultSet {
		
	public CaptureTextToSpeechPromptResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "CallbackData" output from this Choreo execution

	@return String - The Nexmo callback data retrieved after a user has entered a pin code. Note that this will only be returned when the CallbackURL input  is not provided.
	*/
	public String getCallbackData() {
		return this.getResultString("CallbackData");
	}
	/** 
	Retrieve the value for the "Digits" output from this Choreo execution

	@return String - (integer) The digits that the call recipient entered into the keypad after receiving the call from Nexmo.
	*/
	public String getDigits() {
		return this.getResultString("Digits");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Nexmo. Corresponds to the ResponseFormat input. Defaults to json.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}