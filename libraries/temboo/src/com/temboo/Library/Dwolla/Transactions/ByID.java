package com.temboo.Library.Dwolla.Transactions;

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
ByID

Retrieves the account information about the specified transaction by Transaction ID.
*/
public class ByID extends Choreography {

	/**
	Create a new instance of the ByID Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ByID(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dwolla/Transactions/ByID"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) A valid OAuth token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the TransactionID input for this Choreo. 

	@param Integer - (required, integer) Transaction identifier of the transaction being requested.
	*/
	public void setTransactionID(Integer value) {
		this.inputs.setInput("TransactionID", value);
	}

	/** 
	Set the value of the TransactionID input for this Choreo as a String. 

	@param String - (required, integer) Transaction identifier of the transaction being requested.
	*/
	public void setTransactionID(String value) {
		this.inputs.setInput("TransactionID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ByIDResultSet run() {
		JSONObject result = super.runWithResults();
		return new ByIDResultSet(result);
	}
	
}
