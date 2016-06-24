package com.temboo.Library.Google.Plus.Domains.Activities;

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
Insert

Inserts a new activity into a user's stream.
*/
public class Insert extends Choreography {

	/**
	Create a new instance of the Insert Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Insert(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Plus/Domains/Activities/Insert"));
	}

	/** 
	Set the value of the ActivityResource input for this Choreo. 

	@param String - (optional, string) A JSON-formatted string containing the activity properties you wish to set. This can be used as an alternative to setting individual inputs representing resource properties.
	*/
	public void setActivityResource(String value) {
		this.inputs.setInput("ActivityResource", value);
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
	Set the value of the Content input for this Choreo. 

	@param String - (required, string) Content to post to your stream.
	*/
	public void setContent(String value) {
		this.inputs.setInput("Content", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description for the new activity being created.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Used to specify fields to include in a partial response. This can be used to reduce the amount of data returned. See documentation for syntax rules.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
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
	Set the value of the Preview input for this Choreo. 

	@param Boolean - (optional, boolean) If "true", extract the potential media attachments for a URL. The response will include all possible attachments for a URL, including video, photos, and articles based on the content of the page.
	*/
	public void setPreview(Boolean value) {
		this.inputs.setInput("Preview", value);
	}

	/** 
	Set the value of the Preview input for this Choreo as a String. 

	@param String - (optional, boolean) If "true", extract the potential media attachments for a URL. The response will include all possible attachments for a URL, including video, photos, and articles based on the content of the page.
	*/
	public void setPreview(String value) {
		this.inputs.setInput("Preview", value);	
	}
	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ShareWithDomain input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to share this activity with the entire Domain.
	*/
	public void setShareWithDomain(Boolean value) {
		this.inputs.setInput("ShareWithDomain", value);
	}

	/** 
	Set the value of the ShareWithDomain input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to share this activity with the entire Domain.
	*/
	public void setShareWithDomain(String value) {
		this.inputs.setInput("ShareWithDomain", value);	
	}
	/** 
	Set the value of the ShareWithExtendedCircles input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to share this activity your circles plus all the people in their circles.
	*/
	public void setShareWithExtendedCircles(Boolean value) {
		this.inputs.setInput("ShareWithExtendedCircles", value);
	}

	/** 
	Set the value of the ShareWithExtendedCircles input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to share this activity your circles plus all the people in their circles.
	*/
	public void setShareWithExtendedCircles(String value) {
		this.inputs.setInput("ShareWithExtendedCircles", value);	
	}
	/** 
	Set the value of the ShareWithMyCircles input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to share this activity with everyone in your Circles.
	*/
	public void setShareWithMyCircles(Boolean value) {
		this.inputs.setInput("ShareWithMyCircles", value);
	}

	/** 
	Set the value of the ShareWithMyCircles input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to share this activity with everyone in your Circles.
	*/
	public void setShareWithMyCircles(String value) {
		this.inputs.setInput("ShareWithMyCircles", value);	
	}
	/** 
	Set the value of the ShareWithPublic input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to share this activity with everyone on the web.
	*/
	public void setShareWithPublic(Boolean value) {
		this.inputs.setInput("ShareWithPublic", value);
	}

	/** 
	Set the value of the ShareWithPublic input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to share this activity with everyone on the web.
	*/
	public void setShareWithPublic(String value) {
		this.inputs.setInput("ShareWithPublic", value);	
	}
	/** 
	Set the value of the ShareWithTheseCircles input for this Choreo. 

	@param String - (optional, string) Comma-seperated list of up to 10 IDs of the circles you want to share this activity with.
	*/
	public void setShareWithTheseCircles(String value) {
		this.inputs.setInput("ShareWithTheseCircles", value);
	}


	/** 
	Set the value of the ShareWithThesePeople input for this Choreo. 

	@param String - (optional, string) Comma-seperated list of up to 10 IDs of persons you want to share this activity with.
	*/
	public void setShareWithThesePeople(String value) {
		this.inputs.setInput("ShareWithThesePeople", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the user to create a circle for. The value "me" is set as the default to indicate the authenticated user.
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
	public InsertResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertResultSet(result);
	}
	
}
