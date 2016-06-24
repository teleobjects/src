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
LeaveFeedback

Enables a buyer and seller to leave feedback for their order partner at the conclusion of a successful order.
*/
public class LeaveFeedback extends Choreography {

	/**
	Create a new instance of the LeaveFeedback Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public LeaveFeedback(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/LeaveFeedback"));
	}

	/** 
	Set the value of the LeaveFeedbackRequest input for this Choreo. 

	@param String - (optional, xml) The complete XML request body containing properties you wish to set. This can be used as an alternative to individual inputs that represent request properties.
	*/
	public void setLeaveFeedbackRequest(String value) {
		this.inputs.setInput("LeaveFeedbackRequest", value);
	}


	/** 
	Set the value of the CommentText input for this Choreo. 

	@param String - (conditional, string) The comment text to leave Feedback about the buyer.
	*/
	public void setCommentText(String value) {
		this.inputs.setInput("CommentText", value);
	}


	/** 
	Set the value of the CommentType input for this Choreo. 

	@param String - (conditional, string) The type of comment. Valid values are: Positive, Negative, and Neutral.
	*/
	public void setCommentType(String value) {
		this.inputs.setInput("CommentType", value);
	}


	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (conditional, string) The unique identifier for an eBay item listing that was sold. Required unless OrderLineItemID is specified.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the OrderLineItemID input for this Choreo. 

	@param String - (optional, string) This is a unique identifier for an eBay order line item and is based upon the concatenation of ItemID and TransactionID, with a hyphen in between these two IDs.
	*/
	public void setOrderLineItemID(String value) {
		this.inputs.setInput("OrderLineItemID", value);
	}


	/** 
	Set the value of the Rating input for this Choreo. 

	@param Integer - (conditional, integer) A detailed numeric rating (1 through 5) for an order line item. This rating is applied to the subject provided for RatingDetail.
	*/
	public void setRating(Integer value) {
		this.inputs.setInput("Rating", value);
	}

	/** 
	Set the value of the Rating input for this Choreo as a String. 

	@param String - (conditional, integer) A detailed numeric rating (1 through 5) for an order line item. This rating is applied to the subject provided for RatingDetail.
	*/
	public void setRating(String value) {
		this.inputs.setInput("Rating", value);	
	}
	/** 
	Set the value of the RatingDetail input for this Choreo. 

	@param String - (conditional, string) The subject that is being rated. Valid values are: Communication, ItemAsDescribed, ShippingAndHandlingCharges, and ShippingTime.
	*/
	public void setRatingDetail(String value) {
		this.inputs.setInput("RatingDetail", value);
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
	Set the value of the TargetUser input for this Choreo. 

	@param String - (conditional, string) The user ID of the buyer who you want to leave feedback for.
	*/
	public void setTargetUser(String value) {
		this.inputs.setInput("TargetUser", value);
	}


	/** 
	Set the value of the TransactionID input for this Choreo. 

	@param String - (optional, string) The unique identifier for an eBay order line item (transaction). Required when there are multiple order ine items between the two order partners that require feedback.
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
	public LeaveFeedbackResultSet run() {
		JSONObject result = super.runWithResults();
		return new LeaveFeedbackResultSet(result);
	}
	
}
