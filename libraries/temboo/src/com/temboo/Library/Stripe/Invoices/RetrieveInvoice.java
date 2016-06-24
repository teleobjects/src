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
RetrieveInvoice

Retrieves invoice details using the invoice id.
*/
public class RetrieveInvoice extends Choreography {

	/**
	Create a new instance of the RetrieveInvoice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveInvoice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Invoices/RetrieveInvoice"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
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

	@param String - (required, string) The unique identifier of the invoice you want to retrieve
	*/
	public void setInvoiceID(String value) {
		this.inputs.setInput("InvoiceID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveInvoiceResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveInvoiceResultSet(result);
	}
	
}
