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
GetItem

Returns item data such as title, description, price information, and seller information.
*/
public class GetItem extends Choreography {

	/**
	Create a new instance of the GetItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/GetItem"));
	}

	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (optional, string) The response detail level. Valid values are: ItemReturnAttributes, ItemReturnDescription, and ReturnAll.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
	}


	/** 
	Set the value of the IncludeItemSpecifics input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, the response returns the ItemSpecifics node (if the listing has custom Item Specifics).
	*/
	public void setIncludeItemSpecifics(Boolean value) {
		this.inputs.setInput("IncludeItemSpecifics", value);
	}

	/** 
	Set the value of the IncludeItemSpecifics input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, the response returns the ItemSpecifics node (if the listing has custom Item Specifics).
	*/
	public void setIncludeItemSpecifics(String value) {
		this.inputs.setInput("IncludeItemSpecifics", value);	
	}
	/** 
	Set the value of the IncludeTaxTable input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, an associated tax table is returned in the response.
	*/
	public void setIncludeTaxTable(Boolean value) {
		this.inputs.setInput("IncludeTaxTable", value);
	}

	/** 
	Set the value of the IncludeTaxTable input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, an associated tax table is returned in the response.
	*/
	public void setIncludeTaxTable(String value) {
		this.inputs.setInput("IncludeTaxTable", value);	
	}
	/** 
	Set the value of the IncludeWatchCount input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates if the caller wants to include watch count for that item in the response when set to true. Only the seller is allowed to use this argument.
	*/
	public void setIncludeWatchCount(Boolean value) {
		this.inputs.setInput("IncludeWatchCount", value);
	}

	/** 
	Set the value of the IncludeWatchCount input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates if the caller wants to include watch count for that item in the response when set to true. Only the seller is allowed to use this argument.
	*/
	public void setIncludeWatchCount(String value) {
		this.inputs.setInput("IncludeWatchCount", value);	
	}
	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (required, string) The ItemID that uniquely identifies the item listing to retrieve.
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
	Set the value of the TransactionID input for this Choreo. 

	@param String - (optional, string) A unique identifier for a transaction (i.e.  an order line item). An order line item is created when the buyer commits to purchasing an item.
	*/
	public void setTransactionID(String value) {
		this.inputs.setInput("TransactionID", value);
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
	public GetItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetItemResultSet(result);
	}
	
}
