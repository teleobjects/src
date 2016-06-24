package com.temboo.Library.eBay.Trading;

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
GetCategories

Returns the latest category hierarchy for the eBay site.
*/
public class GetCategories extends Choreography {

	/**
	Create a new instance of the GetCategories Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCategories(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/GetCategories"));
	}

	/** 
	Set the value of the CategoryParent input for this Choreo. 

	@param String - (optional, string) Indicates the ID of the highest-level category to return. Multiple CategoryParent IDs can be specified in a comma-separated list.
	*/
	public void setCategoryParent(String value) {
		this.inputs.setInput("CategoryParent", value);
	}


	/** 
	Set the value of the CategorySiteID input for this Choreo. 

	@param String - (optional, string) The ID for the site for which to retrieve the category hierarchy. Use the numeric site code (e.g., 0 for US, 77 for eBay Germany, etc).
	*/
	public void setCategorySiteID(String value) {
		this.inputs.setInput("CategorySiteID", value);
	}


	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (optional, string) The level of detail to return in the response. Valid values are: ReturnAll.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
	}


	/** 
	Set the value of the LevelLimit input for this Choreo. 

	@param String - (optional, string) Indicates the maximum depth of the category hierarchy to retrieve, where the top-level categories (meta-categories) are at level 1. Default is 0.
	*/
	public void setLevelLimit(String value) {
		this.inputs.setInput("LevelLimit", value);
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
	Set the value of the UserToken input for this Choreo. 

	@param String - (required, string) A valid eBay Auth Token.
	*/
	public void setUserToken(String value) {
		this.inputs.setInput("UserToken", value);
	}


	/** 
	Set the value of the ViewAllNodes input for this Choreo. 

	@param Boolean - (optional, boolean) A flag that controls whether all eBay categories are returned, or only leaf categories are returned. To retrieve leaf categories, set this parameter to 'false'.
	*/
	public void setViewAllNodes(Boolean value) {
		this.inputs.setInput("ViewAllNodes", value);
	}

	/** 
	Set the value of the ViewAllNodes input for this Choreo as a String. 

	@param String - (optional, boolean) A flag that controls whether all eBay categories are returned, or only leaf categories are returned. To retrieve leaf categories, set this parameter to 'false'.
	*/
	public void setViewAllNodes(String value) {
		this.inputs.setInput("ViewAllNodes", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCategoriesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCategoriesResultSet(result);
	}
	
}
