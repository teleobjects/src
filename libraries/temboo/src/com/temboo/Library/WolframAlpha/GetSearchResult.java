package com.temboo.Library.WolframAlpha;

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
GetSearchResult

Allows your application to submit a query to Wolfram|Alpha and return only the plain text from the first result pod.
*/
public class GetSearchResult extends Choreography {

	/**
	Create a new instance of the GetSearchResult Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetSearchResult(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/WolframAlpha/GetSearchResult"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The App ID provided by Wolfram|Alpha.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the Input input for this Choreo. 

	@param String - (required, string) Specifies the input string (e.g., "5 largest countries").
	*/
	public void setInput(String value) {
		this.inputs.setInput("Input", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) When query results depend on your location, use this parameter to specify a latitude point.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) When query results depend on your location, use this parameter to specify a latitude point.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Location input for this Choreo. 

	@param String - (optional, string) When query results depend on your location, use this parameter to specify a location such as "Los Angeles, CA", or "Madrid".
	*/
	public void setLocation(String value) {
		this.inputs.setInput("Location", value);
	}


	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) When query results depend on your location, use this parameter to specify a longitude point.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) When query results depend on your location, use this parameter to specify a longitude point.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format for the response. Valid values are JSON and XML. This will be ignored when providng an XPath query because results are returned as a string or JSON depending on the Mode specified.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Translation input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to allow Wolfram Alpha to try to translate simple queries into English. Defaults to true.
	*/
	public void setTranslation(Boolean value) {
		this.inputs.setInput("Translation", value);
	}

	/** 
	Set the value of the Translation input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to allow Wolfram Alpha to try to translate simple queries into English. Defaults to true.
	*/
	public void setTranslation(String value) {
		this.inputs.setInput("Translation", value);	
	}
	/** 
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) Lets you specify the preferred measurement system, either "metric" or "nonmetric" (U.S. customary units).
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetSearchResultResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetSearchResultResultSet(result);
	}
	
}
