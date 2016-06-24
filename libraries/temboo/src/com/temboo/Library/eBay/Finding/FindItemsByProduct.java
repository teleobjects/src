package com.temboo.Library.eBay.Finding;

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
FindItemsByProduct

Finds items based upon a product ID, such as an ISBN, UPC, EAN, or ePID.
*/
public class FindItemsByProduct extends Choreography {

	/**
	Create a new instance of the FindItemsByProduct Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindItemsByProduct(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Finding/FindItemsByProduct"));
	}

	/** 
	Set the value of the FindItemsByProductRequest input for this Choreo. 

	@param String - (optional, xml) The complete XML request body containing properties you wish to set. This can be used as an alternative to individual inputs that represent request properties.
	*/
	public void setFindItemsByProductRequest(String value) {
		this.inputs.setInput("FindItemsByProductRequest", value);
	}


	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The unique identifier for the application.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the EntriesPerPage input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of records to return in the result.
	*/
	public void setEntriesPerPage(Integer value) {
		this.inputs.setInput("EntriesPerPage", value);
	}

	/** 
	Set the value of the EntriesPerPage input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of records to return in the result.
	*/
	public void setEntriesPerPage(String value) {
		this.inputs.setInput("EntriesPerPage", value);	
	}
	/** 
	Set the value of the GlobalID input for this Choreo. 

	@param Integer - (optional, integer) The global ID of the eBay site to access (e.g., EBAY-US).
	*/
	public void setGlobalID(Integer value) {
		this.inputs.setInput("GlobalID", value);
	}

	/** 
	Set the value of the GlobalID input for this Choreo as a String. 

	@param String - (optional, integer) The global ID of the eBay site to access (e.g., EBAY-US).
	*/
	public void setGlobalID(String value) {
		this.inputs.setInput("GlobalID", value);	
	}
	/** 
	Set the value of the ItemFilters input for this Choreo. 

	@param String - (optional, json) A dictionary of key/value pairs to use as item filters for the request.
	*/
	public void setItemFilters(String value) {
		this.inputs.setInput("ItemFilters", value);
	}


	/** 
	Set the value of the OutputSelector input for this Choreo. 

	@param String - (optional, string) Controls the fields that are returned in the response (e.g., GalleryInfo).
	*/
	public void setOutputSelector(String value) {
		this.inputs.setInput("OutputSelector", value);
	}


	/** 
	Set the value of the PageNumber input for this Choreo. 

	@param Integer - (optional, integer) Specifies the page number of the results to return.
	*/
	public void setPageNumber(Integer value) {
		this.inputs.setInput("PageNumber", value);
	}

	/** 
	Set the value of the PageNumber input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the page number of the results to return.
	*/
	public void setPageNumber(String value) {
		this.inputs.setInput("PageNumber", value);	
	}
	/** 
	Set the value of the ProductID input for this Choreo. 

	@param String - (required, string) The ID of a product to find.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);
	}


	/** 
	Set the value of the ProductIDType input for this Choreo. 

	@param String - (required, string) The type of identifier being used to find a product. Valid values are: ReferenceID, ISBN, UPC, and EAN.
	*/
	public void setProductIDType(String value) {
		this.inputs.setInput("ProductIDType", value);
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
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Valid values: BestMatch, BidCountMost, CountryAscending, CountryDescending, DistanceNearest, CurrentPriceHighest, EndTimeSoonest, PricePlusShippingHighest, PricePlusShippingLowest, StartTimeNewest.
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindItemsByProductResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindItemsByProductResultSet(result);
	}
	
}
