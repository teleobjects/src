package com.temboo.Library.eBay.Trading;

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
AddMemberMessageAAQToPartner

Allows a buyer and seller in an order relationship to send messages to each other's My Messages Inboxes.
*/
public class AddMemberMessageAAQToPartner extends Choreography {

	/**
	Create a new instance of the AddMemberMessageAAQToPartner Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddMemberMessageAAQToPartner(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/AddMemberMessageAAQToPartner"));
	}

	/** 
	Set the value of the Body input for this Choreo. 

	@param String - (required, string) The message body.
	*/
	public void setBody(String value) {
		this.inputs.setInput("Body", value);
	}


	/** 
	Set the value of the EmailCopyToSender input for this Choreo. 

	@param Boolean - (optional, boolean) A flag used to indicate that a copy should be sent to the sender.
	*/
	public void setEmailCopyToSender(Boolean value) {
		this.inputs.setInput("EmailCopyToSender", value);
	}

	/** 
	Set the value of the EmailCopyToSender input for this Choreo as a String. 

	@param String - (optional, boolean) A flag used to indicate that a copy should be sent to the sender.
	*/
	public void setEmailCopyToSender(String value) {
		this.inputs.setInput("EmailCopyToSender", value);	
	}
	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (required, string) The unique ID of the item about which the question was asked.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the QuestionType input for this Choreo. 

	@param String - (required, string) The type of question. Valid values are: General, Shipping, Payment, MultipleItemShipping, CustomizedSubject, or None.
	*/
	public void setQuestionType(String value) {
		this.inputs.setInput("QuestionType", value);
	}


	/** 
	Set the value of the RecipientID input for this Choreo. 

	@param String - (required, string) The user ID of the message recipient.
	*/
	public void setRecipientID(String value) {
		this.inputs.setInput("RecipientID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SandboxMode input for this Choreo. 

	@param Boolean - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(Boolean value) {
		this.inputs.setInput("SandboxMode", value);
	}

	/** 
	Set the value of the SandboxMode input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(String value) {
		this.inputs.setInput("SandboxMode", value);	
	}
	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (required, string) The message subject.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	/** 
	Set the value of the UserToken input for this Choreo. 

	@param String - (required, string) A valid eBay Auth Token.
	*/
	public void setUserToken(String value) {
		this.inputs.setInput("UserToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddMemberMessageAAQToPartnerResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddMemberMessageAAQToPartnerResultSet(result);
	}
	
}
