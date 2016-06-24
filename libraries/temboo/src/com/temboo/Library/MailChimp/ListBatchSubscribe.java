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
ListBatchSubscribe

Adds or updates multiple Mailchimp list subscribers.
*/
public class ListBatchSubscribe extends Choreography {

	/**
	Create a new instance of the ListBatchSubscribe Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListBatchSubscribe(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/MailChimp/ListBatchSubscribe"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Mailchimp
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the DoubleOptIn input for this Choreo. 

	@param Boolean - (optional, boolean) Flag to control whether a double opt-in confirmation message is sent. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setDoubleOptIn(Boolean value) {
		this.inputs.setInput("DoubleOptIn", value);
	}

	/** 
	Set the value of the DoubleOptIn input for this Choreo as a String. 

	@param String - (optional, boolean) Flag to control whether a double opt-in confirmation message is sent. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setDoubleOptIn(String value) {
		this.inputs.setInput("DoubleOptIn", value);	
	}
	/** 
	Set the value of the EmailType input for this Choreo. 

	@param String - (optional, string) Must be one of 'text', 'html', or 'mobile'. Defaults to html.
	*/
	public void setEmailType(String value) {
		this.inputs.setInput("EmailType", value);
	}


	/** 
	Set the value of the ListId input for this Choreo. 

	@param String - (required, string) The id of the Mailchimp list the subscribers will be added to.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);
	}


	/** 
	Set the value of the ReplaceInterests input for this Choreo. 

	@param Boolean - (optional, boolean) A flag to determine whether to replace the interest groups with the groups provided or add the provided groups to the member's interest groups. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setReplaceInterests(Boolean value) {
		this.inputs.setInput("ReplaceInterests", value);
	}

	/** 
	Set the value of the ReplaceInterests input for this Choreo as a String. 

	@param String - (optional, boolean) A flag to determine whether to replace the interest groups with the groups provided or add the provided groups to the member's interest groups. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setReplaceInterests(String value) {
		this.inputs.setInput("ReplaceInterests", value);	
	}
	/** 
	Set the value of the SendWelcome input for this Choreo. 

	@param Boolean - (optional, boolean) If double_optin is false and this flag is true, a welcome email will be sent. Note that this does not apply when updating records. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setSendWelcome(Boolean value) {
		this.inputs.setInput("SendWelcome", value);
	}

	/** 
	Set the value of the SendWelcome input for this Choreo as a String. 

	@param String - (optional, boolean) If double_optin is false and this flag is true, a welcome email will be sent. Note that this does not apply when updating records. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setSendWelcome(String value) {
		this.inputs.setInput("SendWelcome", value);	
	}
	/** 
	Set the value of the Subscribers input for this Choreo. 

	@param String - (required, json) An array of JSON objects containing the subscribers to insert. See Choreo documentation for the specific format for this JSON input.
	*/
	public void setSubscribers(String value) {
		this.inputs.setInput("Subscribers", value);
	}


	/** 
	Set the value of the SupressErrors input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not to suppress errors that arise from attempting to add/update a subscriber. Defaults to 0 (false). Set to 1 (true) to supress errors.
	*/
	public void setSupressErrors(Boolean value) {
		this.inputs.setInput("SupressErrors", value);
	}

	/** 
	Set the value of the SupressErrors input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not to suppress errors that arise from attempting to add/update a subscriber. Defaults to 0 (false). Set to 1 (true) to supress errors.
	*/
	public void setSupressErrors(String value) {
		this.inputs.setInput("SupressErrors", value);	
	}
	/** 
	Set the value of the UpdateExisting input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that if the email already exists, this request will perform an update instead of an insert. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setUpdateExisting(Boolean value) {
		this.inputs.setInput("UpdateExisting", value);
	}

	/** 
	Set the value of the UpdateExisting input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that if the email already exists, this request will perform an update instead of an insert. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setUpdateExisting(String value) {
		this.inputs.setInput("UpdateExisting", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListBatchSubscribeResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListBatchSubscribeResultSet(result);
	}
	
}
