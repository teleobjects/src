package com.temboo.Library.FilesAnywhere;

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
ListItems

Lists files within a specified directory in your FilesAnywhere account.
*/
public class ListItems extends Choreography {

	/**
	Create a new instance of the ListItems Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListItems(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FilesAnywhere/ListItems"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (conditional, string) The API Key provided by FilesAnywhere. Required unless supplying a valid Token input.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the OrgID input for this Choreo. 

	@param Integer - (conditional, integer) Defaults to 0 for a FilesAnywhere Web account.  Use 50 for a FilesAnywhere WebAdvanced account.
	*/
	public void setOrgID(Integer value) {
		this.inputs.setInput("OrgID", value);
	}

	/** 
	Set the value of the OrgID input for this Choreo as a String. 

	@param String - (conditional, integer) Defaults to 0 for a FilesAnywhere Web account.  Use 50 for a FilesAnywhere WebAdvanced account.
	*/
	public void setOrgID(String value) {
		this.inputs.setInput("OrgID", value);	
	}
	/** 
	Set the value of the PageNum input for this Choreo. 

	@param Integer - (optional, integer) The page number to return. Can be used to page through large result sets. Defaults to 1.
	*/
	public void setPageNum(Integer value) {
		this.inputs.setInput("PageNum", value);
	}

	/** 
	Set the value of the PageNum input for this Choreo as a String. 

	@param String - (optional, integer) The page number to return. Can be used to page through large result sets. Defaults to 1.
	*/
	public void setPageNum(String value) {
		this.inputs.setInput("PageNum", value);	
	}
	/** 
	Set the value of the PageSize input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return per page. Defaults to 10.
	*/
	public void setPageSize(Integer value) {
		this.inputs.setInput("PageSize", value);
	}

	/** 
	Set the value of the PageSize input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return per page. Defaults to 10.
	*/
	public void setPageSize(String value) {
		this.inputs.setInput("PageSize", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (conditional, password) Your FilesAnywhere password. Required unless supplying a valid Token input.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path to the folder that you want to list items for (i.e. \JOHNSMITH\MyFolder).
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (conditional, string) If provided, the Choreo will use the token to authenticate. If the token is expired or not provided, the Choreo will relogin and retrieve a new token when APIKey, Username, and Password are supplied.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (conditional, string) Your FilesAnywhere username. Required unless supplying a valid Token input.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListItemsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListItemsResultSet(result);
	}
	
}
