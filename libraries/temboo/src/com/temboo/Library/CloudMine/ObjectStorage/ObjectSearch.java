package com.temboo.Library.CloudMine.ObjectStorage;

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
ObjectSearch

Allows you to query key/value pair objects.
*/
public class ObjectSearch extends Choreography {

	/**
	Create a new instance of the ObjectSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ObjectSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CloudMine/ObjectStorage/ObjectSearch"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by CloudMine after registering your app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ApplicationIdentifier input for this Choreo. 

	@param String - (required, string) The application identifier provided by CloudMine after registering your app.
	*/
	public void setApplicationIdentifier(String value) {
		this.inputs.setInput("ApplicationIdentifier", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Boolean - (optional, boolean) Returns a count of the results in the response if set to true. Valid values are true and false.
	*/
	public void setCount(Boolean value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, boolean) Returns a count of the results in the response if set to true. Valid values are true and false.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Limits the number of results returned. Use -1 for no limit. Use 0 for no results, and with Count=true to just get the number of available results. This defaults to 50.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Limits the number of results returned. Use -1 for no limit. Use 0 for no results, and with Count=true to just get the number of available results. This defaults to 50.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) The query for your search. See Choreo documentation for information on appropriate query syntax.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the SessionToken input for this Choreo. 

	@param String - (conditional, string) The session token for an existing user (returned by the AccountLogin Choreo). This is only required if your app is performing this operation on behalf of another user.
	*/
	public void setSessionToken(String value) {
		this.inputs.setInput("SessionToken", value);
	}


	/** 
	Set the value of the Skip input for this Choreo. 

	@param Integer - (optional, integer) Indicates to start results after skiping this number objects. Used to page through results.
	*/
	public void setSkip(Integer value) {
		this.inputs.setInput("Skip", value);
	}

	/** 
	Set the value of the Skip input for this Choreo as a String. 

	@param String - (optional, integer) Indicates to start results after skiping this number objects. Used to page through results.
	*/
	public void setSkip(String value) {
		this.inputs.setInput("Skip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ObjectSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new ObjectSearchResultSet(result);
	}
	
}
