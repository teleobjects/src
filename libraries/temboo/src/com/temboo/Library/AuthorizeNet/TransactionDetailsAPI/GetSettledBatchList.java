package com.temboo.Library.AuthorizeNet.TransactionDetailsAPI;

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
GetSettledBatchList

Returns data about a settled batch including: Batch ID, Settlement Time, and Settlement State, and Batch Statistics by payment type.
*/
public class GetSettledBatchList extends Choreography {

	/**
	Create a new instance of the GetSettledBatchList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetSettledBatchList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/AuthorizeNet/TransactionDetailsAPI/GetSettledBatchList"));
	}

	/** 
	Set the value of the APILoginId input for this Choreo. 

	@param String - (required, string) The API Login Id provided by Authorize.net when signing up for a developer account.
	*/
	public void setAPILoginId(String value) {
		this.inputs.setInput("APILoginId", value);
	}


	/** 
	Set the value of the Endpoint input for this Choreo. 

	@param String - (optional, string) Set to api.authorize.net when running in production. Defaults to apitest.authorize.net for sandbox testing.
	*/
	public void setEndpoint(String value) {
		this.inputs.setInput("Endpoint", value);
	}


	/** 
	Set the value of the FirstSettlementDate input for this Choreo. 

	@param String - (required, date) Can be an epoch timestamp in milliseconds or formatted like 2010-12-01T00:00:00Z.
	*/
	public void setFirstSettlementDate(String value) {
		this.inputs.setInput("FirstSettlementDate", value);
	}


	/** 
	Set the value of the IncludeStatistics input for this Choreo. 

	@param Boolean - (optional, boolean) When 1 is specified, batch statistics by payment type are returned. Defaults to 1.
	*/
	public void setIncludeStatistics(Boolean value) {
		this.inputs.setInput("IncludeStatistics", value);
	}

	/** 
	Set the value of the IncludeStatistics input for this Choreo as a String. 

	@param String - (optional, boolean) When 1 is specified, batch statistics by payment type are returned. Defaults to 1.
	*/
	public void setIncludeStatistics(String value) {
		this.inputs.setInput("IncludeStatistics", value);	
	}
	/** 
	Set the value of the LastSettlementDate input for this Choreo. 

	@param String - (required, date) Can be an epoch timestamp in milliseconds or formatted like 2010-12-01T00:00:00Z.
	*/
	public void setLastSettlementDate(String value) {
		this.inputs.setInput("LastSettlementDate", value);
	}


	/** 
	Set the value of the TransactionKey input for this Choreo. 

	@param String - (required, string) The TransactionKey provided by Authorize.net when signing up for a developer account.
	*/
	public void setTransactionKey(String value) {
		this.inputs.setInput("TransactionKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetSettledBatchListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetSettledBatchListResultSet(result);
	}
	
}
