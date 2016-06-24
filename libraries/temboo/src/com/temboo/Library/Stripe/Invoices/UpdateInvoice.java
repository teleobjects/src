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
UpdateInvoice

Updates an existing invoice.
*/
public class UpdateInvoice extends Choreography {

	/**
	Create a new instance of the UpdateInvoice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateInvoice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Invoices/UpdateInvoice"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Closed input for this Choreo. 

	@param Boolean - (conditional, boolean) Whether or not the invoice should be closed or not. To close an invoice, set this to "true".
	*/
	public void setClosed(Boolean value) {
		this.inputs.setInput("Closed", value);
	}

	/** 
	Set the value of the Closed input for this Choreo as a String. 

	@param String - (conditional, boolean) Whether or not the invoice should be closed or not. To close an invoice, set this to "true".
	*/
	public void setClosed(String value) {
		this.inputs.setInput("Closed", value);	
	}
	/** 
	Set the value of the InvoiceID input for this Choreo. 

	@param String - (required, string) The id of the invoice to update.
	*/
	public void setInvoiceID(String value) {
		this.inputs.setInput("InvoiceID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateInvoiceResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateInvoiceResultSet(result);
	}
	
}
