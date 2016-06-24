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
DeleteRow

Allows you to delete a specific row by its row number.
*/
public class DeleteRow extends Choreography {

	/**
	Create a new instance of the DeleteRow Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteRow(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Spreadsheets/DeleteRow"));
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
	Set the value of the DeleteLast input for this Choreo. 

	@param Boolean - (conditional, boolean) When set to "true", the last row in the list will be deleted. The Row input is ignored when using this flag.
	*/
	public void setDeleteLast(Boolean value) {
		this.inputs.setInput("DeleteLast", value);
	}

	/** 
	Set the value of the DeleteLast input for this Choreo as a String. 

	@param String - (conditional, boolean) When set to "true", the last row in the list will be deleted. The Row input is ignored when using this flag.
	*/
	public void setDeleteLast(String value) {
		this.inputs.setInput("DeleteLast", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (conditional, password) Deprecated (retained for backward compatibility only).
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
	Set the value of the Row input for this Choreo. 

	@param Integer - (conditional, integer) The number of the row to delete. Required unless using the DeleteLast flag. Note that row 1 (the column header row) cannot be deleted.
	*/
	public void setRow(Integer value) {
		this.inputs.setInput("Row", value);
	}

	/** 
	Set the value of the Row input for this Choreo as a String. 

	@param String - (conditional, integer) The number of the row to delete. Required unless using the DeleteLast flag. Note that row 1 (the column header row) cannot be deleted.
	*/
	public void setRow(String value) {
		this.inputs.setInput("Row", value);	
	}
	/** 
	Set the value of the SpreadsheetKey input for this Choreo. 

	@param String - (required, string) The unique key of the spreadsheet associated with the row you want to delete. This can be found in the URL when viewing the spreadsheet. Required unless SpreadsheetName and WorksheetName are supplied.
	*/
	public void setSpreadsheetKey(String value) {
		this.inputs.setInput("SpreadsheetKey", value);
	}


	/** 
	Set the value of the SpreadsheetName input for this Choreo. 

	@param String - (optional, string) The name of the spreadsheet to delete a row from. This and WorksheetName can be used as an alternative to SpreadsheetKey and WorksheetId to lookup spreadsheet details by name.
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

	@param String - (required, string) The unique ID of the worksheet that you want to delete from. Typically, Sheet1 has the id of "od6". Required unless SpreadsheetName and WorksheetName are supplied.
	*/
	public void setWorksheetId(String value) {
		this.inputs.setInput("WorksheetId", value);
	}


	/** 
	Set the value of the WorksheetName input for this Choreo. 

	@param String - (optional, string) The name of the worksheet to delete a row from. This and SpreadsheetName can be used as an alternative to SpreadsheetKey and WorksheetId to lookup spreadsheet details by name.
	*/
	public void setWorksheetName(String value) {
		this.inputs.setInput("WorksheetName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteRowResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteRowResultSet(result);
	}
	
}
