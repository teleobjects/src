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
FindProducts

Retrieves the listings for products that match the specified keywords.
*/
public class FindProducts extends Choreography {

	/**
	Create a new instance of the FindProducts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindProducts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Shopping/FindProducts"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The unique identifier for the application.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the AvailableItemsOnly input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, only retrieve data for products that have been used to pre-fill active listings. If false, retrieve all products that match the query. Defaults to false.
	*/
	public void setAvailableItemsOnly(Boolean value) {
		this.inputs.setInput("AvailableItemsOnly", value);
	}

	/** 
	Set the value of the AvailableItemsOnly input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, only retrieve data for products that have been used to pre-fill active listings. If false, retrieve all products that match the query. Defaults to false.
	*/
	public void setAvailableItemsOnly(String value) {
		this.inputs.setInput("AvailableItemsOnly", value);	
	}
	/** 
	Set the value of the CategoryID input for this Choreo. 

	@param String - (conditional, string) Restricts your query to a specific category. The request requires one of the following filter parameters: QueryKeywords, ProductID, or CategoryID. Only one of the filters should be provided.
	*/
	public void setCategoryID(String value) {
		this.inputs.setInput("CategoryID", value);
	}


	/** 
	Set the value of the DomainName input for this Choreo. 

	@param String - (optional, string) A domain to search in (e.g. Textbooks).
	*/
	public void setDomainName(String value) {
		this.inputs.setInput("DomainName", value);
	}


	/** 
	Set the value of the HideDuplicateItems input for this Choreo. 

	@param String - (optional, string) Specifies whether or not to remove duplicate items from search results.
	*/
	public void setHideDuplicateItems(String value) {
		this.inputs.setInput("HideDuplicateItems", value);
	}


	/** 
	Set the value of the IncludeSelector input for this Choreo. 

	@param String - (optional, string) Defines standard subsets of fields to return within the response. Valid values are: Details, DomainHistogram, and Items.
	*/
	public void setIncludeSelector(String value) {
		this.inputs.setInput("IncludeSelector", value);
	}


	/** 
	Set the value of the MaxEntries input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of entries to return in the response.
	*/
	public void setMaxEntries(Integer value) {
		this.inputs.setInput("MaxEntries", value);
	}

	/** 
	Set the value of the MaxEntries input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of entries to return in the response.
	*/
	public void setMaxEntries(String value) {
		this.inputs.setInput("MaxEntries", value);	
	}
	/** 
	Set the value of the PageNumber input for this Choreo. 

	@param String - (optional, string) The page number to retrieve.
	*/
	public void setPageNumber(String value) {
		this.inputs.setInput("PageNumber", value);
	}


	/** 
	Set the value of the ProductID input for this Choreo. 

	@param String - (conditional, string) Used to retrieve product details. The request requires one of the following filter parameters: QueryKeywords, ProductID, or CategoryID. Only one of the filters should be provided.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);
	}


	/** 
	Set the value of the ProductSort input for this Choreo. 

	@param String - (optional, string) Sorts the list of products returned. Valid values are: ItemCount, Popularity, Rating, ReviewCount, and Title.
	*/
	public void setProductSort(String value) {
		this.inputs.setInput("ProductSort", value);
	}


	/** 
	Set the value of the QueryKeywords input for this Choreo. 

	@param String - (conditional, string) The query keywords to use for the product search. The request requires one of the following filter parameters: QueryKeywords, ProductID, or CategoryID. Only one of the filters should be provided.
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
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Sorts search results in ascending or descending order. Valid values are: Ascending and Descending.
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindProductsResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindProductsResultSet(result);
	}
	
}
