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
ListVirtualMFADevices

Lists the virtual MFA devices under the AWS account.
*/
public class ListVirtualMFADevices extends Choreography {

	/**
	Create a new instance of the ListVirtualMFADevices Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListVirtualMFADevices(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/IAM/ListVirtualMFADevices"));
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
	Set the value of the AssignmentStatus input for this Choreo. 

	@param String - (optional, string) Filters by the whether the device is assigned or unassigned to a specific user. Valid values: "Unassigned", "Assigned" or "Any" (default - both assigned and unassigned devices).
	*/
	public void setAssignmentStatus(String value) {
		this.inputs.setInput("AssignmentStatus", value);
	}


	/** 
	Set the value of the Marker input for this Choreo. 

	@param String - (optional, string) Used for pagination to indicate the starting point of the results to return.
	*/
	public void setMarker(String value) {
		this.inputs.setInput("Marker", value);
	}


	/** 
	Set the value of the MaxItems input for this Choreo. 

	@param Integer - (optional, integer) Used for pagination to limit the number of results returned. Defaults to 100.
	*/
	public void setMaxItems(Integer value) {
		this.inputs.setInput("MaxItems", value);
	}

	/** 
	Set the value of the MaxItems input for this Choreo as a String. 

	@param String - (optional, integer) Used for pagination to limit the number of results returned. Defaults to 100.
	*/
	public void setMaxItems(String value) {
		this.inputs.setInput("MaxItems", value);	
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
	public ListVirtualMFADevicesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListVirtualMFADevicesResultSet(result);
	}
	
}
