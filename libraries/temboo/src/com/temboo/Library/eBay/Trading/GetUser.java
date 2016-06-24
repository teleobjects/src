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
GetUser

Retrieves data pertaining to a single eBay user.
*/
public class GetUser extends Choreography {

	/**
	Create a new instance of the GetUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/GetUser"));
	}

	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (optional, string) The level of detail to return in the response. Valid values are: ReturnAll or ReturnSummary.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
	}


	/** 
	Set the value of the IncludeFeatureEligibility input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not to include feature eligibility information in the response. Set to true or false.
	*/
	public void setIncludeFeatureEligibility(Boolean value) {
		this.inputs.setInput("IncludeFeatureEligibility", value);
	}

	/** 
	Set the value of the IncludeFeatureEligibility input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not to include feature eligibility information in the response. Set to true or false.
	*/
	public void setIncludeFeatureEligibility(String value) {
		this.inputs.setInput("IncludeFeatureEligibility", value);	
	}
	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (optional, string) The ID of the item of a successfully concluded listing in which the requestor and target user were participants as buyer and seller.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
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
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The eBay User ID for the user whose data you want to retrieve.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the UserToken input for this Choreo. 

	@param String - (required, string) A valid eBay Auth Token.
	*/
	public void setUserToken(String value) {
		this.inputs.setInput("UserToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetUserResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetUserResultSet(result);
	}
	
}
