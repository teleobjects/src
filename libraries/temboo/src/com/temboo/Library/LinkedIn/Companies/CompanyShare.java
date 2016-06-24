package com.temboo.Library.LinkedIn.Companies;

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
CompanyShare

Posts shared comment on a company page.
*/
public class CompanyShare extends Choreography {

	/**
	Create a new instance of the CompanyShare Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CompanyShare(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LinkedIn/Companies/CompanyShare"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by LinkedIn (AKA the Client ID).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process (AKA the OAuth User Token).
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret retrieved during the OAuth process (AKA the OAuth User Secret).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Comment input for this Choreo. 

	@param String - (conditional, string) A comment by the member to associated with the share. If this is not provided, you must specify the SubmittedURL.
	*/
	public void setComment(String value) {
		this.inputs.setInput("Comment", value);
	}


	/** 
	Set the value of the CompanyID input for this Choreo. 

	@param Integer - (required, integer) A LinkedIn assigned ID associated with the company.
	*/
	public void setCompanyID(Integer value) {
		this.inputs.setInput("CompanyID", value);
	}

	/** 
	Set the value of the CompanyID input for this Choreo as a String. 

	@param String - (required, integer) A LinkedIn assigned ID associated with the company.
	*/
	public void setCompanyID(String value) {
		this.inputs.setInput("CompanyID", value);	
	}
	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) The description of the content being shared.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SecretKey input for this Choreo. 

	@param String - (required, string) The Secret Key provided by LinkedIn (AKA the Client Secret).
	*/
	public void setSecretKey(String value) {
		this.inputs.setInput("SecretKey", value);
	}


	/** 
	Set the value of the SharedTargetCode input for this Choreo. 

	@param String - (optional, string) A shared target code used to ensure that the shared content reaches a specific audience.
	*/
	public void setSharedTargetCode(String value) {
		this.inputs.setInput("SharedTargetCode", value);
	}


	/** 
	Set the value of the SharedTargetValue input for this Choreo. 

	@param String - (optional, string) The name of the shared target used to ensure that the shared content reaches a specific audience.
	*/
	public void setSharedTargetValue(String value) {
		this.inputs.setInput("SharedTargetValue", value);
	}


	/** 
	Set the value of the SubmittedImageURL input for this Choreo. 

	@param String - (optional, string) A fully qualified URL to a thumbnail image to accompany the shared content.
	*/
	public void setSubmittedImageURL(String value) {
		this.inputs.setInput("SubmittedImageURL", value);
	}


	/** 
	Set the value of the SubmittedURL input for this Choreo. 

	@param String - (optional, string) A fully qualified URL for the content being shared.
	*/
	public void setSubmittedURL(String value) {
		this.inputs.setInput("SubmittedURL", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) The title of the content being shared.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Visibility input for this Choreo. 

	@param String - (required, string) The visibility setting of the share. Valid values are: anyone, connections-only.
	*/
	public void setVisibility(String value) {
		this.inputs.setInput("Visibility", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CompanyShareResultSet run() {
		JSONObject result = super.runWithResults();
		return new CompanyShareResultSet(result);
	}
	
}
