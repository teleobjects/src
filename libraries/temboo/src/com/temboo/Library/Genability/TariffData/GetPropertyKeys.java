package com.temboo.Library.Genability.TariffData;

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
GetPropertyKeys

Returns a list of Property Keys based on a specified search criteria.
*/
public class GetPropertyKeys extends Choreography {

	/**
	Create a new instance of the GetPropertyKeys Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPropertyKeys(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetPropertyKeys"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (conditional, string) The App ID provided by Genability.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The App Key provided by Genability.
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the EntityID input for this Choreo. 

	@param String - (optional, string) Filters the result so that only Properties that belong to this EntityID are returned. When specified, EntityType must also be specified.
	*/
	public void setEntityID(String value) {
		this.inputs.setInput("EntityID", value);
	}


	/** 
	Set the value of the EntityType input for this Choreo. 

	@param String - (optional, string) Filters the result so that only Properties that belong to this EntityType are returned. When specified, EntityID must also be specified.
	*/
	public void setEntityType(String value) {
		this.inputs.setInput("EntityType", value);
	}


	/** 
	Set the value of the PageCount input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return. Defaults to 25.
	*/
	public void setPageCount(Integer value) {
		this.inputs.setInput("PageCount", value);
	}

	/** 
	Set the value of the PageCount input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return. Defaults to 25.
	*/
	public void setPageCount(String value) {
		this.inputs.setInput("PageCount", value);	
	}
	/** 
	Set the value of the PageStart input for this Choreo. 

	@param Integer - (optional, integer) The page number to begin the result set from. Defaults to 1.
	*/
	public void setPageStart(Integer value) {
		this.inputs.setInput("PageStart", value);
	}

	/** 
	Set the value of the PageStart input for this Choreo as a String. 

	@param String - (optional, integer) The page number to begin the result set from. Defaults to 1.
	*/
	public void setPageStart(String value) {
		this.inputs.setInput("PageStart", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetPropertyKeysResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPropertyKeysResultSet(result);
	}
	
}
