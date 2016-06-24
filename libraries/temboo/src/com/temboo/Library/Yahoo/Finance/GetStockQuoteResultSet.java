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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the GetStockQuote Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetStockQuoteResultSet extends ResultSet {
		
	public GetStockQuoteResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Ask" output from this Choreo execution

	@return String - (decimal) The asking price.
	*/
	public String getAsk() {
		return this.getResultString("Ask");
	}
	/** 
	Retrieve the value for the "Bid" output from this Choreo execution

	@return String - (decimal) The bid price.
	*/
	public String getBid() {
		return this.getResultString("Bid");
	}
	/** 
	Retrieve the value for the "Change" output from this Choreo execution

	@return String - (string) The change in the stock price.
	*/
	public String getChange() {
		return this.getResultString("Change");
	}
	/** 
	Retrieve the value for the "DaysHigh" output from this Choreo execution

	@return String - (decimal) The high price of the day.
	*/
	public String getDaysHigh() {
		return this.getResultString("DaysHigh");
	}
	/** 
	Retrieve the value for the "DaysLow" output from this Choreo execution

	@return String - (decimal) The low price of the day.
	*/
	public String getDaysLow() {
		return this.getResultString("DaysLow");
	}
	/** 
	Retrieve the value for the "LastTradePriceOnly" output from this Choreo execution

	@return String - (decimal) The last trade price.
	*/
	public String getLastTradePriceOnly() {
		return this.getResultString("LastTradePriceOnly");
	}
	/** 
	Retrieve the value for the "Open" output from this Choreo execution

	@return String - (decimal) The price when the market last opened.
	*/
	public String getOpen() {
		return this.getResultString("Open");
	}
	/** 
	Retrieve the value for the "PreviousClose" output from this Choreo execution

	@return String - (decimal) The previous closing price.
	*/
	public String getPreviousClose() {
		return this.getResultString("PreviousClose");
	}
	/** 
	Retrieve the value for the "Volume" output from this Choreo execution

	@return String - (integer) The volume traded.
	*/
	public String getVolume() {
		return this.getResultString("Volume");
	}
	/** 
	Retrieve the value for the "YearHigh" output from this Choreo execution

	@return String - (decimal) The price for the year high.
	*/
	public String getYearHigh() {
		return this.getResultString("YearHigh");
	}
	/** 
	Retrieve the value for the "YearLow" output from this Choreo execution

	@return String - (decimal) The price for the year low.
	*/
	public String getYearLow() {
		return this.getResultString("YearLow");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Yahoo Finance.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}