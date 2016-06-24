package com.temboo.Library.Amazon.Marketplace.Orders;

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
ListOrders

Returns orders created during a time frame that you specify.
*/
public class ListOrders extends Choreography {

	/**
	Create a new instance of the ListOrders Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListOrders(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Orders/ListOrders"));
	}

	/** 
	Set the value of the AWSAccessKeyId input for this Choreo. 

	@param String - (required, string) The Access Key ID provided by Amazon Web Services.
	*/
	public void setAWSAccessKeyId(String value) {
		this.inputs.setInput("AWSAccessKeyId", value);
	}


	/** 
	Set the value of the AWSMarketplaceId input for this Choreo. 

	@param String - (required, string) The Marketplace ID provided by Amazon Web Services.
	*/
	public void setAWSMarketplaceId(String value) {
		this.inputs.setInput("AWSMarketplaceId", value);
	}


	/** 
	Set the value of the AWSMerchantId input for this Choreo. 

	@param String - (required, string) The Merchant ID provided by Amazon Web Services.
	*/
	public void setAWSMerchantId(String value) {
		this.inputs.setInput("AWSMerchantId", value);
	}


	/** 
	Set the value of the AWSSecretKeyId input for this Choreo. 

	@param String - (required, string) The Secret Key ID provided by Amazon Web Services.
	*/
	public void setAWSSecretKeyId(String value) {
		this.inputs.setInput("AWSSecretKeyId", value);
	}


	/** 
	Set the value of the CreatedAfter input for this Choreo. 

	@param String - (optional, date) A date used for selecting orders created after (or at) a specified time, in ISO 8601 date format (i.e. 2012-01-01). Defaults to today's date if not provided.
	*/
	public void setCreatedAfter(String value) {
		this.inputs.setInput("CreatedAfter", value);
	}


	/** 
	Set the value of the CreatedBefore input for this Choreo. 

	@param String - (optional, date) A date used for selecting orders created before (or at) a specified time, in ISO 8601 date format (i.e. 2012-01-01).
	*/
	public void setCreatedBefore(String value) {
		this.inputs.setInput("CreatedBefore", value);
	}


	/** 
	Set the value of the Endpoint input for this Choreo. 

	@param String - (conditional, string) The base URL for the MWS endpoint. Defaults to mws.amazonservices.co.uk.
	*/
	public void setEndpoint(String value) {
		this.inputs.setInput("Endpoint", value);
	}


	/** 
	Set the value of the FullfillmentChannel input for this Choreo. 

	@param String - (optional, string) A string indicating how an order was fulfilled. Use "AFN" for Amazon fulfilled orders, and "MFN" for seller fulfilled orders.
	*/
	public void setFullfillmentChannel(String value) {
		this.inputs.setInput("FullfillmentChannel", value);
	}


	/** 
	Set the value of the LastUpdatedAfter input for this Choreo. 

	@param String - (optional, date) A date used for selecting orders that were last updated after (or at) a specified time, in ISO 8601 date format (i.e. 2012-01-01). Cannot be specified if CreatedAfter is specified.
	*/
	public void setLastUpdatedAfter(String value) {
		this.inputs.setInput("LastUpdatedAfter", value);
	}


	/** 
	Set the value of the LastUpdatedBefore input for this Choreo. 

	@param String - (optional, date) A date used for selecting orders that were last updated before (or at) a specified time, in ISO 8601 date format (i.e. 2012-01-01). Cannot be specified if CreatedAfter is specified.
	*/
	public void setLastUpdatedBefore(String value) {
		this.inputs.setInput("LastUpdatedBefore", value);
	}


	/** 
	Set the value of the MWSAuthToken input for this Choreo. 

	@param String - (optional, string) The Amazon MWS authorization token for the given seller and developer.
	*/
	public void setMWSAuthToken(String value) {
		this.inputs.setInput("MWSAuthToken", value);
	}


	/** 
	Set the value of the MaxResultsPerPage input for this Choreo. 

	@param Integer - (optional, integer) A number that indicates the maximum number of orders that can be returned per page. Valid values are: 1-100.
	*/
	public void setMaxResultsPerPage(Integer value) {
		this.inputs.setInput("MaxResultsPerPage", value);
	}

	/** 
	Set the value of the MaxResultsPerPage input for this Choreo as a String. 

	@param String - (optional, integer) A number that indicates the maximum number of orders that can be returned per page. Valid values are: 1-100.
	*/
	public void setMaxResultsPerPage(String value) {
		this.inputs.setInput("MaxResultsPerPage", value);	
	}
	/** 
	Set the value of the OrderStatus input for this Choreo. 

	@param String - (optional, string) One or more OrderStatus values separated by commas. This options selects only orders with a certain status (e.g. Pending, Unshipped, PartiallyShipped, Shipped, Canceled, Unfulfillable, etc).
	*/
	public void setOrderStatus(String value) {
		this.inputs.setInput("OrderStatus", value);
	}


	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) The value returned in the NextPageToken output of this Choreo when there are multiple pages of orders to retrieve.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the PaymentMethod input for this Choreo. 

	@param String - (optional, string) Used to select only orders of a certain payment type. Valid values are: COD (cash on delivery), CVS (convenience store payment), or Other (Any payment method other than COD or CVS).
	*/
	public void setPaymentMethod(String value) {
		this.inputs.setInput("PaymentMethod", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListOrdersResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListOrdersResultSet(result);
	}
	
}
