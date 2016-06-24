package com.temboo.Library.Box.Search;

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

Searches a user's Box account for items that match a specified keyword.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Search/Query"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved during the OAuth2 process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AncestorFolderIDs input for this Choreo. 

	@param String - (optional, string) A comma-seperated list of folder IDs which are used to filter your search.
	*/
	public void setAncestorFolderIDs(String value) {
		this.inputs.setInput("AncestorFolderIDs", value);
	}


	/** 
	Set the value of the AsUser input for this Choreo. 

	@param String - (optional, string) The ID of the user. Only used for enterprise administrators to make API calls for their managed users.
	*/
	public void setAsUser(String value) {
		this.inputs.setInput("AsUser", value);
	}


	/** 
	Set the value of the ContentTypes input for this Choreo. 

	@param String - (optional, string) A comma-seperated list of content types used to filter your search.  Acceptable types are: name, description, file_content, comments, and tags.
	*/
	public void setContentTypes(String value) {
		this.inputs.setInput("ContentTypes", value);
	}


	/** 
	Set the value of the CreatedAtRange input for this Choreo. 

	@param String - (optional, date) A comma-seperated date range in ISO-8601 (2012-11-02T11:43:14-07:00) format used to filter your search.  Acceptable values are "from-date, to-date", "from-date, " and ", to-date".
	*/
	public void setCreatedAtRange(String value) {
		this.inputs.setInput("CreatedAtRange", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma-separated list of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the FileExtensions input for this Choreo. 

	@param String - (optional, string) A comma-seperated list of extension types used to filter your search (e.g., pdf, png doc).
	*/
	public void setFileExtensions(String value) {
		this.inputs.setInput("FileExtensions", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of search results to return. Defaults to 30.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of search results to return. Defaults to 30.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the MDFilters input for this Choreo. 

	@param String - (optional, string) Filters for a specific metadata template. Visit the metadata search documentation for more information (See Choreo notes for more details).
	*/
	public void setMDFilters(String value) {
		this.inputs.setInput("MDFilters", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The search result at which to start the response. Defaults to 0.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The search result at which to start the response. Defaults to 0.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the OwnerUserIDs input for this Choreo. 

	@param String - (optional, string) A comma-seperated list of owner IDs which are used to filter your search.
	*/
	public void setOwnerUserIDs(String value) {
		this.inputs.setInput("OwnerUserIDs", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) The string to search for; can be matched against item names, descriptions, text content of a file, and other fields of the different item types.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the Scope input for this Choreo. 

	@param String - (optional, string) The scope for which you want to limit your search to. Can be user_content for a search limited to only the current user or enterprise_content for the entire enterprise.
	*/
	public void setScope(String value) {
		this.inputs.setInput("Scope", value);
	}


	/** 
	Set the value of the SizeRange input for this Choreo. 

	@param String - (optional, string) Filter by a file size range. Specify the file size range in bytes separated by a comma (e.g., 50, 100).
	*/
	public void setSizeRange(String value) {
		this.inputs.setInput("SizeRange", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) The type you want to return in your search. Can be file, folder, or web_link.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the UpdatedAtRange input for this Choreo. 

	@param String - (optional, date) A comma-seperated date range in ISO-8601 (2012-11-02T11:43:14-07:00) format used to filter your search.  Acceptable values are "from-date, to-date", "from-date, " and ", to-date".
	*/
	public void setUpdatedAtRange(String value) {
		this.inputs.setInput("UpdatedAtRange", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) The path to a vault file that you want to upload. Required unless using the FileContents input.
	*/

	
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
