package com.temboo.Library.Amazon.Marketplace.OutboundShipments;

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
ListAllFulfillmentOrders

Returns a list of fulfillment orders fulfilled after (or at) a specified date or by fulfillment method.
*/
public class ListAllFulfillmentOrders extends Choreography {

	/**
	Create a new instance of the ListAllFulfillmentOrders Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListAllFulfillmentOrders(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/OutboundShipments/ListAllFulfillmentOrders"));
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
	Set the value of the Endpoint input for this Choreo. 

	@param String - (conditional, string) The base URL for the MWS endpoint. Defaults to mws.amazonservices.co.uk.
	*/
	public void setEndpoint(String value) {
		this.inputs.setInput("Endpoint", value);
	}


	/** 
	Set the value of the FulfillmentMethod input for this Choreo. 

	@param String - (optional, string) A value used for selecting fulfillment orders based on their fulfillment method. "Consumer" indicates a customer order, and "Removal" indicates that the inventory should be returned to the specified.
	*/
	public void setFulfillmentMethod(String value) {
		this.inputs.setInput("FulfillmentMethod", value);
	}


	/** 
	Set the value of the MWSAuthToken input for this Choreo. 

	@param String - (optional, string) The Amazon MWS authorization token for the given seller and developer.
	*/
	public void setMWSAuthToken(String value) {
		this.inputs.setInput("MWSAuthToken", value);
	}


	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) The value returned in the NextPageToken output of this Choreo when there are multiple pages of orders to retrieve.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the QueryStartDateTime input for this Choreo. 

	@param String - (optional, date) A date used for selecting items that have had changes in inventory availability after (or at) a specified time, in ISO 8601 date format (i.e. 2012-01-01).
	*/
	public void setQueryStartDateTime(String value) {
		this.inputs.setInput("QueryStartDateTime", value);
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
	public ListAllFulfillmentOrdersResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListAllFulfillmentOrdersResultSet(result);
	}
	
}
