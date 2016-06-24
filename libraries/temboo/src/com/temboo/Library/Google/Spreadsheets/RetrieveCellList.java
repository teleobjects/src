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
RetrieveCellList

Retrieves a list of cell values using the specified cell locations.
*/
public class RetrieveCellList extends Choreography {

	/**
	Create a new instance of the RetrieveCellList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveCellList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Spreadsheets/RetrieveCellList"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the CellLocations input for this Choreo. 

	@param String - (required, string) A comma-separated list of cell locations to retrieve (e.g. A2,B4,C3).
	*/
	public void setCellLocations(String value) {
		this.inputs.setInput("CellLocations", value);
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
	Set the value of the SpreadsheetKey input for this Choreo. 

	@param String - (conditional, string) The unique key of the spreadsheet associated with the cells you want to retrieve. Required unless SpreadsheetName and WorksheetName are supplied.
	*/
	public void setSpreadsheetKey(String value) {
		this.inputs.setInput("SpreadsheetKey", value);
	}


	/** 
	Set the value of the SpreadsheetName input for this Choreo. 

	@param String - (optional, string) The name of the spreadsheet containing the cells to retrieve. This and WorksheetName can be used as an alternative to SpreadsheetKey and WorksheetId to lookup spreadsheet details by name.
	*/
	public void setSpreadsheetName(String value) {
		this.inputs.setInput("SpreadsheetName", value);
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

	@param String - (conditional, string) The unique ID of the worksheet associated with the cells you want to retrieve. Required unless SpreadsheetName and WorksheetName are supplied.
	*/
	public void setWorksheetId(String value) {
		this.inputs.setInput("WorksheetId", value);
	}


	/** 
	Set the value of the WorksheetName input for this Choreo. 

	@param String - (optional, string) The name of the worksheet containing the cells to retrieve. This and SpreadsheetName can be used as an alternative to SpreadsheetKey and WorksheetId to lookup the spreadsheet details by name.
	*/
	public void setWorksheetName(String value) {
		this.inputs.setInput("WorksheetName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveCellListResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveCellListResultSet(result);
	}
	
}
