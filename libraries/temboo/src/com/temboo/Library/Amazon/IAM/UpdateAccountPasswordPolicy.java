package com.temboo.Library.Amazon.IAM;

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
UpdateAccountPasswordPolicy

Updates the password policy settings for the account.
*/
public class UpdateAccountPasswordPolicy extends Choreography {

	/**
	Create a new instance of the UpdateAccountPasswordPolicy Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateAccountPasswordPolicy(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/IAM/UpdateAccountPasswordPolicy"));
	}

	/** 
	Set the value of the AWSAccessKeyId input for this Choreo. 

	@param String - (required, string) The Access Key ID provided by Amazon Web Services.
	*/
	public void setAWSAccessKeyId(String value) {
		this.inputs.setInput("AWSAccessKeyId", value);
	}


	/** 
	Set the value of the AWSSecretKeyId input for this Choreo. 

	@param String - (required, string) The Secret Key ID provided by Amazon Web Services.
	*/
	public void setAWSSecretKeyId(String value) {
		this.inputs.setInput("AWSSecretKeyId", value);
	}


	/** 
	Set the value of the AllowUsersToChangePassword input for this Choreo. 

	@param Boolean - (optional, boolean) Determines whether users can set/change their own passwords. Valid values: "true" or "false" (the default).
	*/
	public void setAllowUsersToChangePassword(Boolean value) {
		this.inputs.setInput("AllowUsersToChangePassword", value);
	}

	/** 
	Set the value of the AllowUsersToChangePassword input for this Choreo as a String. 

	@param String - (optional, boolean) Determines whether users can set/change their own passwords. Valid values: "true" or "false" (the default).
	*/
	public void setAllowUsersToChangePassword(String value) {
		this.inputs.setInput("AllowUsersToChangePassword", value);	
	}
	/** 
	Set the value of the ExpirePasswords input for this Choreo. 

	@param Boolean - (optional, boolean) Determines whether the passwords expire. Valid values: "true" or "false" (the default).
	*/
	public void setExpirePasswords(Boolean value) {
		this.inputs.setInput("ExpirePasswords", value);
	}

	/** 
	Set the value of the ExpirePasswords input for this Choreo as a String. 

	@param String - (optional, boolean) Determines whether the passwords expire. Valid values: "true" or "false" (the default).
	*/
	public void setExpirePasswords(String value) {
		this.inputs.setInput("ExpirePasswords", value);	
	}
	/** 
	Set the value of the MaxPasswordsAge input for this Choreo. 

	@param Integer - (optional, integer) Maximum age of the passwords before they expire.
	*/
	public void setMaxPasswordsAge(Integer value) {
		this.inputs.setInput("MaxPasswordsAge", value);
	}

	/** 
	Set the value of the MaxPasswordsAge input for this Choreo as a String. 

	@param String - (optional, integer) Maximum age of the passwords before they expire.
	*/
	public void setMaxPasswordsAge(String value) {
		this.inputs.setInput("MaxPasswordsAge", value);	
	}
	/** 
	Set the value of the MinimumPasswordLength input for this Choreo. 

	@param Integer - (optional, integer) Mininum length of the password. Defaults to none.
	*/
	public void setMinimumPasswordLength(Integer value) {
		this.inputs.setInput("MinimumPasswordLength", value);
	}

	/** 
	Set the value of the MinimumPasswordLength input for this Choreo as a String. 

	@param String - (optional, integer) Mininum length of the password. Defaults to none.
	*/
	public void setMinimumPasswordLength(String value) {
		this.inputs.setInput("MinimumPasswordLength", value);	
	}
	/** 
	Set the value of the RequireLowercaseCharacters input for this Choreo. 

	@param Boolean - (optional, boolean) Determines whether at least one lower-case character is required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireLowercaseCharacters(Boolean value) {
		this.inputs.setInput("RequireLowercaseCharacters", value);
	}

	/** 
	Set the value of the RequireLowercaseCharacters input for this Choreo as a String. 

	@param String - (optional, boolean) Determines whether at least one lower-case character is required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireLowercaseCharacters(String value) {
		this.inputs.setInput("RequireLowercaseCharacters", value);	
	}
	/** 
	Set the value of the RequireNumbers input for this Choreo. 

	@param Boolean - (optional, boolean) Determines whether numbers are required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireNumbers(Boolean value) {
		this.inputs.setInput("RequireNumbers", value);
	}

	/** 
	Set the value of the RequireNumbers input for this Choreo as a String. 

	@param String - (optional, boolean) Determines whether numbers are required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireNumbers(String value) {
		this.inputs.setInput("RequireNumbers", value);	
	}
	/** 
	Set the value of the RequireSymbols input for this Choreo. 

	@param Boolean - (optional, boolean) Determines whether symbols are required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireSymbols(Boolean value) {
		this.inputs.setInput("RequireSymbols", value);
	}

	/** 
	Set the value of the RequireSymbols input for this Choreo as a String. 

	@param String - (optional, boolean) Determines whether symbols are required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireSymbols(String value) {
		this.inputs.setInput("RequireSymbols", value);	
	}
	/** 
	Set the value of the RequireUppercaseCharacters input for this Choreo. 

	@param Boolean - (optional, boolean) Determines whether at least one upper-case character is required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireUppercaseCharacters(Boolean value) {
		this.inputs.setInput("RequireUppercaseCharacters", value);
	}

	/** 
	Set the value of the RequireUppercaseCharacters input for this Choreo as a String. 

	@param String - (optional, boolean) Determines whether at least one upper-case character is required in the password. Valid values: "true" or "false" (the default).
	*/
	public void setRequireUppercaseCharacters(String value) {
		this.inputs.setInput("RequireUppercaseCharacters", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateAccountPasswordPolicyResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateAccountPasswordPolicyResultSet(result);
	}
	
}
