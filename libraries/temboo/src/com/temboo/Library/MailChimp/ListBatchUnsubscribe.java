package com.temboo.Library.MailChimp;

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
ListBatchUnsubscribe

Unsubscribes one or more members from a MailChimp list.
*/
public class ListBatchUnsubscribe extends Choreography {

	/**
	Create a new instance of the ListBatchUnsubscribe Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListBatchUnsubscribe(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/MailChimp/ListBatchUnsubscribe"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Mailchimp
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the DeleteMember input for this Choreo. 

	@param Boolean - (optional, boolean) A flag used to completely delete the member from your list instead of just unsubscribing. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setDeleteMember(Boolean value) {
		this.inputs.setInput("DeleteMember", value);
	}

	/** 
	Set the value of the DeleteMember input for this Choreo as a String. 

	@param String - (optional, boolean) A flag used to completely delete the member from your list instead of just unsubscribing. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setDeleteMember(String value) {
		this.inputs.setInput("DeleteMember", value);	
	}
	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address to unsubscribe from a Mailchimp list . Multiple emails can be supplied separated by commas.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the ListId input for this Choreo. 

	@param String - (required, string) The Mailchimp List ID
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);
	}


	/** 
	Set the value of the SendGoodbye input for this Choreo. 

	@param Boolean - (optional, boolean) A flag used to send the goodbye email to the email address. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setSendGoodbye(Boolean value) {
		this.inputs.setInput("SendGoodbye", value);
	}

	/** 
	Set the value of the SendGoodbye input for this Choreo as a String. 

	@param String - (optional, boolean) A flag used to send the goodbye email to the email address. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setSendGoodbye(String value) {
		this.inputs.setInput("SendGoodbye", value);	
	}
	/** 
	Set the value of the SendNotify input for this Choreo. 

	@param Boolean - (optional, boolean) A flag used to send the unsubscribe notification email to the address defined in the list email notification settings. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setSendNotify(Boolean value) {
		this.inputs.setInput("SendNotify", value);
	}

	/** 
	Set the value of the SendNotify input for this Choreo as a String. 

	@param String - (optional, boolean) A flag used to send the unsubscribe notification email to the address defined in the list email notification settings. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setSendNotify(String value) {
		this.inputs.setInput("SendNotify", value);	
	}
	/** 
	Set the value of the SupressErrors input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not to suppress errors that arise from attempting to unsubscribe an email address. Defaults to 0 (false). Set to 1 (true) to supress errors.
	*/
	public void setSupressErrors(Boolean value) {
		this.inputs.setInput("SupressErrors", value);
	}

	/** 
	Set the value of the SupressErrors input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not to suppress errors that arise from attempting to unsubscribe an email address. Defaults to 0 (false). Set to 1 (true) to supress errors.
	*/
	public void setSupressErrors(String value) {
		this.inputs.setInput("SupressErrors", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListBatchUnsubscribeResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListBatchUnsubscribeResultSet(result);
	}
	
}
