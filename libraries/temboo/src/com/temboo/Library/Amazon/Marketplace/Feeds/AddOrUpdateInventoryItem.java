package com.temboo.Library.Amazon.Marketplace.Feeds;

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
AddOrUpdateInventoryItem

Add or update an individual inventory listing.
*/
public class AddOrUpdateInventoryItem extends Choreography {

	/**
	Create a new instance of the AddOrUpdateInventoryItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddOrUpdateInventoryItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Feeds/AddOrUpdateInventoryItem"));
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
	Set the value of the ExpeditedShipping input for this Choreo. 

	@param String - (optional, string) The expedited shipping options that you offer for this item. Valid values: 3 = UK Only; N = None, no express delivery offered.
	*/
	public void setExpeditedShipping(String value) {
		this.inputs.setInput("ExpeditedShipping", value);
	}


	/** 
	Set the value of the FulfillmentCenterId input for this Choreo. 

	@param String - (conditional, string) For those merchants using Amazon fulfillment services, this designates which fulfillment network will be used. Required when using Amazon fulfillment services. Valid values are: AMAZON_EU, DEFAULT.
	*/
	public void setFulfillmentCenterId(String value) {
		this.inputs.setInput("FulfillmentCenterId", value);
	}


	/** 
	Set the value of the ItemCondition input for this Choreo. 

	@param Integer - (conditional, integer) A numerical entry that indicates the condition of the item. Required for new listings. Valid values are: 1-11. See documentation for description of item condition numeric values.
	*/
	public void setItemCondition(Integer value) {
		this.inputs.setInput("ItemCondition", value);
	}

	/** 
	Set the value of the ItemCondition input for this Choreo as a String. 

	@param String - (conditional, integer) A numerical entry that indicates the condition of the item. Required for new listings. Valid values are: 1-11. See documentation for description of item condition numeric values.
	*/
	public void setItemCondition(String value) {
		this.inputs.setInput("ItemCondition", value);	
	}
	/** 
	Set the value of the ItemNote input for this Choreo. 

	@param String - (optional, string) A description or note for the item you're adding or updating.
	*/
	public void setItemNote(String value) {
		this.inputs.setInput("ItemNote", value);
	}


	/** 
	Set the value of the MWSAuthToken input for this Choreo. 

	@param String - (optional, string) The Amazon MWS authorization token for the given seller and developer.
	*/
	public void setMWSAuthToken(String value) {
		this.inputs.setInput("MWSAuthToken", value);
	}


	/** 
	Set the value of the Price input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The price at which the merchant offers the product for sale. Required if ProductId is provided.
	*/
	public void setPrice(BigDecimal value) {
		this.inputs.setInput("Price", value);
	}

	/** 
	Set the value of the Price input for this Choreo as a String. 

	@param String - (conditional, decimal) The price at which the merchant offers the product for sale. Required if ProductId is provided.
	*/
	public void setPrice(String value) {
		this.inputs.setInput("Price", value);	
	}
	/** 
	Set the value of the ProductId input for this Choreo. 

	@param String - (conditional, string) A standard, alphanumeric string that uniquely identifies the product. This could be a UPC, EAN or ISBN.  This is a required field if product-id-type is provided.
	*/
	public void setProductId(String value) {
		this.inputs.setInput("ProductId", value);
	}


	/** 
	Set the value of the ProductIdType input for this Choreo. 

	@param Integer - (conditional, integer) The type of standard, unique identifier entered in the product-id field. This is a required field if product-id is provided. Valid values are: 1 (ASIN), 2 (ISBN), 3 (UPC), 4  (EAN).
	*/
	public void setProductIdType(Integer value) {
		this.inputs.setInput("ProductIdType", value);
	}

	/** 
	Set the value of the ProductIdType input for this Choreo as a String. 

	@param String - (conditional, integer) The type of standard, unique identifier entered in the product-id field. This is a required field if product-id is provided. Valid values are: 1 (ASIN), 2 (ISBN), 3 (UPC), 4  (EAN).
	*/
	public void setProductIdType(String value) {
		this.inputs.setInput("ProductIdType", value);	
	}
	/** 
	Set the value of the Quantity input for this Choreo. 

	@param Integer - (conditional, integer) Enter the quantity of the item you are making available for sale. Required for merchant-fulfilled items. Leave blank for amazon-fullfilled items.
	*/
	public void setQuantity(Integer value) {
		this.inputs.setInput("Quantity", value);
	}

	/** 
	Set the value of the Quantity input for this Choreo as a String. 

	@param String - (conditional, integer) Enter the quantity of the item you are making available for sale. Required for merchant-fulfilled items. Leave blank for amazon-fullfilled items.
	*/
	public void setQuantity(String value) {
		this.inputs.setInput("Quantity", value);	
	}
	/** 
	Set the value of the SKU input for this Choreo. 

	@param String - (required, string) A unique identifier for the product, assigned by the merchant. The SKU must be unique for each product listed.
	*/
	public void setSKU(String value) {
		this.inputs.setInput("SKU", value);
	}


	/** 
	Set the value of the TimeToWait input for this Choreo. 

	@param Integer - (optional, integer) By default, the Choreo will wait for 10 minutes to see if the report is ready for retrieval. Max is 120 minutes.
	*/
	public void setTimeToWait(Integer value) {
		this.inputs.setInput("TimeToWait", value);
	}

	/** 
	Set the value of the TimeToWait input for this Choreo as a String. 

	@param String - (optional, integer) By default, the Choreo will wait for 10 minutes to see if the report is ready for retrieval. Max is 120 minutes.
	*/
	public void setTimeToWait(String value) {
		this.inputs.setInput("TimeToWait", value);	
	}
	/** 
	Set the value of the WillShipInternationally input for this Choreo. 

	@param Integer - (optional, integer) Specify your international shipping options. Valid values are: 3 = UK Only; 4 = UK and Europe; 5 = UK, Europe, and North America; 6 = Worldwide
	*/
	public void setWillShipInternationally(Integer value) {
		this.inputs.setInput("WillShipInternationally", value);
	}

	/** 
	Set the value of the WillShipInternationally input for this Choreo as a String. 

	@param String - (optional, integer) Specify your international shipping options. Valid values are: 3 = UK Only; 4 = UK and Europe; 5 = UK, Europe, and North America; 6 = Worldwide
	*/
	public void setWillShipInternationally(String value) {
		this.inputs.setInput("WillShipInternationally", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddOrUpdateInventoryItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddOrUpdateInventoryItemResultSet(result);
	}
	
}
