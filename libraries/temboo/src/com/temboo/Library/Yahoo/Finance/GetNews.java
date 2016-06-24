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
GetNews

Retrieves the most recent Yahoo Finance Company or Industry news items as an RSS feed.
*/
public class GetNews extends Choreography {

	/**
	Create a new instance of the GetNews Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetNews(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yahoo/Finance/GetNews"));
	}

	/** 
	Set the value of the Company input for this Choreo. 

	@param String - (required, string) Ticker symbol for one or more companies to search, separated by commas (e.g. YHOO,DIS to include news about Yahoo! and Disney).
	*/
	public void setCompany(String value) {
		this.inputs.setInput("Company", value);
	}


	/** 
	Set the value of the NewsType input for this Choreo. 

	@param String - (required, string) Enter the type of news items you want to see in the RSS feed: headline or industry.
	*/
	public void setNewsType(String value) {
		this.inputs.setInput("NewsType", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetNewsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetNewsResultSet(result);
	}
	
}
