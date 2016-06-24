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
GetBestSellerHistory

Retrieves information about New York Times best-sellers that match a specified search criteria.
*/
public class GetBestSellerHistory extends Choreography {

	/**
	Create a new instance of the GetBestSellerHistory Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBestSellerHistory(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/BestSellers/GetBestSellerHistory"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AgeGroup input for this Choreo. 

	@param String - (optional, string) The target age group for the best seller.
	*/
	public void setAgeGroup(String value) {
		this.inputs.setInput("AgeGroup", value);
	}


	/** 
	Set the value of the Author input for this Choreo. 

	@param String - (optional, string) The author of the best seller.
	*/
	public void setAuthor(String value) {
		this.inputs.setInput("Author", value);
	}


	/** 
	Set the value of the Contributor input for this Choreo. 

	@param String - (optional, string) The author of the best seller, as well as other contributors such as the illustrator.
	*/
	public void setContributor(String value) {
		this.inputs.setInput("Contributor", value);
	}


	/** 
	Set the value of the ISBN input for this Choreo. 

	@param String - (optional, string) International Standard Book Number, 10 or 13 digits.
	*/
	public void setISBN(String value) {
		this.inputs.setInput("ISBN", value);
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
	Set the value of the Price input for this Choreo. 

	@param BigDecimal - (optional, decimal) The publisher's list price of the best seller, including decimal point.
	*/
	public void setPrice(BigDecimal value) {
		this.inputs.setInput("Price", value);
	}

	/** 
	Set the value of the Price input for this Choreo as a String. 

	@param String - (optional, decimal) The publisher's list price of the best seller, including decimal point.
	*/
	public void setPrice(String value) {
		this.inputs.setInput("Price", value);	
	}
	/** 
	Set the value of the Publisher input for this Choreo. 

	@param String - (optional, string) The standardized name of the publisher.
	*/
	public void setPublisher(String value) {
		this.inputs.setInput("Publisher", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should bein. Valid values are: json (the default), and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) The column name to sort by. Valid values are: age-group, author, contributor, isbn, price, publisher, and title.
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
	Set the value of the Title input for this Choreo. 

	@param String - (conditional, string) The title of the best seller to retrieve data for.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBestSellerHistoryResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBestSellerHistoryResultSet(result);
	}
	
}
