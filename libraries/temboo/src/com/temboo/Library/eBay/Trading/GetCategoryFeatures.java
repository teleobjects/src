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
GetCategoryFeatures

Returns information that describes the feature and value settings that apply to the set of eBay categories.
*/
public class GetCategoryFeatures extends Choreography {

	/**
	Create a new instance of the GetCategoryFeatures Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCategoryFeatures(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/GetCategoryFeatures"));
	}

	/** 
	Set the value of the AllFeaturesForCategory input for this Choreo. 

	@param Boolean - (optional, boolean) A flag used to view all of the feature settings for a specific category.
	*/
	public void setAllFeaturesForCategory(Boolean value) {
		this.inputs.setInput("AllFeaturesForCategory", value);
	}

	/** 
	Set the value of the AllFeaturesForCategory input for this Choreo as a String. 

	@param String - (optional, boolean) A flag used to view all of the feature settings for a specific category.
	*/
	public void setAllFeaturesForCategory(String value) {
		this.inputs.setInput("AllFeaturesForCategory", value);	
	}
	/** 
	Set the value of the CategoryID input for this Choreo. 

	@param String - (optional, string) The ID of the category for which you want to retrieve the feature settings.
	*/
	public void setCategoryID(String value) {
		this.inputs.setInput("CategoryID", value);
	}


	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (optional, string) The level of detail to return in the response. Valid values are: ReturnAll and ReturnSummary.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
	}


	/** 
	Set the value of the FeatureID input for this Choreo. 

	@param String - (optional, string) Use this field if you want to know if specific features are enabled at the site or root category level. Multiple FeatureIDs can be specified in a comma-separated list.
	*/
	public void setFeatureID(String value) {
		this.inputs.setInput("FeatureID", value);
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

	@param Boolean - (optional, boolean) Indicates that eBay should return the site defaults along with all the categories that override the feature settings they inherit. DetailLevel must be 'ReturnAll' when setting this parameter to true.
	*/
	public void setViewAllNodes(Boolean value) {
		this.inputs.setInput("ViewAllNodes", value);
	}

	/** 
	Set the value of the ViewAllNodes input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that eBay should return the site defaults along with all the categories that override the feature settings they inherit. DetailLevel must be 'ReturnAll' when setting this parameter to true.
	*/
	public void setViewAllNodes(String value) {
		this.inputs.setInput("ViewAllNodes", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCategoryFeaturesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCategoryFeaturesResultSet(result);
	}
	
}
