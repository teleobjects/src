package com.temboo.Library.NYTimes.ArticleSearch;

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
QueryArticles

Searches New York Times articles and retrieves headlines, abstracts, lead paragraphs, links to associated multimedia, and other article metadata.
*/
public class QueryArticles extends Choreography {

	/**
	Create a new instance of the QueryArticles Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public QueryArticles(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/ArticleSearch/QueryArticles"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the BeginDate input for this Choreo. 

	@param String - (optional, date) Filters the result for articles with publication dates of the date specified or later. Dates should be formatted like YYYYMMDD.
	*/
	public void setBeginDate(String value) {
		this.inputs.setInput("BeginDate", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) Filters the result for articles with publication dates of the date specified or earlier. Dates should be formatted like YYYYMMDD.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the FacetFilter input for this Choreo. 

	@param Boolean - (optional, boolean) When set to "true", facet counts will respect any applied filters such as Query, BeginDate, EndDate, etc.
	*/
	public void setFacetFilter(Boolean value) {
		this.inputs.setInput("FacetFilter", value);
	}

	/** 
	Set the value of the FacetFilter input for this Choreo as a String. 

	@param String - (optional, boolean) When set to "true", facet counts will respect any applied filters such as Query, BeginDate, EndDate, etc.
	*/
	public void setFacetFilter(String value) {
		this.inputs.setInput("FacetFilter", value);	
	}
	/** 
	Set the value of the Facets input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of facets. This indicates the sets of facet values to include in the response. Valid facets include: section_name, document_type, type_of_material, source, and day_of_week.
	*/
	public void setFacets(String value) {
		this.inputs.setInput("Facets", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of fields to return.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Filter input for this Choreo. 

	@param String - (optional, string) An advanced search option that allows you to filter by specific fields. See Choreo notes for syntax details.
	*/
	public void setFilter(String value) {
		this.inputs.setInput("Filter", value);
	}


	/** 
	Set the value of the Highlighting input for this Choreo. 

	@param Boolean - (optional, boolean) Enables highlighting in search results. When set to "true", the value of Query is highlighted in the headline and lead_paragraph fields. Defaults to "false".
	*/
	public void setHighlighting(Boolean value) {
		this.inputs.setInput("Highlighting", value);
	}

	/** 
	Set the value of the Highlighting input for this Choreo as a String. 

	@param String - (optional, boolean) Enables highlighting in search results. When set to "true", the value of Query is highlighted in the headline and lead_paragraph fields. Defaults to "false".
	*/
	public void setHighlighting(String value) {
		this.inputs.setInput("Highlighting", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) This corresponds to which set of 10 results is returned. Used to page through results. Set to 0 to return records 0-9, set to 1 to return records 10-19, etc.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) This corresponds to which set of 10 results is returned. Used to page through results. Set to 0 to return records 0-9, set to 1 to return records 10-19, etc.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) Searches the article body, headline and byline for the specified term.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the Rank input for this Choreo. 

	@param String - (optional, string) By default, search results are sorted by their relevance to the Query provided. Set to "newest" or "oldest" to sort by publication date.
	*/
	public void setRank(String value) {
		this.inputs.setInput("Rank", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryArticlesResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryArticlesResultSet(result);
	}
	
}
