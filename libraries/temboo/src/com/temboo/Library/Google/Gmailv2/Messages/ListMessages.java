package com.temboo.Library.Google.Gmailv2.Messages;

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
ListMessages

Lists the messages in the user's mailbox.
*/
public class ListMessages extends Choreography {

	/**
	Create a new instance of the ListMessages Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListMessages(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Gmailv2/Messages/ListMessages"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
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
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Used to specify fields to include in a partial response. This can be used to reduce the amount of data returned. See Choreo notes for syntax rules.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IncludeSpamTrash input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to include messages from SPAM and TRASH in the results. Defaults to "false".
	*/
	public void setIncludeSpamTrash(Boolean value) {
		this.inputs.setInput("IncludeSpamTrash", value);
	}

	/** 
	Set the value of the IncludeSpamTrash input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to include messages from SPAM and TRASH in the results. Defaults to "false".
	*/
	public void setIncludeSpamTrash(String value) {
		this.inputs.setInput("IncludeSpamTrash", value);	
	}
	/** 
	Set the value of the LabelIDs input for this Choreo. 

	@param String - (optional, json) A JSON array containing labels to filter by. When specified, only messages with labels that match are returned.
	*/
	public void setLabelIDs(String value) {
		this.inputs.setInput("LabelIDs", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of results to return.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of results to return.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) The "nextPageToken" found in the response which is used to page through results.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) Filters messages that match the specified query. Supports the same query format as the Gmail search box. For example, "from:someuser@example.com rfc822msgid: is:unread".
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the acting user. Defaults to "me" indicating the user associated with the Access Token or Refresh Token provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListMessagesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListMessagesResultSet(result);
	}
	
}
