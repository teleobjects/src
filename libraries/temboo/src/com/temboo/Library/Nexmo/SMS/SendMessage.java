package com.temboo.Library.Nexmo.SMS;

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
SendMessage

Send a text message to any global number.
*/
public class SendMessage extends Choreography {

	/**
	Create a new instance of the SendMessage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SendMessage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Nexmo/SMS/SendMessage"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) Your API Key provided to you by Nexmo.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) Your API Secret provided to you by Nexmo.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Body input for this Choreo. 

	@param String - (optional, string) Hex encoded binary data. (e.g. 0011223344556677).  Required when Type is binary.
	*/
	public void setBody(String value) {
		this.inputs.setInput("Body", value);
	}


	/** 
	Set the value of the CallbackID input for this Choreo. 

	@param String - (conditional, string) A unique identifier that is part of your Temboo callback URL registered at Nexmo. Required in order to listen for a reply. See Choreo description for details.
	*/
	public void setCallbackID(String value) {
		this.inputs.setInput("CallbackID", value);
	}


	/** 
	Set the value of the ClientReference input for this Choreo. 

	@param String - (optional, string) Include a note for your reference. (40 characters max).
	*/
	public void setClientReference(String value) {
		this.inputs.setInput("ClientReference", value);
	}


	/** 
	Set the value of the DeliveryReceipt input for this Choreo. 

	@param Integer - (optional, integer) Set to 1 to receive a Delivery Receipt for this message. Make sure to configure your "Callback URL" in your "API Settings".
	*/
	public void setDeliveryReceipt(Integer value) {
		this.inputs.setInput("DeliveryReceipt", value);
	}

	/** 
	Set the value of the DeliveryReceipt input for this Choreo as a String. 

	@param String - (optional, integer) Set to 1 to receive a Delivery Receipt for this message. Make sure to configure your "Callback URL" in your "API Settings".
	*/
	public void setDeliveryReceipt(String value) {
		this.inputs.setInput("DeliveryReceipt", value);	
	}
	/** 
	Set the value of the From input for this Choreo. 

	@param String - (required, string) The phone number associated with your Nexmo account e.g. 17185551234.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the MessageClass input for this Choreo. 

	@param Integer - (optional, integer) Set to 0 for Flash SMS.
	*/
	public void setMessageClass(Integer value) {
		this.inputs.setInput("MessageClass", value);
	}

	/** 
	Set the value of the MessageClass input for this Choreo as a String. 

	@param String - (optional, integer) Set to 0 for Flash SMS.
	*/
	public void setMessageClass(String value) {
		this.inputs.setInput("MessageClass", value);	
	}
	/** 
	Set the value of the NetworkCode input for this Choreo. 

	@param String - (optional, string) Sends this message to the specifed network operator (MCCMNC).
	*/
	public void setNetworkCode(String value) {
		this.inputs.setInput("NetworkCode", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "json" (the default) and "xml".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the TTL input for this Choreo. 

	@param Integer - (optional, integer) Message life span (Time to  live) in milliseconds.
	*/
	public void setTTL(Integer value) {
		this.inputs.setInput("TTL", value);
	}

	/** 
	Set the value of the TTL input for this Choreo as a String. 

	@param String - (optional, integer) Message life span (Time to  live) in milliseconds.
	*/
	public void setTTL(String value) {
		this.inputs.setInput("TTL", value);	
	}
	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (conditional, string) Required when Type is "text".  Body of the text message (with a maximum length of 3200 characters).
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	/** 
	Set the value of the Timeout input for this Choreo. 

	@param Integer - (conditional, integer) The amount of time (in minutes) to wait for a reply when a CallbackID is provided. Defaults to 10. See Choreo description for details.
	*/
	public void setTimeout(Integer value) {
		this.inputs.setInput("Timeout", value);
	}

	/** 
	Set the value of the Timeout input for this Choreo as a String. 

	@param String - (conditional, integer) The amount of time (in minutes) to wait for a reply when a CallbackID is provided. Defaults to 10. See Choreo description for details.
	*/
	public void setTimeout(String value) {
		this.inputs.setInput("Timeout", value);	
	}
	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) The mobile number in international format (e.g. 447525856424 or 00447525856424 when sending to UK).
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) This can be omitted for text (default), but is required when sending a Binary (binary), WAP Push (wappush), Unicode message (unicode), VCal (vcal) or VCard (vcard).
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the UDH input for this Choreo. 

	@param String - (optional, string) Hex encoded User data header. (e.g. 06050415811581) (Required when Type is binary).
	*/
	public void setUDH(String value) {
		this.inputs.setInput("UDH", value);
	}


	/** 
	Set the value of the VCal input for this Choreo. 

	@param String - (optional, string) Correctly formatted VCal text body.
	*/
	public void setVCal(String value) {
		this.inputs.setInput("VCal", value);
	}


	/** 
	Set the value of the VCard input for this Choreo. 

	@param String - (optional, string) Correctly formatted VCard text body.
	*/
	public void setVCard(String value) {
		this.inputs.setInput("VCard", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SendMessageResultSet run() {
		JSONObject result = super.runWithResults();
		return new SendMessageResultSet(result);
	}
	
}
