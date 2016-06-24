package com.temboo.Library.LittleSis.List;

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
GetList

Retrieves information about a List in LittleSis according to its ID.
*/
public class GetList extends Choreography {

	/**
	Create a new instance of the GetList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/List/GetList"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Entities input for this Choreo. 

	@param String - (optional, string) Indicate "entities" to retrieve records of the entities that belong to the list. Otherwise, only a basic record about the list will be returned.
	*/
	public void setEntities(String value) {
		this.inputs.setInput("Entities", value);
	}


	/** 
	Set the value of the ListID input for this Choreo. 

	@param Integer - (required, integer) The ID of the list record to be returned.
	*/
	public void setListID(Integer value) {
		this.inputs.setInput("ListID", value);
	}

	/** 
	Set the value of the ListID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the list record to be returned.
	*/
	public void setListID(String value) {
		this.inputs.setInput("ListID", value);	
	}
	/** 
	Set the value of the Number input for this Choreo. 

	@param Integer - (optional, integer) Specifies what number of results to show. Used in conjunction with Page parameter, a Nnumber of 20 and a Page of 6 will show results 100-120.
	*/
	public void setNumber(Integer value) {
		this.inputs.setInput("Number", value);
	}

	/** 
	Set the value of the Number input for this Choreo as a String. 

	@param String - (optional, integer) Specifies what number of results to show. Used in conjunction with Page parameter, a Nnumber of 20 and a Page of 6 will show results 100-120.
	*/
	public void setNumber(String value) {
		this.inputs.setInput("Number", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Specifies what page of results to show. Used in conjunction with Number parameter. A number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Specifies what page of results to show. Used in conjunction with Number parameter. A number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Format of the response returned by LittleSis.org. Acceptable inputs: xml or json. Defaults to xml
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the TypeID input for this Choreo. 

	@param Integer - (optional, integer) When the Entities parameter is activated, you can specify type IDs limiting the entities returned to those having the specified types (as a comma-delimited list).
	*/
	public void setTypeID(Integer value) {
		this.inputs.setInput("TypeID", value);
	}

	/** 
	Set the value of the TypeID input for this Choreo as a String. 

	@param String - (optional, integer) When the Entities parameter is activated, you can specify type IDs limiting the entities returned to those having the specified types (as a comma-delimited list).
	*/
	public void setTypeID(String value) {
		this.inputs.setInput("TypeID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetListResultSet(result);
	}
	
}
