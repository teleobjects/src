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
UploadServerCertificate

Uploads a server certificate entity for the AWS account. The server certificate entity includes a public key certificate, a private key, and an optional certificate chain, which should all be PEM-encoded.
*/
public class UploadServerCertificate extends Choreography {

	/**
	Create a new instance of the UploadServerCertificate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadServerCertificate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/IAM/UploadServerCertificate"));
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
	Set the value of the CertificateBody input for this Choreo. 

	@param String - (required, multiline) The contents of the signing certificate.
	*/
	public void setCertificateBody(String value) {
		this.inputs.setInput("CertificateBody", value);
	}


	/** 
	Set the value of the CertificateChain input for this Choreo. 

	@param String - (optional, multiline) The contents of the certificate chain. This is typically a concatenation of the PEM-encoded public key certificates of the chain.
	*/
	public void setCertificateChain(String value) {
		this.inputs.setInput("CertificateChain", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (optional, string) The path for the server certificate.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the PrivateKey input for this Choreo. 

	@param String - (required, multiline) The contents of the private key in PEM-encoded format.
	*/
	public void setPrivateKey(String value) {
		this.inputs.setInput("PrivateKey", value);
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
	public UploadServerCertificateResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadServerCertificateResultSet(result);
	}
	
}
