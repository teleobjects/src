package com.temboo.Library.Twilio.ConnectApps;

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
UpdateConnectApp

Updates the details for an individual Connect App associated with a Twilio account.
*/
public class UpdateConnectApp extends Choreography {

	/**
	Create a new instance of the UpdateConnectApp Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateConnectApp(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/ConnectApps/UpdateConnectApp"));
	}

	/** 
	Set the value of the AccountSID input for this Choreo. 

	@param String - (required, string) The AccountSID provided when you signed up for a Twilio account.
	*/
	public void setAccountSID(String value) {
		this.inputs.setInput("AccountSID", value);
	}


	/** 
	Set the value of the AuthToken input for this Choreo. 

	@param String - (required, string) The authorization token provided when you signed up for a Twilio account.
	*/
	public void setAuthToken(String value) {
		this.inputs.setInput("AuthToken", value);
	}


	/** 
	Set the value of the AuthorizeRedirectURL input for this Choreo. 

	@param String - (optional, string) The URL the user's browser will redirect to after Twilio authenticates the user and obtains authorization for this Connect App.
	*/
	public void setAuthorizeRedirectURL(String value) {
		this.inputs.setInput("AuthorizeRedirectURL", value);
	}


	/** 
	Set the value of the CompanyName input for this Choreo. 

	@param String - (optional, string) The company name for this Connect App.
	*/
	public void setCompanyName(String value) {
		this.inputs.setInput("CompanyName", value);
	}


	/** 
	Set the value of the ConnectAppSID input for this Choreo. 

	@param String - (required, string) The id of the Connect App to update.
	*/
	public void setConnectAppSID(String value) {
		this.inputs.setInput("ConnectAppSID", value);
	}


	/** 
	Set the value of the DeauthorizeCallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method to be used when making a request to the DeauthorizeCallbackUrl. Either GET or POST.
	*/
	public void setDeauthorizeCallbackMethod(String value) {
		this.inputs.setInput("DeauthorizeCallbackMethod", value);
	}


	/** 
	Set the value of the DeauthorizeCallbackURL input for this Choreo. 

	@param String - (optional, string) The URL to which Twilio will send a request when a user de-authorizes this Connect App.
	*/
	public void setDeauthorizeCallbackURL(String value) {
		this.inputs.setInput("DeauthorizeCallbackURL", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A more detailed human readable description of the Connect App.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the FriendlyName input for this Choreo. 

	@param String - (optional, string) A human readable description of the Connect App, with maximum length 64 characters.
	*/
	public void setFriendlyName(String value) {
		this.inputs.setInput("FriendlyName", value);
	}


	/** 
	Set the value of the HomepageURL input for this Choreo. 

	@param String - (optional, string) The public URL where users can obtain more information about this Connect App.
	*/
	public void setHomepageURL(String value) {
		this.inputs.setInput("HomepageURL", value);
	}


	/** 
	Set the value of the Permissions input for this Choreo. 

	@param String - (optional, string) A comma-separated list of permssions you will request from users of this ConnectApp. Valid permssions are get-all or post-all.
	*/
	public void setPermissions(String value) {
		this.inputs.setInput("Permissions", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateConnectAppResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateConnectAppResultSet(result);
	}
	
}
