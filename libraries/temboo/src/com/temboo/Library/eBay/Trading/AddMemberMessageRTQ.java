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
AddMemberMessageRTQ

Allows a seller to reply to a question about an active item listing.
*/
public class AddMemberMessageRTQ extends Choreography {

	/**
	Create a new instance of the AddMemberMessageRTQ Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddMemberMessageRTQ(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/AddMemberMessageRTQ"));
	}

	/** 
	Set the value of the Body input for this Choreo. 

	@param String - (required, string) The message body which should answer the question that an eBay user ask the seller. HTML is not allowed.
	*/
	public void setBody(String value) {
		this.inputs.setInput("Body", value);
	}


	/** 
	Set the value of the DisplayToPublic input for this Choreo. 

	@param String - (optional, string) When set to true, this indicates that the member message is viewable in the item listing.
	*/
	public void setDisplayToPublic(String value) {
		this.inputs.setInput("DisplayToPublic", value);
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

	@param String - (optional, string) The unique ID of the item about which the question was asked.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the ParentMessageID input for this Choreo. 

	@param String - (required, string) The ID number of the question to which this message is responding.
	*/
	public void setParentMessageID(String value) {
		this.inputs.setInput("ParentMessageID", value);
	}


	/** 
	Set the value of the RecipientID input for this Choreo. 

	@param String - (required, string) The recipient's eBay user ID.
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
	public AddMemberMessageRTQResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddMemberMessageRTQResultSet(result);
	}
	
}
