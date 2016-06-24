package com.temboo.Library.EnviroFacts.DesignForEnvironment;

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
SearchByProduct

Searches for products in the EPA Design for the Environment database.
*/
public class SearchByProduct extends Choreography {

	/**
	Create a new instance of the SearchByProduct Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchByProduct(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/EnviroFacts/DesignForEnvironment/SearchByProduct"));
	}

	/** 
	Set the value of the CompanyKeyword input for this Choreo. 

	@param String - (conditional, string) A keyword in the name of the company to search for. If a specific ProductName or ProductID is specified, this input is ignored.
	*/
	public void setCompanyKeyword(String value) {
		this.inputs.setInput("CompanyKeyword", value);
	}


	/** 
	Set the value of the Operator input for this Choreo. 

	@param String - (optional, string) Default output is "CONTAINING" and does not require an operator, but users can enter "<", " >", "!=", "BEGINNING", "=" for more customized searches.
	*/
	public void setOperator(String value) {
		this.inputs.setInput("Operator", value);
	}


	/** 
	Set the value of the ProductID input for this Choreo. 

	@param Integer - (conditional, integer) A number representing the unique identifier for a product in the EnviroFacts database.
	*/
	public void setProductID(Integer value) {
		this.inputs.setInput("ProductID", value);
	}

	/** 
	Set the value of the ProductID input for this Choreo as a String. 

	@param String - (conditional, integer) A number representing the unique identifier for a product in the EnviroFacts database.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);	
	}
	/** 
	Set the value of the ProductKeyword input for this Choreo. 

	@param String - (conditional, string) A keyword in the name of the product to search for. If a specific ProductID is specified, this input is ignored.
	*/
	public void setProductKeyword(String value) {
		this.inputs.setInput("ProductKeyword", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (conditional, string) Response can be returned in JSON or XML. Defaults to XML.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the RowEnd input for this Choreo. 

	@param Integer - (optional, integer) Number 1 or greater indicates the ending row number of the results displayed. Default is 4999 when RowStart is 0. Up to 5000 entries are returned in the output.
	*/
	public void setRowEnd(Integer value) {
		this.inputs.setInput("RowEnd", value);
	}

	/** 
	Set the value of the RowEnd input for this Choreo as a String. 

	@param String - (optional, integer) Number 1 or greater indicates the ending row number of the results displayed. Default is 4999 when RowStart is 0. Up to 5000 entries are returned in the output.
	*/
	public void setRowEnd(String value) {
		this.inputs.setInput("RowEnd", value);	
	}
	/** 
	Set the value of the RowStart input for this Choreo. 

	@param Integer - (optional, integer) Indicates the starting row number of the results displayed. Default is 0.
	*/
	public void setRowStart(Integer value) {
		this.inputs.setInput("RowStart", value);
	}

	/** 
	Set the value of the RowStart input for this Choreo as a String. 

	@param String - (optional, integer) Indicates the starting row number of the results displayed. Default is 0.
	*/
	public void setRowStart(String value) {
		this.inputs.setInput("RowStart", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchByProductResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchByProductResultSet(result);
	}
	
}
