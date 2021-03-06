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
GetShippingCosts

Retrieves shipping costs for an item.
*/
public class GetShippingCosts extends Choreography {

	/**
	Create a new instance of the GetShippingCosts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetShippingCosts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Shopping/GetShippingCosts"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The unique identifier for the application.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the DestinationCountryCode input for this Choreo. 

	@param String - (conditional, string) The shipment destination country code.
	*/
	public void setDestinationCountryCode(String value) {
		this.inputs.setInput("DestinationCountryCode", value);
	}


	/** 
	Set the value of the DestinationPostalCode input for this Choreo. 

	@param String - (conditional, string) The shipment destination postal code.
	*/
	public void setDestinationPostalCode(String value) {
		this.inputs.setInput("DestinationPostalCode", value);
	}


	/** 
	Set the value of the IncludeDetails input for this Choreo. 

	@param Boolean - (conditional, boolean) Indicates whether to return the ShippingDetails container in the response.
	*/
	public void setIncludeDetails(Boolean value) {
		this.inputs.setInput("IncludeDetails", value);
	}

	/** 
	Set the value of the IncludeDetails input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates whether to return the ShippingDetails container in the response.
	*/
	public void setIncludeDetails(String value) {
		this.inputs.setInput("IncludeDetails", value);	
	}
	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (required, string) The ID of the item to get shipping costs for.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the QuantitySold input for this Choreo. 

	@param String - (optional, string) The quantity of items being shipped.
	*/
	public void setQuantitySold(String value) {
		this.inputs.setInput("QuantitySold", value);
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
	public GetShippingCostsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetShippingCostsResultSet(result);
	}
	
}
