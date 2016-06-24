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
AddOrUpdateInventoryItems

Adds or updates one or more inventory listings in your Seller Central account with a given flat flile.
*/
public class AddOrUpdateInventoryItems extends Choreography {

	/**
	Create a new instance of the AddOrUpdateInventoryItems Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddOrUpdateInventoryItems(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Feeds/AddOrUpdateInventoryItems"));
	}

	/** 
	Set the value of the FeedData input for this Choreo. 

	@param String - (conditional, multiline) The feed data to sumbit to Amazon Marketplace.
	*/
	public void setFeedData(String value) {
		this.inputs.setInput("FeedData", value);
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
	Set the value of the MWSAuthToken input for this Choreo. 

	@param String - (optional, string) The Amazon MWS authorization token for the given seller and developer.
	*/
	public void setMWSAuthToken(String value) {
		this.inputs.setInput("MWSAuthToken", value);
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
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - The path to the vault file you want to submit. Required unless you using the FeedData input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddOrUpdateInventoryItemsResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddOrUpdateInventoryItemsResultSet(result);
	}
	
}
