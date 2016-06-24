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
CompleteSale

Allows the seller to perform the final steps for completing an order.
*/
public class CompleteSale extends Choreography {

	/**
	Create a new instance of the CompleteSale Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CompleteSale(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/CompleteSale"));
	}

	/** 
	Set the value of the CompleteSaleRequest input for this Choreo. 

	@param String - (optional, xml) The complete XML request body containing properties you wish to set. This can be used as an alternative to individual inputs that represent request properties.
	*/
	public void setCompleteSaleRequest(String value) {
		this.inputs.setInput("CompleteSaleRequest", value);
	}


	/** 
	Set the value of the CommentText input for this Choreo. 

	@param String - (optional, string) The comment text to leave Feedback about the buyer.
	*/
	public void setCommentText(String value) {
		this.inputs.setInput("CommentText", value);
	}


	/** 
	Set the value of the CommentType input for this Choreo. 

	@param String - (optional, string) The type of comment. Valid values are: Positive.
	*/
	public void setCommentType(String value) {
		this.inputs.setInput("CommentType", value);
	}


	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (conditional, string) The unique identifier for an eBay item listing that was sold. Either ItemID or TransactionID should be provided.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the Notes input for this Choreo. 

	@param String - (optional, string) A text field for shipping related notes.
	*/
	public void setNotes(String value) {
		this.inputs.setInput("Notes", value);
	}


	/** 
	Set the value of the OrderID input for this Choreo. 

	@param String - (optional, string) A unique identifier that identifies a single line item or multiple line item order.
	*/
	public void setOrderID(String value) {
		this.inputs.setInput("OrderID", value);
	}


	/** 
	Set the value of the OrderLineItemID input for this Choreo. 

	@param String - (optional, string) This is a unique identifier for an eBay order line item and is based upon the concatenation of ItemID and TransactionID, with a hyphen in between these two IDs.
	*/
	public void setOrderLineItemID(String value) {
		this.inputs.setInput("OrderLineItemID", value);
	}


	/** 
	Set the value of the Paid input for this Choreo. 

	@param Boolean - (conditional, boolean) Set to true to indicate that the item has been paid for. One of Feedback info, Shipped status or Paid status is required.
	*/
	public void setPaid(Boolean value) {
		this.inputs.setInput("Paid", value);
	}

	/** 
	Set the value of the Paid input for this Choreo as a String. 

	@param String - (conditional, boolean) Set to true to indicate that the item has been paid for. One of Feedback info, Shipped status or Paid status is required.
	*/
	public void setPaid(String value) {
		this.inputs.setInput("Paid", value);	
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
	Set the value of the ShipmentTrackingNumber input for this Choreo. 

	@param String - (optional, string) The tracking number for the package.
	*/
	public void setShipmentTrackingNumber(String value) {
		this.inputs.setInput("ShipmentTrackingNumber", value);
	}


	/** 
	Set the value of the Shipped input for this Choreo. 

	@param Boolean - (conditional, boolean) Set to true to indicate that the item has been shipped. One of Feedback info, Shipped status or Paid status is required.
	*/
	public void setShipped(Boolean value) {
		this.inputs.setInput("Shipped", value);
	}

	/** 
	Set the value of the Shipped input for this Choreo as a String. 

	@param String - (conditional, boolean) Set to true to indicate that the item has been shipped. One of Feedback info, Shipped status or Paid status is required.
	*/
	public void setShipped(String value) {
		this.inputs.setInput("Shipped", value);	
	}
	/** 
	Set the value of the ShippedTime input for this Choreo. 

	@param String - (optional, date) The date and time that the item was shipped.
	*/
	public void setShippedTime(String value) {
		this.inputs.setInput("ShippedTime", value);
	}


	/** 
	Set the value of the ShippingCarrierUsed input for this Choreo. 

	@param String - (optional, string) The carrier used to ship the item.
	*/
	public void setShippingCarrierUsed(String value) {
		this.inputs.setInput("ShippingCarrierUsed", value);
	}


	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	/** 
	Set the value of the TargetUser input for this Choreo. 

	@param String - (optional, string) The user ID of the buyer who you want to leave feedback for.
	*/
	public void setTargetUser(String value) {
		this.inputs.setInput("TargetUser", value);
	}


	/** 
	Set the value of the TransactionID input for this Choreo. 

	@param String - (conditional, string) The unique identifier for an eBay order line item (transaction). Either ItemID or TransactionID should be provided.
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
	public CompleteSaleResultSet run() {
		JSONObject result = super.runWithResults();
		return new CompleteSaleResultSet(result);
	}
	
}
