package com.temboo.Library.YouTube.VideoCategories;

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
ListCategoriesByRegion

Returns a list of categories available in the specified country.
*/
public class ListCategoriesByRegion extends Choreography {

	/**
	Create a new instance of the ListCategoriesByRegion Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListCategoriesByRegion(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/YouTube/VideoCategories/ListCategoriesByRegion"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The API Key provided by Google for simple API access when you do not need to access user data.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required for OAuth authentication unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required for OAuth authentication unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required for OAuth authentication unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Allows you to specify a subset of fields to include in the response using an xpath-like syntax (i.e. items/snippet/title).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the H1 input for this Choreo. 

	@param String - (optional, string) The hl parameter specifies the language that should be used for text values in the API response. The default value is en_US.
	*/
	public void setH1(String value) {
		this.inputs.setInput("H1", value);
	}


	/** 
	Set the value of the Part input for this Choreo. 

	@param String - (optional, string) Specifies the videoCategory resource parts that the API response will include. Valid values are: id and snippet.
	*/
	public void setPart(String value) {
		this.inputs.setInput("Part", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required for OAuth authentication unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the RegionCode input for this Choreo. 

	@param String - (conditional, string) Indicates to return the list of video categories available in the specified country. The parameter value is an ISO 3166-1 alpha-2 country code.
	*/
	public void setRegionCode(String value) {
		this.inputs.setInput("RegionCode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListCategoriesByRegionResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListCategoriesByRegionResultSet(result);
	}
	
}
