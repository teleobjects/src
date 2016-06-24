package com.temboo.Library.Nexmo.Account;

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
UpdateAccountSettings

Update your account settings.
*/
public class UpdateAccountSettings extends Choreography {

	/**
	Create a new instance of the UpdateAccountSettings Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateAccountSettings(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Nexmo/Account/UpdateAccountSettings"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) Your API Key provided to you by Nexmo.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) Your API Secret provided to you by Nexmo.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the DeliveryReceiptCallbackURL input for this Choreo. 

	@param String - (conditional, string) Your new Delivery Receipt Callback URL.
	*/
	public void setDeliveryReceiptCallbackURL(String value) {
		this.inputs.setInput("DeliveryReceiptCallbackURL", value);
	}


	/** 
	Set the value of the InboundCallbackURL input for this Choreo. 

	@param String - (conditional, string) Your new Inbound Callback URL.
	*/
	public void setInboundCallbackURL(String value) {
		this.inputs.setInput("InboundCallbackURL", value);
	}


	/** 
	Set the value of the NewSecret input for this Choreo. 

	@param String - (optional, string) Your new API secret. (8 characters max)
	*/
	public void setNewSecret(String value) {
		this.inputs.setInput("NewSecret", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "json" (the default) and "xml".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateAccountSettingsResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateAccountSettingsResultSet(result);
	}
	
}
