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
GetItemTransactions

Retrieves order line item (transaction) information for a specified ItemID.
*/
public class GetItemTransactions extends Choreography {

	/**
	Create a new instance of the GetItemTransactions Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetItemTransactions(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/GetItemTransactions"));
	}

	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (optional, string) The detail level of the response. Valid values are: ItemReturnDescription and ReturnAll.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
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
	Set the value of the IncludeContainingOrder input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, the ContainingOrder container is returned in the response for each transaction node.
	*/
	public void setIncludeContainingOrder(Boolean value) {
		this.inputs.setInput("IncludeContainingOrder", value);
	}

	/** 
	Set the value of the IncludeContainingOrder input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, the ContainingOrder container is returned in the response for each transaction node.
	*/
	public void setIncludeContainingOrder(String value) {
		this.inputs.setInput("IncludeContainingOrder", value);	
	}
	/** 
	Set the value of the IncludeFinalValueFee input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, the Final Value Fee (FVF) for all order line items is returned in the response.
	*/
	public void setIncludeFinalValueFee(Boolean value) {
		this.inputs.setInput("IncludeFinalValueFee", value);
	}

	/** 
	Set the value of the IncludeFinalValueFee input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, the Final Value Fee (FVF) for all order line items is returned in the response.
	*/
	public void setIncludeFinalValueFee(String value) {
		this.inputs.setInput("IncludeFinalValueFee", value);	
	}
	/** 
	Set the value of the IncludeVariations input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, all variations defined for the item are returned at the root level.
	*/
	public void setIncludeVariations(Boolean value) {
		this.inputs.setInput("IncludeVariations", value);
	}

	/** 
	Set the value of the IncludeVariations input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, all variations defined for the item are returned at the root level.
	*/
	public void setIncludeVariations(String value) {
		this.inputs.setInput("IncludeVariations", value);	
	}
	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (required, string) The unique identifier for an eBay item listing.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the ModTimeFrom input for this Choreo. 

	@param String - (optional, date) Used to filter by date range (e.g., 2013-02-08T00:00:00.000Z).
	*/
	public void setModTimeFrom(String value) {
		this.inputs.setInput("ModTimeFrom", value);
	}


	/** 
	Set the value of the ModTimeTo input for this Choreo. 

	@param String - (optional, date) Used to filter by date range (e.g., 2013-02-08T00:00:00.000Z).
	*/
	public void setModTimeTo(String value) {
		this.inputs.setInput("ModTimeTo", value);
	}


	/** 
	Set the value of the NumberOfDays input for this Choreo. 

	@param Integer - (optional, integer) The number of days in the past to search for order line items.
	*/
	public void setNumberOfDays(Integer value) {
		this.inputs.setInput("NumberOfDays", value);
	}

	/** 
	Set the value of the NumberOfDays input for this Choreo as a String. 

	@param String - (optional, integer) The number of days in the past to search for order line items.
	*/
	public void setNumberOfDays(String value) {
		this.inputs.setInput("NumberOfDays", value);	
	}
	/** 
	Set the value of the OrderLineItemID input for this Choreo. 

	@param String - (optional, string) A unique identifier for an eBay order line item.
	*/
	public void setOrderLineItemID(String value) {
		this.inputs.setInput("OrderLineItemID", value);
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
	Set the value of the Platform input for this Choreo. 

	@param String - (optional, string) The name of the eBay co-branded site upon which the order line item was created. Valid values are: eBay, Express, Half, Shopping, or WorldOfGood.
	*/
	public void setPlatform(String value) {
		this.inputs.setInput("Platform", value);
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

	@param String - (optional, string) Include a TransactionID field in the request if you want to retrieve the data for a specific order line item (transaction).
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
	public GetItemTransactionsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetItemTransactionsResultSet(result);
	}
	
}
