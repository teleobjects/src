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
GetMemberMessages

Retrieves a list of the messages that buyers have posted about your active item listings.
*/
public class GetMemberMessages extends Choreography {

	/**
	Create a new instance of the GetMemberMessages Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetMemberMessages(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/GetMemberMessages"));
	}

	/** 
	Set the value of the DisplayToPublic input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, only public messages (viewable in the Item listing) are returned.
	*/
	public void setDisplayToPublic(Boolean value) {
		this.inputs.setInput("DisplayToPublic", value);
	}

	/** 
	Set the value of the DisplayToPublic input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, only public messages (viewable in the Item listing) are returned.
	*/
	public void setDisplayToPublic(String value) {
		this.inputs.setInput("DisplayToPublic", value);	
	}
	/** 
	Set the value of the EndCreationTime input for this Choreo. 

	@param String - (optional, date) Used to filter by date range (e.g., 2013-02-08T00:00:00.000Z).
	*/
	public void setEndCreationTime(String value) {
		this.inputs.setInput("EndCreationTime", value);
	}


	/** 
	Set the value of the EntriesPerPage input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of records to return in the result.
	*/
	public void setEntriesPerPage(Integer value) {
		this.inputs.setInput("EntriesPerPage", value);
	}

	/** 
	Set the value of the EntriesPerPage input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of records to return in the result.
	*/
	public void setEntriesPerPage(String value) {
		this.inputs.setInput("EntriesPerPage", value);	
	}
	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (optional, string) The ID of the item the message is about.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the MailMessageType input for this Choreo. 

	@param String - (required, string) The type of message to retrieve. Valid values are: All and AskSellerQuestion. When set to AskSellerQuestion, ItemID or a date range filter must be specified.
	*/
	public void setMailMessageType(String value) {
		this.inputs.setInput("MailMessageType", value);
	}


	/** 
	Set the value of the MemberMessageID input for this Choreo. 

	@param String - (optional, string) An ID that uniquely identifies the message for a given user to be retrieved.
	*/
	public void setMemberMessageID(String value) {
		this.inputs.setInput("MemberMessageID", value);
	}


	/** 
	Set the value of the MessageStatus input for this Choreo. 

	@param String - (optional, string) The status of the message. Valid values are: Answered and Unanswered.
	*/
	public void setMessageStatus(String value) {
		this.inputs.setInput("MessageStatus", value);
	}


	/** 
	Set the value of the PageNumber input for this Choreo. 

	@param Integer - (optional, integer) Specifies the page number of the results to return.
	*/
	public void setPageNumber(Integer value) {
		this.inputs.setInput("PageNumber", value);
	}

	/** 
	Set the value of the PageNumber input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the page number of the results to return.
	*/
	public void setPageNumber(String value) {
		this.inputs.setInput("PageNumber", value);	
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
	Set the value of the SenderID input for this Choreo. 

	@param String - (optional, string) The seller's UserID.
	*/
	public void setSenderID(String value) {
		this.inputs.setInput("SenderID", value);
	}


	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	/** 
	Set the value of the StartCreationTime input for this Choreo. 

	@param String - (optional, date) Used to filter by date range (e.g., 2013-02-08T00:00:00.000Z).
	*/
	public void setStartCreationTime(String value) {
		this.inputs.setInput("StartCreationTime", value);
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
	public GetMemberMessagesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetMemberMessagesResultSet(result);
	}
	
}
