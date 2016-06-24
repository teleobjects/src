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
ListUpdateMember

Update information for a member of a MailChimp list.
*/
public class ListUpdateMember extends Choreography {

	/**
	Create a new instance of the ListUpdateMember Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListUpdateMember(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/MailChimp/ListUpdateMember"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Mailchimp.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (required, string) The current email address for the subscriber you want to update.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
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

	@param String - (required, string) The id of the list that the existing subsbriber belongs to.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);
	}


	/** 
	Set the value of the Merge1 input for this Choreo. 

	@param String - (optional, string) Corresponds to the first merge var field defined in your account.
	*/
	public void setMerge1(String value) {
		this.inputs.setInput("Merge1", value);
	}


	/** 
	Set the value of the Merge2 input for this Choreo. 

	@param String - (optional, string) Corresponds to the second merge var field defined in your account.
	*/
	public void setMerge2(String value) {
		this.inputs.setInput("Merge2", value);
	}


	/** 
	Set the value of the Merge3 input for this Choreo. 

	@param String - (optional, string) Corresponds to the third merge var field defined in your account.
	*/
	public void setMerge3(String value) {
		this.inputs.setInput("Merge3", value);
	}


	/** 
	Set the value of the Merge4 input for this Choreo. 

	@param String - (optional, string) Corresponds to the fourth merge var field defined in your account.
	*/
	public void setMerge4(String value) {
		this.inputs.setInput("Merge4", value);
	}


	/** 
	Set the value of the NewEmail input for this Choreo. 

	@param String - (optional, multiline) Set this to update the email address of a subscriber.
	*/
	public void setNewEmail(String value) {
		this.inputs.setInput("NewEmail", value);
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListUpdateMemberResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListUpdateMemberResultSet(result);
	}
	
}
