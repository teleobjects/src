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
PlaceOffer

Allows an authenticated user to to make a bid, a best offer, or a purchase on the item specified by the ItemID input field.
*/
public class PlaceOffer extends Choreography {

	/**
	Create a new instance of the PlaceOffer Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PlaceOffer(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/PlaceOffer"));
	}

	/** 
	Set the value of the PlaceOfferRequest input for this Choreo. 

	@param String - (optional, xml) The complete XML request body containing properties you wish to set. This can be used as an alternative to individual inputs that represent request properties.
	*/
	public void setPlaceOfferRequest(String value) {
		this.inputs.setInput("PlaceOfferRequest", value);
	}


	/** 
	Set the value of the Action input for this Choreo. 

	@param String - (conditional, string) Indicates the type of offer being made on the specified listing. Valid values are: Bid, Purchase, Accept, Counter, Decline, or Offer.
	*/
	public void setAction(String value) {
		this.inputs.setInput("Action", value);
	}


	/** 
	Set the value of the BestOfferID input for this Choreo. 

	@param String - (conditional, string) The ID of a Best Offer on an item. Required if Action is set to Accept or Decline.
	*/
	public void setBestOfferID(String value) {
		this.inputs.setInput("BestOfferID", value);
	}


	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (optional, string) The response detail level. Valid values are: ItemReturnAttributes, ItemReturnDescription, and ReturnAll.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
	}


	/** 
	Set the value of the EndUserIP input for this Choreo. 

	@param String - (conditional, string) The public IP address of the machine from which the request is sent.
	*/
	public void setEndUserIP(String value) {
		this.inputs.setInput("EndUserIP", value);
	}


	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (conditional, string) The ItemID that uniquely identifies the item listing to bid on.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the MaxBid input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The amount of the offer placed on the listing.
	*/
	public void setMaxBid(BigDecimal value) {
		this.inputs.setInput("MaxBid", value);
	}

	/** 
	Set the value of the MaxBid input for this Choreo as a String. 

	@param String - (conditional, decimal) The amount of the offer placed on the listing.
	*/
	public void setMaxBid(String value) {
		this.inputs.setInput("MaxBid", value);	
	}
	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (conditional, string) A message from the buyer to the seller.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Quantity input for this Choreo. 

	@param Integer - (conditional, integer) Specifies the number of items from the specified listing that the user intends to purchase. For auctions, this must be set to 1.
	*/
	public void setQuantity(Integer value) {
		this.inputs.setInput("Quantity", value);
	}

	/** 
	Set the value of the Quantity input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies the number of items from the specified listing that the user intends to purchase. For auctions, this must be set to 1.
	*/
	public void setQuantity(String value) {
		this.inputs.setInput("Quantity", value);	
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
	Set the value of the UserConsent input for this Choreo. 

	@param Boolean - (conditional, boolean) When set to true, confirms that the bidder read and agrees to eBay's privacy policy.
	*/
	public void setUserConsent(Boolean value) {
		this.inputs.setInput("UserConsent", value);
	}

	/** 
	Set the value of the UserConsent input for this Choreo as a String. 

	@param String - (conditional, boolean) When set to true, confirms that the bidder read and agrees to eBay's privacy policy.
	*/
	public void setUserConsent(String value) {
		this.inputs.setInput("UserConsent", value);	
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
	public PlaceOfferResultSet run() {
		JSONObject result = super.runWithResults();
		return new PlaceOfferResultSet(result);
	}
	
}
