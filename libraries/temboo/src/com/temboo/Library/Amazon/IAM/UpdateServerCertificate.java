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
UpdateServerCertificate

Updates the name and/or the path of the specified server certificate.
*/
public class UpdateServerCertificate extends Choreography {

	/**
	Create a new instance of the UpdateServerCertificate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateServerCertificate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/IAM/UpdateServerCertificate"));
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
	Set the value of the NewPath input for this Choreo. 

	@param String - (conditional, string) The new path for the server certificate. Include this only if you are updating the server certificate's path.
	*/
	public void setNewPath(String value) {
		this.inputs.setInput("NewPath", value);
	}


	/** 
	Set the value of the NewServerCertificateName input for this Choreo. 

	@param String - (conditional, string) The new name for the server certificate. Include this only if you are updating the server certificate's name.
	*/
	public void setNewServerCertificateName(String value) {
		this.inputs.setInput("NewServerCertificateName", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ServerCertificateName input for this Choreo. 

	@param String - (required, string) The name for the server certificate. Do not include the path in this value.
	*/
	public void setServerCertificateName(String value) {
		this.inputs.setInput("ServerCertificateName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateServerCertificateResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateServerCertificateResultSet(result);
	}
	
}
