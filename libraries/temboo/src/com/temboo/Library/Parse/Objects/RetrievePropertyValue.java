package com.temboo.Library.Parse.Objects;

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
RetrievePropertyValue

Retrieves the value for a given property contained within an object.
*/
public class RetrievePropertyValue extends Choreography {

	/**
	Create a new instance of the RetrievePropertyValue Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrievePropertyValue(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Objects/RetrievePropertyValue"));
	}

	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the ClassName input for this Choreo. 

	@param String - (required, string) The class name for the object being retrieved.
	*/
	public void setClassName(String value) {
		this.inputs.setInput("ClassName", value);
	}


	/** 
	Set the value of the ObjectID input for this Choreo. 

	@param String - (required, string) The ID of the object to retrieve.
	*/
	public void setObjectID(String value) {
		this.inputs.setInput("ObjectID", value);
	}


	/** 
	Set the value of the PropertyName input for this Choreo. 

	@param String - (required, string) The name of the property to return.
	*/
	public void setPropertyName(String value) {
		this.inputs.setInput("PropertyName", value);
	}


	/** 
	Set the value of the RESTAPIKey input for this Choreo. 

	@param String - (required, string) The REST API Key provided by Parse.
	*/
	public void setRESTAPIKey(String value) {
		this.inputs.setInput("RESTAPIKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrievePropertyValueResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrievePropertyValueResultSet(result);
	}
	
}
