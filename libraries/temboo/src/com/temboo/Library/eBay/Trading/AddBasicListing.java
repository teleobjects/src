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
AddBasicListing

Allows you create a basic listing on eBay using scalar inputs rather than an XML request.
*/
public class AddBasicListing extends Choreography {

	/**
	Create a new instance of the AddBasicListing Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddBasicListing(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/AddBasicListing"));
	}

	/** 
	Set the value of the BuyItNowPrice input for this Choreo. 

	@param BigDecimal - (optional, decimal) Allows a user to purchase the item at a Buy It Now price and end the auction immediately.
	*/
	public void setBuyItNowPrice(BigDecimal value) {
		this.inputs.setInput("BuyItNowPrice", value);
	}

	/** 
	Set the value of the BuyItNowPrice input for this Choreo as a String. 

	@param String - (optional, decimal) Allows a user to purchase the item at a Buy It Now price and end the auction immediately.
	*/
	public void setBuyItNowPrice(String value) {
		this.inputs.setInput("BuyItNowPrice", value);	
	}
	/** 
	Set the value of the CategoryID input for this Choreo. 

	@param Integer - (conditional, integer) The numeric ID for a category on eBay. Category IDs can be retrieved with the GetCategories Choreo.
	*/
	public void setCategoryID(Integer value) {
		this.inputs.setInput("CategoryID", value);
	}

	/** 
	Set the value of the CategoryID input for this Choreo as a String. 

	@param String - (conditional, integer) The numeric ID for a category on eBay. Category IDs can be retrieved with the GetCategories Choreo.
	*/
	public void setCategoryID(String value) {
		this.inputs.setInput("CategoryID", value);	
	}
	/** 
	Set the value of the ConditionID input for this Choreo. 

	@param Integer - (conditional, integer) The numeric ID (e.g., 1000) for the item condition.
	*/
	public void setConditionID(Integer value) {
		this.inputs.setInput("ConditionID", value);
	}

	/** 
	Set the value of the ConditionID input for this Choreo as a String. 

	@param String - (conditional, integer) The numeric ID (e.g., 1000) for the item condition.
	*/
	public void setConditionID(String value) {
		this.inputs.setInput("ConditionID", value);	
	}
	/** 
	Set the value of the Country input for this Choreo. 

	@param String - (conditional, string) The country where the item is located in.
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the Currency input for this Choreo. 

	@param String - (conditional, string) The currency associated with the item price.
	*/
	public void setCurrency(String value) {
		this.inputs.setInput("Currency", value);
	}


	/** 
	Set the value of the DispatchTimeMax input for this Choreo. 

	@param Integer - (conditional, integer) Specifies the maximum number of business days the seller commits to for preparing an item to be shipped after receiving a cleared payment.
	*/
	public void setDispatchTimeMax(Integer value) {
		this.inputs.setInput("DispatchTimeMax", value);
	}

	/** 
	Set the value of the DispatchTimeMax input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies the maximum number of business days the seller commits to for preparing an item to be shipped after receiving a cleared payment.
	*/
	public void setDispatchTimeMax(String value) {
		this.inputs.setInput("DispatchTimeMax", value);	
	}
	/** 
	Set the value of the ExpeditedService input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not the seller is offering expedited shipping service options.
	*/
	public void setExpeditedService(Boolean value) {
		this.inputs.setInput("ExpeditedService", value);
	}

	/** 
	Set the value of the ExpeditedService input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not the seller is offering expedited shipping service options.
	*/
	public void setExpeditedService(String value) {
		this.inputs.setInput("ExpeditedService", value);	
	}
	/** 
	Set the value of the ItemDescription input for this Choreo. 

	@param String - (conditional, string) The seller's description of the item.
	*/
	public void setItemDescription(String value) {
		this.inputs.setInput("ItemDescription", value);
	}


	/** 
	Set the value of the ListingDuration input for this Choreo. 

	@param String - (conditional, string) The number of days the seller wants the listing to be active (e.g., Days_7). A complete list of accepted values is returned when calling GetCategoryFeatures with DetailLevel set to ReturnAll.
	*/
	public void setListingDuration(String value) {
		this.inputs.setInput("ListingDuration", value);
	}


	/** 
	Set the value of the ListingType input for this Choreo. 

	@param String - (optional, string) The format of the listing the seller wants to use. Valid values are: AdType, Chinese, FixedPriceItem, Half, LeadGeneration.
	*/
	public void setListingType(String value) {
		this.inputs.setInput("ListingType", value);
	}


	/** 
	Set the value of the PayPalEmailAddress input for this Choreo. 

	@param String - (conditional, string) The seller's PayPal email address. Required when a PaymentMethod is PayPal.
	*/
	public void setPayPalEmailAddress(String value) {
		this.inputs.setInput("PayPalEmailAddress", value);
	}


	/** 
	Set the value of the PaymentMethods input for this Choreo. 

	@param String - (conditional, string) Identifies the payment method (such as PayPal) that the seller will accept when the buyer pays for the item. This can be a comma-separated list (e.g., VisaMC,PayPal).
	*/
	public void setPaymentMethods(String value) {
		this.inputs.setInput("PaymentMethods", value);
	}


	/** 
	Set the value of the PictureURL input for this Choreo. 

	@param String - (conditional, string) The URL for a picture associated with an item. Multiple URLs can be specified as a comma-separated list.
	*/
	public void setPictureURL(String value) {
		this.inputs.setInput("PictureURL", value);
	}


	/** 
	Set the value of the PostalCode input for this Choreo. 

	@param String - (conditional, string) The Postal code of the place where the item is located.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);
	}


	/** 
	Set the value of the Quantity input for this Choreo. 

	@param Integer - (conditional, integer) Indicates the quantity of items available for purchase in the listing. Required for all auction listings and for non-variation, fixed-price listings. For auction listings, this value is always '1'.
	*/
	public void setQuantity(Integer value) {
		this.inputs.setInput("Quantity", value);
	}

	/** 
	Set the value of the Quantity input for this Choreo as a String. 

	@param String - (conditional, integer) Indicates the quantity of items available for purchase in the listing. Required for all auction listings and for non-variation, fixed-price listings. For auction listings, this value is always '1'.
	*/
	public void setQuantity(String value) {
		this.inputs.setInput("Quantity", value);	
	}
	/** 
	Set the value of the RefundOption input for this Choreo. 

	@param String - (optional, string) Indicates how the seller will compensate the buyer for a returned item (e.g. MoneyBack).
	*/
	public void setRefundOption(String value) {
		this.inputs.setInput("RefundOption", value);
	}


	/** 
	Set the value of the ReservePrice input for this Choreo. 

	@param BigDecimal - (optional, decimal) The lowest price at which the seller is willing to sell the item.
	*/
	public void setReservePrice(BigDecimal value) {
		this.inputs.setInput("ReservePrice", value);
	}

	/** 
	Set the value of the ReservePrice input for this Choreo as a String. 

	@param String - (optional, decimal) The lowest price at which the seller is willing to sell the item.
	*/
	public void setReservePrice(String value) {
		this.inputs.setInput("ReservePrice", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ReturnPolicyDescription input for this Choreo. 

	@param String - (optional, string) The text description of return policy details.
	*/
	public void setReturnPolicyDescription(String value) {
		this.inputs.setInput("ReturnPolicyDescription", value);
	}


	/** 
	Set the value of the ReturnsAcceptedOption input for this Choreo. 

	@param String - (conditional, string) Indicates whether the seller allows the buyer to return the item (e.g., ReturnsAccepted).
	*/
	public void setReturnsAcceptedOption(String value) {
		this.inputs.setInput("ReturnsAcceptedOption", value);
	}


	/** 
	Set the value of the ReturnsWithinOption input for this Choreo. 

	@param String - (optional, string) The period of time the buyer has to return the item (e.g., Days_14). To accepted values for this field, call GeteBayDetails with DetailName set to ReturnPolicyDetails.
	*/
	public void setReturnsWithinOption(String value) {
		this.inputs.setInput("ReturnsWithinOption", value);
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
	Set the value of the ShippingService input for this Choreo. 

	@param String - (conditional, string) The name of the shipping service offered (e.g. UPSGround, USPSMedia).
	*/
	public void setShippingService(String value) {
		this.inputs.setInput("ShippingService", value);
	}


	/** 
	Set the value of the ShippingServiceAdditionalCost input for this Choreo. 

	@param BigDecimal - (optional, decimal) Shipping costs in addition to the value specified for the ShippingServiceCost parameter.
	*/
	public void setShippingServiceAdditionalCost(BigDecimal value) {
		this.inputs.setInput("ShippingServiceAdditionalCost", value);
	}

	/** 
	Set the value of the ShippingServiceAdditionalCost input for this Choreo as a String. 

	@param String - (optional, decimal) Shipping costs in addition to the value specified for the ShippingServiceCost parameter.
	*/
	public void setShippingServiceAdditionalCost(String value) {
		this.inputs.setInput("ShippingServiceAdditionalCost", value);	
	}
	/** 
	Set the value of the ShippingServiceCost input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The cost for shipping the item.
	*/
	public void setShippingServiceCost(BigDecimal value) {
		this.inputs.setInput("ShippingServiceCost", value);
	}

	/** 
	Set the value of the ShippingServiceCost input for this Choreo as a String. 

	@param String - (conditional, decimal) The cost for shipping the item.
	*/
	public void setShippingServiceCost(String value) {
		this.inputs.setInput("ShippingServiceCost", value);	
	}
	/** 
	Set the value of the ShippingType input for this Choreo. 

	@param String - (conditional, string) The shipping cost model offered by the seller. Valid values are: Calculated, CalculatedDomesticFlatInternational, Flat, FlatDomesticCalculatedInternational, FreightFlat, NotSpecified.
	*/
	public void setShippingType(String value) {
		this.inputs.setInput("ShippingType", value);
	}


	/** 
	Set the value of the Site input for this Choreo. 

	@param String - (optional, string) The name of the site on which the item is listed. This should corresponse to the SiteID. Default value is "US".
	*/
	public void setSite(String value) {
		this.inputs.setInput("Site", value);
	}


	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	/** 
	Set the value of the StartPrice input for this Choreo. 

	@param BigDecimal - (conditional, decimal) This value indicates the starting price of the item when it is listed for the first time.
	*/
	public void setStartPrice(BigDecimal value) {
		this.inputs.setInput("StartPrice", value);
	}

	/** 
	Set the value of the StartPrice input for this Choreo as a String. 

	@param String - (conditional, decimal) This value indicates the starting price of the item when it is listed for the first time.
	*/
	public void setStartPrice(String value) {
		this.inputs.setInput("StartPrice", value);	
	}
	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (conditional, string) The title of the item as it appears in the listing or search results.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
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
	public AddBasicListingResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddBasicListingResultSet(result);
	}
	
}
