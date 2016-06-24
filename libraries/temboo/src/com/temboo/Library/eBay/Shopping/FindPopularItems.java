package com.temboo.Library.eBay.Shopping;

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
FindPopularItems

Searches for popular items based on a category or keyword.
*/
public class FindPopularItems extends Choreography {

	/**
	Create a new instance of the FindPopularItems Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindPopularItems(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Shopping/FindPopularItems"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The unique identifier for the application.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the CategoryID input for this Choreo. 

	@param String - (optional, string) The ID of a category to filter by. Multiple category IDs can be separated by commas.
	*/
	public void setCategoryID(String value) {
		this.inputs.setInput("CategoryID", value);
	}


	/** 
	Set the value of the CategoryIDExclude input for this Choreo. 

	@param Integer - (conditional, integer) The ID of a category to exclude from the result set. Multiple category IDs can be separated by commas.
	*/
	public void setCategoryIDExclude(Integer value) {
		this.inputs.setInput("CategoryIDExclude", value);
	}

	/** 
	Set the value of the CategoryIDExclude input for this Choreo as a String. 

	@param String - (conditional, integer) The ID of a category to exclude from the result set. Multiple category IDs can be separated by commas.
	*/
	public void setCategoryIDExclude(String value) {
		this.inputs.setInput("CategoryIDExclude", value);	
	}
	/** 
	Set the value of the MaxEntries input for this Choreo. 

	@param Integer - (conditional, integer) The maxiumum number of entries to return in the response.
	*/
	public void setMaxEntries(Integer value) {
		this.inputs.setInput("MaxEntries", value);
	}

	/** 
	Set the value of the MaxEntries input for this Choreo as a String. 

	@param String - (conditional, integer) The maxiumum number of entries to return in the response.
	*/
	public void setMaxEntries(String value) {
		this.inputs.setInput("MaxEntries", value);	
	}
	/** 
	Set the value of the QueryKeywords input for this Choreo. 

	@param String - (conditional, string) The text for a keyword search.
	*/
	public void setQueryKeywords(String value) {
		this.inputs.setInput("QueryKeywords", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SandboxMode input for this Choreo. 

	@param Boolean - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(Boolean value) {
		this.inputs.setInput("SandboxMode", value);
	}

	/** 
	Set the value of the SandboxMode input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(String value) {
		this.inputs.setInput("SandboxMode", value);	
	}
	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindPopularItemsResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindPopularItemsResultSet(result);
	}
	
}
