package com.temboo.Library.Xively.ReadWriteData;

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
ListAllFeeds

Returns filterable data on all feeds viewable by the authenticated account.
*/
public class ListAllFeeds extends Choreography {

	/**
	Create a new instance of the ListAllFeeds Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListAllFeeds(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/ListAllFeeds"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Content input for this Choreo. 

	@param String - (optional, string) Describes whether to return full or summary results. Full - all datastream values are returned, summary - returns the environment metadata for each feed. Valid values: 'full' or 'summary'.
	*/
	public void setContent(String value) {
		this.inputs.setInput("Content", value);
	}


	/** 
	Set the value of the Distance input for this Choreo. 

	@param BigDecimal - (optional, decimal) Search radius (units like miles or kilometers defined by DistanceUnits). Ex: 5.0.
	*/
	public void setDistance(BigDecimal value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (optional, decimal) Search radius (units like miles or kilometers defined by DistanceUnits). Ex: 5.0.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the DistanceUnits input for this Choreo. 

	@param String - (optional, string) Units of distance. Valid values: "miles" or "kms" (default).
	*/
	public void setDistanceUnits(String value) {
		this.inputs.setInput("DistanceUnits", value);
	}


	/** 
	Set the value of the FeedType input for this Choreo. 

	@param String - (optional, string) The type of feed that is being returned. Valid values are "json" (the default), "xml" and "csv". No metadata is returned for the csv feed.
	*/
	public void setFeedType(String value) {
		this.inputs.setInput("FeedType", value);
	}


	/** 
	Set the value of the FullTextSearch input for this Choreo. 

	@param String - (optional, string) Returns any feeds matching this string.
	*/
	public void setFullTextSearch(String value) {
		this.inputs.setInput("FullTextSearch", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Used to find feeds located around this latitude. Ex. 51.5235375648154.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) Used to find feeds located around this latitude. Ex. 51.5235375648154.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Used to find feeds located around this longitude. Ex: -0.0807666778564453.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) Used to find feeds located around this longitude. Ex: -0.0807666778564453.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Indicates which page of results you are requesting. Starts from 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Indicates which page of results you are requesting. Starts from 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) Defines how many results to return per page (1 to 1000).
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) Defines how many results to return per page (1 to 1000).
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the ShowUser input for this Choreo. 

	@param String - (optional, string) Include user login and user level for each feed. Valid values: true, false (default).
	*/
	public void setShowUser(String value) {
		this.inputs.setInput("ShowUser", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Order of returned feeds. Valid values: "created_at", "retrieved_at" or "relevance".
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) Sets whether to search for only live feeds, only frozen feeds, or all feeds. Valid values: "live", "frozen", "all" (default).
	*/
	public void setStatus(String value) {
		this.inputs.setInput("Status", value);
	}


	/** 
	Set the value of the Tag input for this Choreo. 

	@param String - (optional, string) Returns feeds containing datastreams tagged with the search query.
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	/** 
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) Returns feeds containing datastreams with units specified by the search query. Ex: Celsius.
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (optional, string) Returns feeds created by the user specified.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListAllFeedsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListAllFeedsResultSet(result);
	}
	
}
