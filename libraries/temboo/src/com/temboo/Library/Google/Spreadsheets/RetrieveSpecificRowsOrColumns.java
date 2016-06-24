package com.temboo.Library.Google.Spreadsheets;

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
RetrieveSpecificRowsOrColumns

Retrieves specific rows or columns based on a specified range.
*/
public class RetrieveSpecificRowsOrColumns extends Choreography {

	/**
	Create a new instance of the RetrieveSpecificRowsOrColumns Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveSpecificRowsOrColumns(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Spreadsheets/RetrieveSpecificRowsOrColumns"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
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
	Set the value of the MaxColumn input for this Choreo. 

	@param Integer - (conditional, integer) The maximum column number for the cell range that you want to retrieve.
	*/
	public void setMaxColumn(Integer value) {
		this.inputs.setInput("MaxColumn", value);
	}

	/** 
	Set the value of the MaxColumn input for this Choreo as a String. 

	@param String - (conditional, integer) The maximum column number for the cell range that you want to retrieve.
	*/
	public void setMaxColumn(String value) {
		this.inputs.setInput("MaxColumn", value);	
	}
	/** 
	Set the value of the MaxRow input for this Choreo. 

	@param Integer - (conditional, integer) The maximum row number for the cell range that you want to retrieve.
	*/
	public void setMaxRow(Integer value) {
		this.inputs.setInput("MaxRow", value);
	}

	/** 
	Set the value of the MaxRow input for this Choreo as a String. 

	@param String - (conditional, integer) The maximum row number for the cell range that you want to retrieve.
	*/
	public void setMaxRow(String value) {
		this.inputs.setInput("MaxRow", value);	
	}
	/** 
	Set the value of the MinColumn input for this Choreo. 

	@param Integer - (conditional, integer) The minimum column number for the cell range you want to retrieve.
	*/
	public void setMinColumn(Integer value) {
		this.inputs.setInput("MinColumn", value);
	}

	/** 
	Set the value of the MinColumn input for this Choreo as a String. 

	@param String - (conditional, integer) The minimum column number for the cell range you want to retrieve.
	*/
	public void setMinColumn(String value) {
		this.inputs.setInput("MinColumn", value);	
	}
	/** 
	Set the value of the MinRow input for this Choreo. 

	@param Integer - (conditional, integer) The minimum row number for the cell range you want to retrieve.
	*/
	public void setMinRow(Integer value) {
		this.inputs.setInput("MinRow", value);
	}

	/** 
	Set the value of the MinRow input for this Choreo as a String. 

	@param String - (conditional, integer) The minimum row number for the cell range you want to retrieve.
	*/
	public void setMinRow(String value) {
		this.inputs.setInput("MinRow", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (optional, password) Deprecated (retained for backward compatibility only).
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SpreadsheetKey input for this Choreo. 

	@param String - (required, string) The unique key of the spreadsheet associated with the cells you want to retrieve.
	*/
	public void setSpreadsheetKey(String value) {
		this.inputs.setInput("SpreadsheetKey", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	/** 
	Set the value of the WorksheetId input for this Choreo. 

	@param String - (required, string) The unique ID of the worksheet associated with the cells you want to retrieve.
	*/
	public void setWorksheetId(String value) {
		this.inputs.setInput("WorksheetId", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveSpecificRowsOrColumnsResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveSpecificRowsOrColumnsResultSet(result);
	}
	
}
