package com.temboo.Library.Socrata.SODA;

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
Query

Performs queries against data on the Socrata Platform.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Socrata/SODA/Query"));
	}

	/** 
	Set the value of the AppToken input for this Choreo. 

	@param String - (optional, string) The App Token provided by Socrata.
	*/
	public void setAppToken(String value) {
		this.inputs.setInput("AppToken", value);
	}


	/** 
	Set the value of the Domain input for this Choreo. 

	@param String - (required, string) The domain used in the request (i.e. soda.demo.socrata.com).
	*/
	public void setDomain(String value) {
		this.inputs.setInput("Domain", value);
	}


	/** 
	Set the value of the Group input for this Choreo. 

	@param String - (optional, string) Groups results based on the column name provided.
	*/
	public void setGroup(String value) {
		this.inputs.setInput("Group", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param String - (optional, string) The maximum number of results to return. Used in combination with the Offset input for pagination. Defaults to 100.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param String - (optional, string) Indicates the starting point of the result set. Used in combination with the Limit input for pagination. Defaults to 0.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);
	}


	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) Determines how results will be sorted. This input can take a column name, and can sort in either ascending or descending order (i.e. datetime asc).
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
	}


	/** 
	Set the value of the Resource input for this Choreo. 

	@param String - (required, string) The unique identifier for a dataset to retrieve (i.e 4tka-6guv or earthquakes).
	*/
	public void setResource(String value) {
		this.inputs.setInput("Resource", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default), xml, csv, and rdf.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Search input for this Choreo. 

	@param String - (optional, string) A search clause. This wll do a full text search for a value.
	*/
	public void setSearch(String value) {
		this.inputs.setInput("Search", value);
	}


	/** 
	Set the value of the Select input for this Choreo. 

	@param String - (optional, string) Indicates which columns to return. If not specified, all columns will be returned.
	*/
	public void setSelect(String value) {
		this.inputs.setInput("Select", value);
	}


	/** 
	Set the value of the Where input for this Choreo. 

	@param String - (optional, string) Filters the results using a WHERE clause.
	*/
	public void setWhere(String value) {
		this.inputs.setInput("Where", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
