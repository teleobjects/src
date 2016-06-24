package com.temboo.Library.Yahoo.Finance;

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
GetStockQuote

Retrieves information for the specified stock symbol from Yahoo Finance.
*/
public class GetStockQuote extends Choreography {

	/**
	Create a new instance of the GetStockQuote Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetStockQuote(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yahoo/Finance/GetStockQuote"));
	}

	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the StockSymbol input for this Choreo. 

	@param String - (required, string) The stock ticker symbol to search for (e.g., AAPL, GOOG, etc).
	*/
	public void setStockSymbol(String value) {
		this.inputs.setInput("StockSymbol", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetStockQuoteResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetStockQuoteResultSet(result);
	}
	
}
