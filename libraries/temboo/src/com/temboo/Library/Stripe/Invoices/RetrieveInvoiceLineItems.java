package com.temboo.Library.Stripe.Invoices;

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
RetrieveInvoiceLineItems

Retrieves a full list of line items contained in an invoice.
*/
public class RetrieveInvoiceLineItems extends Choreography {

	/**
	Create a new instance of the RetrieveInvoiceLineItems Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveInvoiceLineItems(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Invoices/RetrieveInvoiceLineItems"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) The number of line items to return
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) The number of line items to return
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the CustomerID input for this Choreo. 

	@param String - (optional, string) In the case of upcoming invoices, the customer of the upcoming invoice is required. In other cases it is ignored.
	*/
	public void setCustomerID(String value) {
		this.inputs.setInput("CustomerID", value);
	}


	/** 
	Set the value of the Expand input for this Choreo. 

	@param String - (optional, string) A Stripe object that should be expanded to show additional fields in the response.
	*/
	public void setExpand(String value) {
		this.inputs.setInput("Expand", value);
	}


	/** 
	Set the value of the InvoiceID input for this Choreo. 

	@param String - (required, string) The id of the invoice containing the line items to return
	*/
	public void setInvoiceID(String value) {
		this.inputs.setInput("InvoiceID", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The offset into the list of line items to start returning from, with 0 being the most recent
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The offset into the list of line items to start returning from, with 0 being the most recent
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveInvoiceLineItemsResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveInvoiceLineItemsResultSet(result);
	}
	
}
