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
ListBatchSubscribeCSV

Adds or updates multiple subscribers in a given CSV file.
*/
public class ListBatchSubscribeCSV extends Choreography {

	/**
	Create a new instance of the ListBatchSubscribeCSV Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListBatchSubscribeCSV(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/MailChimp/ListBatchSubscribeCSV"));
	}

	/** 
	Set the value of the CSVFile input for this Choreo. 

	@param String - (conditional, multiline) The list of subscriber email addresses to unsubscribe in CSV format.
	*/
	public void setCSVFile(String value) {
		this.inputs.setInput("CSVFile", value);
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

	@param Boolean - (conditional, boolean) Flag to control whether a double opt-in confirmation message is sent. Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setDoubleOptIn(Boolean value) {
		this.inputs.setInput("DoubleOptIn", value);
	}

	/** 
	Set the value of the DoubleOptIn input for this Choreo as a String. 

	@param String - (conditional, boolean) Flag to control whether a double opt-in confirmation message is sent. Specify '1' (true) or '0' (false). Defaults to 0.
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

	@param String - (required, string) The id of the Mailchimp list associated with the email addresses to subscribe.
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

	@param Boolean - (conditional, boolean) Indicates that if the email already exists, this request will perform an update instead of an insert. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setUpdateExisting(Boolean value) {
		this.inputs.setInput("UpdateExisting", value);
	}

	/** 
	Set the value of the UpdateExisting input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates that if the email already exists, this request will perform an update instead of an insert. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setUpdateExisting(String value) {
		this.inputs.setInput("UpdateExisting", value);	
	}
	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to a csv file in the vault containing the email addresses to unsubscribe. Can be used as an alternative to the CSVFile input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListBatchSubscribeCSVResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListBatchSubscribeCSVResultSet(result);
	}
	
}
