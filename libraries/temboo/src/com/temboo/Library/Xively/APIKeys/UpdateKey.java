package com.temboo.Library.Xively.APIKeys;

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
UpdateKey

Updates an existing APIKey.
*/
public class UpdateKey extends Choreography {

	/**
	Create a new instance of the UpdateKey Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateKey(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/APIKeys/UpdateKey"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key you would like to update.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessMethods input for this Choreo. 

	@param String - (conditional, string) Comma-separated input containing one or more allowed HTTP methods that the key is allowed. Valid values: get, put, post, and/or delete. Ex.: "put,post". Required unless writing your own CustomKey.
	*/
	public void setAccessMethods(String value) {
		this.inputs.setInput("AccessMethods", value);
	}


	/** 
	Set the value of the CustomKey input for this Choreo. 

	@param String - (optional, any) Optional Custom key to sent to Xively. Type and format depends on CustomType. Please see documentation for more information on constructing your own body. If used all other scalar inputs are ignored.
	*/
	public void setCustomKey(String value) {
		this.inputs.setInput("CustomKey", value);
	}


	/** 
	Set the value of the CustomPermissions input for this Choreo. 

	@param String - (optional, any) Optional custom permissions for advanced configuration. Type and format depends on CustomType. If specified ignores SourceIP, ResourcesData and AccessMethodsData.
	*/
	public void setCustomPermissions(String value) {
		this.inputs.setInput("CustomPermissions", value);
	}


	/** 
	Set the value of the CustomType input for this Choreo. 

	@param String - (optional, string) The datatype that is being input if adding custom permission objects. Valid values are "json" (the default) and "xml".
	*/
	public void setCustomType(String value) {
		this.inputs.setInput("CustomType", value);
	}


	/** 
	Set the value of the Label input for this Choreo. 

	@param String - (conditional, string) A label by which the key can be referenced. Required unless writing your own CustomKey.
	*/
	public void setLabel(String value) {
		this.inputs.setInput("Label", value);
	}


	/** 
	Set the value of the MasterAPIKey input for this Choreo. 

	@param String - (optional, string) Specify a MasterAPIKey with more permissions if the APIKey you would like to view does not have sufficient (write) permissions.
	*/
	public void setMasterAPIKey(String value) {
		this.inputs.setInput("MasterAPIKey", value);
	}


	/** 
	Set the value of the PrivateAccess input for this Choreo. 

	@param String - (optional, string) Flag that indicates whether this key can access private resources belonging to the user. To turn on, input "true", leave blank for "false".
	*/
	public void setPrivateAccess(String value) {
		this.inputs.setInput("PrivateAccess", value);
	}


	/** 
	Set the value of the ResourceFeedID input for this Choreo. 

	@param String - (optional, string) Specify a particular FeedID that the APIKey should have access to. If not specified, the APIKey permissions will apply to all feeds you are authorized to access.
	*/
	public void setResourceFeedID(String value) {
		this.inputs.setInput("ResourceFeedID", value);
	}


	/** 
	Set the value of the SourceIP input for this Choreo. 

	@param String - (optional, string) An IP address that, when specified, limits incoming requests to that specific IP address only.
	*/
	public void setSourceIP(String value) {
		this.inputs.setInput("SourceIP", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateKeyResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateKeyResultSet(result);
	}
	
}
