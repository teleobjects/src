package com.temboo.Library.SendGrid.NewsletterAPI.Identity;

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
CreateIdentity

Create a new identity.
*/
public class CreateIdentity extends Choreography {

	/**
	Create a new instance of the CreateIdentity Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateIdentity(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/NewsletterAPI/Identity/CreateIdentity"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from SendGrid.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APIUser input for this Choreo. 

	@param String - (required, string) The username registered with SendGrid. 
	*/
	public void setAPIUser(String value) {
		this.inputs.setInput("APIUser", value);
	}


	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (required, string) The physical address to be used for this Identity.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (required, string) The city for this Identity.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Country input for this Choreo. 

	@param String - (required, string) The country to be associated with this Identity.
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address to be used for this identity.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the Identity input for this Choreo. 

	@param String - (required, string) The name for this identity.
	*/
	public void setIdentity(String value) {
		this.inputs.setInput("Identity", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) Enter the name to be associated with this identity.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the ReplyTo input for this Choreo. 

	@param String - (required, string) An email address to be used in the Reply-To field.
	*/
	public void setReplyTo(String value) {
		this.inputs.setInput("ReplyTo", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from SendGrid.  Specify json, or xml.  Default is set to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (required, string) The state to be associated with this Identity.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param Integer - (required, integer) The zip code associated with this Identity.
	*/
	public void setZip(Integer value) {
		this.inputs.setInput("Zip", value);
	}

	/** 
	Set the value of the Zip input for this Choreo as a String. 

	@param String - (required, integer) The zip code associated with this Identity.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);	
	}
	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateIdentityResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateIdentityResultSet(result);
	}
	
}
