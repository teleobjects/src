package com.temboo.Library.Google.Contacts;

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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the UpdateContact Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class UpdateContactResultSet extends ResultSet {
		
	public UpdateContactResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "AccessToken" output from this Choreo execution

	@return String - (optional, string) The access token retrieved in the last step of the OAuth process. Access tokens that are expired will be refreshed and returned in the Choreo output.
	*/
	public String getAccessToken() {
		return this.getResultString("AccessToken");
	}
	/** 
	Retrieve the value for the "ContactID" output from this Choreo execution

	@return String - (string) The unique ID for the contact returned by Google.
	*/
	public String getContactID() {
		return this.getResultString("ContactID");
	}
	/** 
	Retrieve the value for the "Email" output from this Choreo execution

	@return String - (string) The contact's current email address.
	*/
	public String getEmail() {
		return this.getResultString("Email");
	}
	/** 
	Retrieve the value for the "FirstName" output from this Choreo execution

	@return String - (string) The contact's current given name.
	*/
	public String getFirstName() {
		return this.getResultString("FirstName");
	}
	/** 
	Retrieve the value for the "LastName" output from this Choreo execution

	@return String - (string) The contact's current family name.
	*/
	public String getLastName() {
		return this.getResultString("LastName");
	}
	/** 
	Retrieve the value for the "Phone" output from this Choreo execution

	@return String - (string) The contact's current telephone number.
	*/
	public String getPhone() {
		return this.getResultString("Phone");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (xml) The response from Google.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}