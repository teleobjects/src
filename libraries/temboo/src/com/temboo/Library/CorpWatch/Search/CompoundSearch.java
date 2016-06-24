package com.temboo.Library.CorpWatch.Search;

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
CompoundSearch

Returns a list of companies according to several search parameters such as industry, location, date range, company name, etc.
*/
public class CompoundSearch extends Choreography {

	/**
	Create a new instance of the CompoundSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CompoundSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CorpWatch/Search/CompoundSearch"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The APIKey from CorpWatch if you have one.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (conditional, string) Specific fragment of an address to be searched, such as "empire" or "Main Street."
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (optional, string) Two-letter country code (e.g. VI for Virgin Islands).
	*/
	public void setCountryCode(String value) {
		this.inputs.setInput("CountryCode", value);
	}


	/** 
	Set the value of the Index input for this Choreo. 

	@param Integer - (optional, integer) Set the index number of the first result to be returned. The index of the first result is 0.
	*/
	public void setIndex(Integer value) {
		this.inputs.setInput("Index", value);
	}

	/** 
	Set the value of the Index input for this Choreo as a String. 

	@param String - (optional, integer) Set the index number of the first result to be returned. The index of the first result is 0.
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);	
	}
	/** 
	Set the value of the IndustryCode input for this Choreo. 

	@param Integer - (conditional, integer) Standard Industrial Classification (SIC) code.
	*/
	public void setIndustryCode(Integer value) {
		this.inputs.setInput("IndustryCode", value);
	}

	/** 
	Set the value of the IndustryCode input for this Choreo as a String. 

	@param String - (conditional, integer) Standard Industrial Classification (SIC) code.
	*/
	public void setIndustryCode(String value) {
		this.inputs.setInput("IndustryCode", value);	
	}
	/** 
	Set the value of the IndustrySector input for this Choreo. 

	@param Integer - (conditional, integer) Standard Industrial Classification (SIC) sector code.
	*/
	public void setIndustrySector(Integer value) {
		this.inputs.setInput("IndustrySector", value);
	}

	/** 
	Set the value of the IndustrySector input for this Choreo as a String. 

	@param String - (conditional, integer) Standard Industrial Classification (SIC) sector code.
	*/
	public void setIndustrySector(String value) {
		this.inputs.setInput("IndustrySector", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to be returned. Defaults to 100. Maximum is 5000.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to be returned. Defaults to 100. Maximum is 5000.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Match input for this Choreo. 

	@param Integer - (optional, integer) By default search terms match against complete words. Use 1 to return cases where the search string matches anywhere in the Name or Address field. Performance is significantly affected when enabled.
	*/
	public void setMatch(Integer value) {
		this.inputs.setInput("Match", value);
	}

	/** 
	Set the value of the Match input for this Choreo as a String. 

	@param String - (optional, integer) By default search terms match against complete words. Use 1 to return cases where the search string matches anywhere in the Name or Address field. Performance is significantly affected when enabled.
	*/
	public void setMatch(String value) {
		this.inputs.setInput("Match", value);	
	}
	/** 
	Set the value of the MaxYear input for this Choreo. 

	@param Integer - (optional, integer) Indicate desired year of the most recent appearance in SEC filing data (e.g. indicating 2007 will search for companies that ceased filing in 2007).
	*/
	public void setMaxYear(Integer value) {
		this.inputs.setInput("MaxYear", value);
	}

	/** 
	Set the value of the MaxYear input for this Choreo as a String. 

	@param String - (optional, integer) Indicate desired year of the most recent appearance in SEC filing data (e.g. indicating 2007 will search for companies that ceased filing in 2007).
	*/
	public void setMaxYear(String value) {
		this.inputs.setInput("MaxYear", value);	
	}
	/** 
	Set the value of the MinYear input for this Choreo. 

	@param Integer - (optional, integer) Indicate desired year of the most recent appearance in SEC filing data (e.g. indicating 2007 will search for companies that ceased filing in 2007).
	*/
	public void setMinYear(Integer value) {
		this.inputs.setInput("MinYear", value);
	}

	/** 
	Set the value of the MinYear input for this Choreo as a String. 

	@param String - (optional, integer) Indicate desired year of the most recent appearance in SEC filing data (e.g. indicating 2007 will search for companies that ceased filing in 2007).
	*/
	public void setMinYear(String value) {
		this.inputs.setInput("MinYear", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (conditional, string) Company name to search. Words in the search query must match to full words in the name. See documentation for more details.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the NumChildren input for this Choreo. 

	@param Integer - (optional, integer) Limit results to those with a specified number of listed subsidiaries, or "children." (Only immediate relationships are counted.
	*/
	public void setNumChildren(Integer value) {
		this.inputs.setInput("NumChildren", value);
	}

	/** 
	Set the value of the NumChildren input for this Choreo as a String. 

	@param String - (optional, integer) Limit results to those with a specified number of listed subsidiaries, or "children." (Only immediate relationships are counted.
	*/
	public void setNumChildren(String value) {
		this.inputs.setInput("NumChildren", value);	
	}
	/** 
	Set the value of the NumParents input for this Choreo. 

	@param Integer - (optional, integer) Limit results to those with a specified number of listed parent companies (only immediate relationships are counted).
	*/
	public void setNumParents(Integer value) {
		this.inputs.setInput("NumParents", value);
	}

	/** 
	Set the value of the NumParents input for this Choreo as a String. 

	@param String - (optional, integer) Limit results to those with a specified number of listed parent companies (only immediate relationships are counted).
	*/
	public void setNumParents(String value) {
		this.inputs.setInput("NumParents", value);	
	}
	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Specify json or xml for the type of response to be returned. Defaults to xml.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the SourceType input for this Choreo. 

	@param String - (optional, string) Indicate "filers" to restrict results to those of companies that appeared as a filer on SEC documents, or "relationships" for companies that only appear as subsidiaries on filings.
	*/
	public void setSourceType(String value) {
		this.inputs.setInput("SourceType", value);
	}


	/** 
	Set the value of the SubdivisionCode input for this Choreo. 

	@param String - (optional, string) Two-letter abbreviation for the subdivision of the area to be searched (e.g. "OR" for Oregon when CountryCode is set to "US").
	*/
	public void setSubdivisionCode(String value) {
		this.inputs.setInput("SubdivisionCode", value);
	}


	/** 
	Set the value of the TopParent input for this Choreo. 

	@param Integer - (optional, integer) Limit results by he CWID of the highest-level owning parent of a family of corprorations (or Top Parent). Most company records contain a field for top_parent_id.
	*/
	public void setTopParent(Integer value) {
		this.inputs.setInput("TopParent", value);
	}

	/** 
	Set the value of the TopParent input for this Choreo as a String. 

	@param String - (optional, integer) Limit results by he CWID of the highest-level owning parent of a family of corprorations (or Top Parent). Most company records contain a field for top_parent_id.
	*/
	public void setTopParent(String value) {
		this.inputs.setInput("TopParent", value);	
	}
	/** 
	Set the value of the Year input for this Choreo. 

	@param Integer - (optional, integer) If a year is specified, only records for that year will be returned and the data in the company objects returned will be set appropriately for the request year. Defaults to most recent.
	*/
	public void setYear(Integer value) {
		this.inputs.setInput("Year", value);
	}

	/** 
	Set the value of the Year input for this Choreo as a String. 

	@param String - (optional, integer) If a year is specified, only records for that year will be returned and the data in the company objects returned will be set appropriately for the request year. Defaults to most recent.
	*/
	public void setYear(String value) {
		this.inputs.setInput("Year", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CompoundSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new CompoundSearchResultSet(result);
	}
	
}
