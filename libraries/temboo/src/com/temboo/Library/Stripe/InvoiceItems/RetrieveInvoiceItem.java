package com.temboo.Library.Stripe.InvoiceItems;

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
RetrieveInvoiceItem

Retrieves invoice items with a specified id.
*/
public class RetrieveInvoiceItem extends Choreography {

	/**
	Create a new instance of the RetrieveInvoiceItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveInvoiceItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/InvoiceItems/RetrieveInvoiceItem"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The secret API Key provided by Stripe
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
	Set the value of the InvoiceItemID input for this Choreo. 

	@param String - (required, string) The unique identifier of the invoice item you want to retrieve
	*/
	public void setInvoiceItemID(String value) {
		this.inputs.setInput("InvoiceItemID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveInvoiceItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveInvoiceItemResultSet(result);
	}
	
}
