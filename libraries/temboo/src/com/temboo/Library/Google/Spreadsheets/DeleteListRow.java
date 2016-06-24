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
DeleteListRow

Deletes a specified worksheet row from a Google spreadsheet.
*/
public class DeleteListRow extends Choreography {

	/**
	Create a new instance of the DeleteListRow Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteListRow(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Spreadsheets/DeleteListRow"));
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
	Set the value of the EditLink input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setEditLink(String value) {
		this.inputs.setInput("EditLink", value);
	}


	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (optional, string) The entry's resource URL found in the link element of the entry. Can be retrieved by running RetrieveListFeed Choreo. When this is provided, SpreadsheetKey, WorksheetId, and RowId are not needed.
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
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
	Set the value of the RowId input for this Choreo. 

	@param String - (conditional, string) The unique ID of the row you want to delete. Required unless providing the Link input.
	*/
	public void setRowId(String value) {
		this.inputs.setInput("RowId", value);
	}


	/** 
	Set the value of the SpreadsheetKey input for this Choreo. 

	@param String - (conditional, string) The unique key of the spreadsheet associated with the row you want to delete. This can be found in the URL when viewing the spreadsheet. Required unless providing the Link input.
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

	@param String - (conditional, string) The unique ID of the worksheet associated with the row you want to delete. Typically, Sheet1 has the id of "od6". Required unless providing the Link input.
	*/
	public void setWorksheetId(String value) {
		this.inputs.setInput("WorksheetId", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteListRowResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteListRowResultSet(result);
	}
	
}
