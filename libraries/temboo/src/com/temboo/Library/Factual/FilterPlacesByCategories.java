package com.temboo.Library.Factual;

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
FilterPlacesByCategories

Filter queries by category.
*/
public class FilterPlacesByCategories extends Choreography {

	/**
	Create a new instance of the FilterPlacesByCategories Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FilterPlacesByCategories(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Factual/FilterPlacesByCategories"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The API Key provided by Factual (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (optional, string) The API Secret provided by Factual (AKA the OAuth Consumer Secret).
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Category input for this Choreo. 

	@param String - (required, string) Enter a Factual category to narrow the search results.
	*/
	public void setCategory(String value) {
		this.inputs.setInput("Category", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (required, string) Enter a city to narrow results to.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) A search string (i.e. Starbucks)
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FilterPlacesByCategoriesResultSet run() {
		JSONObject result = super.runWithResults();
		return new FilterPlacesByCategoriesResultSet(result);
	}
	
}
