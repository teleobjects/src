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
GetCategoryInfo

Retrieve high-level category information for a specified category.
*/
public class GetCategoryInfo extends Choreography {

	/**
	Create a new instance of the GetCategoryInfo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCategoryInfo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Shopping/GetCategoryInfo"));
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

	@param String - (required, string) The ID of a category to retrieve. Use an ID of -1 to retrieve the root category and the top-level (level 1) meta categories.
	*/
	public void setCategoryID(String value) {
		this.inputs.setInput("CategoryID", value);
	}


	/** 
	Set the value of the IncludeSelector input for this Choreo. 

	@param String - (optional, string) Defines standard subsets of fields to return within the response. Valid values are: ChildCategories.
	*/
	public void setIncludeSelector(String value) {
		this.inputs.setInput("IncludeSelector", value);
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
	public GetCategoryInfoResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCategoryInfoResultSet(result);
	}
	
}
