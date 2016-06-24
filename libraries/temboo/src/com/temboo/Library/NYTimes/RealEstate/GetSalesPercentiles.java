package com.temboo.Library.NYTimes.RealEstate;

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
GetSalesPercentiles

Retrieves percentiles of real estate sales from New York Times Web Service.
*/
public class GetSalesPercentiles extends Choreography {

	/**
	Create a new instance of the GetSalesPercentiles Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetSalesPercentiles(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/RealEstate/GetSalesPercentiles"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Bedrooms input for this Choreo. 

	@param Integer - (optional, integer) Limits the results by number of bedrooms to search for. Defaults to 1.
	*/
	public void setBedrooms(Integer value) {
		this.inputs.setInput("Bedrooms", value);
	}

	/** 
	Set the value of the Bedrooms input for this Choreo as a String. 

	@param String - (optional, integer) Limits the results by number of bedrooms to search for. Defaults to 1.
	*/
	public void setBedrooms(String value) {
		this.inputs.setInput("Bedrooms", value);	
	}
	/** 
	Set the value of the DateRange input for this Choreo. 

	@param String - (required, string) Sets the quarter, month, week or day for the results (i.e. 2008-Q1, 2008-W52, 2007-07, etc)
	*/
	public void setDateRange(String value) {
		this.inputs.setInput("DateRange", value);
	}


	/** 
	Set the value of the GeoExtentLevel input for this Choreo. 

	@param String - (required, string) The geographical unit for the results (i.e. borough, neighborhood, or zip)
	*/
	public void setGeoExtentLevel(String value) {
		this.inputs.setInput("GeoExtentLevel", value);
	}


	/** 
	Set the value of the GeoExtentValue input for this Choreo. 

	@param String - (required, string) Limits the search to a specific area.  For example, if GeoExtendLevel is borough, the value for GeoExtendValue could be Brooklyn.
	*/
	public void setGeoExtentValue(String value) {
		this.inputs.setInput("GeoExtentValue", value);
	}


	/** 
	Set the value of the GeoSummaryLevel input for this Choreo. 

	@param String - (required, string) The geographic unit for grouping the results (borough, neighborhood, or zip)
	*/
	public void setGeoSummaryLevel(String value) {
		this.inputs.setInput("GeoSummaryLevel", value);
	}


	/** 
	Set the value of the Percentile input for this Choreo. 

	@param Integer - (required, integer) Specify the percentile for sales prices you want to retrieve (i.e 50)
	*/
	public void setPercentile(Integer value) {
		this.inputs.setInput("Percentile", value);
	}

	/** 
	Set the value of the Percentile input for this Choreo as a String. 

	@param String - (required, integer) Specify the percentile for sales prices you want to retrieve (i.e 50)
	*/
	public void setPercentile(String value) {
		this.inputs.setInput("Percentile", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetSalesPercentilesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetSalesPercentilesResultSet(result);
	}
	
}
