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
SearchBySector

Looks up products by sector in the EPA Design for the Environment database
*/
public class SearchBySector extends Choreography {

	/**
	Create a new instance of the SearchBySector Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchBySector(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/EnviroFacts/DesignForEnvironment/SearchBySector"));
	}

	/** 
	Set the value of the Category input for this Choreo. 

	@param String - (conditional, string) Specify either Industrial or Consumer to retrieve a list of products that fall into either category. If a specific SectorKeyword or SectorID is given, this input is ignored.
	*/
	public void setCategory(String value) {
		this.inputs.setInput("Category", value);
	}


	/** 
	Set the value of the Operator input for this Choreo. 

	@param String - (optional, string) Default output is "CONTAINING" and does not require an operator, but users can enter "<", " >", "!=", "BEGINNING", "=" for more customized searches.
	*/
	public void setOperator(String value) {
		this.inputs.setInput("Operator", value);
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
	Set the value of the SectorID input for this Choreo. 

	@param Integer - (conditional, integer) A number representing the unique identifier for the product's sector in the EnviroFacts database.
	*/
	public void setSectorID(Integer value) {
		this.inputs.setInput("SectorID", value);
	}

	/** 
	Set the value of the SectorID input for this Choreo as a String. 

	@param String - (conditional, integer) A number representing the unique identifier for the product's sector in the EnviroFacts database.
	*/
	public void setSectorID(String value) {
		this.inputs.setInput("SectorID", value);	
	}
	/** 
	Set the value of the SectorKeyword input for this Choreo. 

	@param String - (conditional, string) A keyword in the name of the sector to search for. If a specific SectorID is given, this input is ignored.
	*/
	public void setSectorKeyword(String value) {
		this.inputs.setInput("SectorKeyword", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchBySectorResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchBySectorResultSet(result);
	}
	
}
