package com.temboo.Library.Google.Plus.Domains.Audiences;

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
List

Lists all of the audiences with which a user can share.
*/
public class List extends Choreography {

	/**
	Create a new instance of the List Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public List(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Plus/Domains/Audiences/List"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Callback input for this Choreo. 

	@param String - (optional, string) Specifies a JavaScript function that will be passed the response data for using the API with JSONP.
	*/
	public void setCallback(String value) {
		this.inputs.setInput("Callback", value);
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

	@param String - (optional, string) Used to specify fields to include in a partial response. This can be used to reduce the amount of data returned. See documentation for syntax rules.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of circles to include in the response. Used for paging through results. Valid values are: 1 to 20. Default is 10.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of circles to include in the response. Used for paging through results. Valid values are: 1 to 20. Default is 10.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the OrderBy input for this Choreo. 

	@param String - (optional, string) The order to return results in. Valid values are: alphabetical and best.
	*/
	public void setOrderBy(String value) {
		this.inputs.setInput("OrderBy", value);
	}


	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) The "NextPageToken" returned in the Choreo output. Used to page through large result sets.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the PrettyPrint input for this Choreo. 

	@param Boolean - (optional, boolean) A flag used to pretty print the JSON response to make it more readable. Defaults to "true".
	*/
	public void setPrettyPrint(Boolean value) {
		this.inputs.setInput("PrettyPrint", value);
	}

	/** 
	Set the value of the PrettyPrint input for this Choreo as a String. 

	@param String - (optional, boolean) A flag used to pretty print the JSON response to make it more readable. Defaults to "true".
	*/
	public void setPrettyPrint(String value) {
		this.inputs.setInput("PrettyPrint", value);	
	}
	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the user to get circles for. The value "me" is set as the default to indicate the authenticated user.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the UserIP input for this Choreo. 

	@param String - (optional, string) Identifies the IP address of the end user for whom the API call is being made. Used to enforce per-user quotas.
	*/
	public void setUserIP(String value) {
		this.inputs.setInput("UserIP", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListResultSet(result);
	}
	
}
