package com.temboo.Library.Amazon.EC2;

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
CreateTags

Adds or overwrites one or more tags for the specified EC2 resource or resources using the Amazon EC2 API.
*/
public class CreateTags extends Choreography {

	/**
	Create a new instance of the CreateTags Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateTags(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/CreateTags"));
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
	Set the value of the ResourceId input for this Choreo. 

	@param String - (required, string) The ID of a resource to tag. This can be a comma-separated list of up to 10  Resource IDs.
	*/
	public void setResourceId(String value) {
		this.inputs.setInput("ResourceId", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the TagKey input for this Choreo. 

	@param String - (required, string) The key for a tag.
	*/
	public void setTagKey(String value) {
		this.inputs.setInput("TagKey", value);
	}


	/** 
	Set the value of the TagValue input for this Choreo. 

	@param String - (conditional, string) The value for a tag. If empty, the value will be set to be an empty string.
	*/
	public void setTagValue(String value) {
		this.inputs.setInput("TagValue", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the EC2 endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateTagsResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateTagsResultSet(result);
	}
	
}
