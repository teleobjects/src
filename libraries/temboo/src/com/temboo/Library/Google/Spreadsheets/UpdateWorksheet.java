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
UpdateWorksheet

Updates existing worksheet metadata such as: Title, Row Count, and Column Count.
*/
public class UpdateWorksheet extends Choreography {

	/**
	Create a new instance of the UpdateWorksheet Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateWorksheet(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Spreadsheets/UpdateWorksheet"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This is required when authenticating with OAuth unless providing the ClientID, ClientSecret, and RefreshToken.
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
	Set the value of the ColumnCount input for this Choreo. 

	@param Integer - (required, integer) The number of columns that you want to specify for the worksheet.
	*/
	public void setColumnCount(Integer value) {
		this.inputs.setInput("ColumnCount", value);
	}

	/** 
	Set the value of the ColumnCount input for this Choreo as a String. 

	@param String - (required, integer) The number of columns that you want to specify for the worksheet.
	*/
	public void setColumnCount(String value) {
		this.inputs.setInput("ColumnCount", value);	
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
	Set the value of the RowCount input for this Choreo. 

	@param Integer - (required, integer) The number of rows that you want to specify for the worksheet.
	*/
	public void setRowCount(Integer value) {
		this.inputs.setInput("RowCount", value);
	}

	/** 
	Set the value of the RowCount input for this Choreo as a String. 

	@param String - (required, integer) The number of rows that you want to specify for the worksheet.
	*/
	public void setRowCount(String value) {
		this.inputs.setInput("RowCount", value);	
	}
	/** 
	Set the value of the SpreadsheetKey input for this Choreo. 

	@param String - (required, string) The unique key associated with the spreadsheet that contains a worksheet you want to update.
	*/
	public void setSpreadsheetKey(String value) {
		this.inputs.setInput("SpreadsheetKey", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (required, string) The new title of the worksheet.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	/** 
	Set the value of the WorksheetId input for this Choreo. 

	@param String - (required, string) The unique ID associated with the worksheet that you want to update.
	*/
	public void setWorksheetId(String value) {
		this.inputs.setInput("WorksheetId", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateWorksheetResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateWorksheetResultSet(result);
	}
	
}
