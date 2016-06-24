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
ListMergeVarAdd

Add a new field to a MailChimp list.
*/
public class ListMergeVarAdd extends Choreography {

	/**
	Create a new instance of the ListMergeVarAdd Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListMergeVarAdd(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/MailChimp/ListMergeVarAdd"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Mailchimp.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Choices input for this Choreo. 

	@param String - (optional, string) A list of up to 10 choices for radio and dropdown type fields )separated by commas).
	*/
	public void setChoices(String value) {
		this.inputs.setInput("Choices", value);
	}


	/** 
	Set the value of the DateFormat input for this Choreo. 

	@param String - (optional, string) Valid for birthday and date fields. For birthday, must be "MM/DD" (default) or "DD/MM". For date type, must be "MM/DD/YYYY" (default) or "DD/MM/YYYY".
	*/
	public void setDateFormat(String value) {
		this.inputs.setInput("DateFormat", value);
	}


	/** 
	Set the value of the DefaultCountry input for this Choreo. 

	@param String - (optional, string) The ISO 3166 2 digit character code for the default country. Defaults to "US".
	*/
	public void setDefaultCountry(String value) {
		this.inputs.setInput("DefaultCountry", value);
	}


	/** 
	Set the value of the DefaultValue input for this Choreo. 

	@param String - (optional, string) The default value for the new field.
	*/
	public void setDefaultValue(String value) {
		this.inputs.setInput("DefaultValue", value);
	}


	/** 
	Set the value of the FieldType input for this Choreo. 

	@param String - (optional, string) Must be either left unset or one of 'text', 'number', 'radio', 'dropdown', 'date', 'address', 'phone', 'url', or 'imageurl. Defaults to text.
	*/
	public void setFieldType(String value) {
		this.inputs.setInput("FieldType", value);
	}


	/** 
	Set the value of the ListId input for this Choreo. 

	@param String - (required, string) The ID of the list on which to add the new merge var.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) Provide a long merge var name for user display (i.e. First Name)
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the PhoneFormat input for this Choreo. 

	@param String - (optional, string) Defaults to "US"  - any other value will cause them to be unformatted (international).
	*/
	public void setPhoneFormat(String value) {
		this.inputs.setInput("PhoneFormat", value);
	}


	/** 
	Set the value of the Public input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether the field is displayed in public. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setPublic(Boolean value) {
		this.inputs.setInput("Public", value);
	}

	/** 
	Set the value of the Public input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether the field is displayed in public. Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setPublic(String value) {
		this.inputs.setInput("Public", value);	
	}
	/** 
	Set the value of the Req input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that the field will be required.  Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setReq(Boolean value) {
		this.inputs.setInput("Req", value);
	}

	/** 
	Set the value of the Req input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that the field will be required.  Specify '1' (true) or '0' (false). Defaults to 0.
	*/
	public void setReq(String value) {
		this.inputs.setInput("Req", value);	
	}
	/** 
	Set the value of the Show input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether the field is displayed in the app's list member view.  Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setShow(Boolean value) {
		this.inputs.setInput("Show", value);
	}

	/** 
	Set the value of the Show input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether the field is displayed in the app's list member view.  Specify '1' (true) or '0' (false). Defaults to 1.
	*/
	public void setShow(String value) {
		this.inputs.setInput("Show", value);	
	}
	/** 
	Set the value of the Tag input for this Choreo. 

	@param String - (required, string) Provide a short merge var tag name. MUST be 10 UTF-8 chars, including 'A-Z', '0-9', or '_' only (i.e. DESC123456).
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListMergeVarAddResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListMergeVarAddResultSet(result);
	}
	
}
