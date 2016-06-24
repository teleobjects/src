package com.temboo.Library.NYTimes.BestSellers;

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
GetBestSellerList

Retrieves data from a New York Times best-seller list for a specified date.
*/
public class GetBestSellerList extends Choreography {

	/**
	Create a new instance of the GetBestSellerList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBestSellerList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/BestSellers/GetBestSellerList"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (required, date) The best-seller list publication date in YYYY-MM-DD format.
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the ListName input for this Choreo. 

	@param String - (required, string) The Times best-seller list to retrieve (i.e. e-book-fiction or hardcover-fiction).
	*/
	public void setListName(String value) {
		this.inputs.setInput("ListName", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The first 20 results are shown by default. To page through the results, set Offset to the appropriate value.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The first 20 results are shown by default. To page through the results, set Offset to the appropriate value.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) The column name to sort by. Valid values are: bestsellers-date, date, isbn, list, list-name, published-date, rank, rank-last-week, and weeks-on-list.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) The sort order. Valid values are: ASC and DESC.
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBestSellerListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBestSellerListResultSet(result);
	}
	
}
