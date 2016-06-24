package com.temboo.Library.LittleSis.Entity;

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
GetEntitiesWithRelationship

Retrieves a list of Entities (person or organization) to which a known relationship exists in LittleSis for any Entity.
*/
public class GetEntitiesWithRelationship extends Choreography {

	/**
	Create a new instance of the GetEntitiesWithRelationship Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetEntitiesWithRelationship(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Entity/GetEntitiesWithRelationship"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CategoryIDs input for this Choreo. 

	@param String - (optional, string) Comma delimited list of category IDs of the categories to which the resulting Entities should belong.
	*/
	public void setCategoryIDs(String value) {
		this.inputs.setInput("CategoryIDs", value);
	}


	/** 
	Set the value of the Current input for this Choreo. 

	@param Integer - (optional, integer) Set to 1 to limit the relationships returned to only past relationships. Set to 0 to limit relationships returned to only current relationships. Defaults to all.
	*/
	public void setCurrent(Integer value) {
		this.inputs.setInput("Current", value);
	}

	/** 
	Set the value of the Current input for this Choreo as a String. 

	@param String - (optional, integer) Set to 1 to limit the relationships returned to only past relationships. Set to 0 to limit relationships returned to only current relationships. Defaults to all.
	*/
	public void setCurrent(String value) {
		this.inputs.setInput("Current", value);	
	}
	/** 
	Set the value of the EntityID input for this Choreo. 

	@param Integer - (required, integer) The ID of the person or organization fro which a record is to be returned.
	*/
	public void setEntityID(Integer value) {
		this.inputs.setInput("EntityID", value);
	}

	/** 
	Set the value of the EntityID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the person or organization fro which a record is to be returned.
	*/
	public void setEntityID(String value) {
		this.inputs.setInput("EntityID", value);	
	}
	/** 
	Set the value of the Number input for this Choreo. 

	@param Integer - (optional, integer) Specifies what number of results to show. Used in conjunction with Page parameter, a Number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setNumber(Integer value) {
		this.inputs.setInput("Number", value);
	}

	/** 
	Set the value of the Number input for this Choreo as a String. 

	@param String - (optional, integer) Specifies what number of results to show. Used in conjunction with Page parameter, a Number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setNumber(String value) {
		this.inputs.setInput("Number", value);	
	}
	/** 
	Set the value of the Order input for this Choreo. 

	@param Integer - (optional, integer) Specifies what order the given entity must have in the relationship.
	*/
	public void setOrder(Integer value) {
		this.inputs.setInput("Order", value);
	}

	/** 
	Set the value of the Order input for this Choreo as a String. 

	@param String - (optional, integer) Specifies what order the given entity must have in the relationship.
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);	
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
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) Defaults to sorting by entity, which returns a list of relationships grouped by related entity. Specify another sort order for the results. Acceptable inputs: category or relationship.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetEntitiesWithRelationshipResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetEntitiesWithRelationshipResultSet(result);
	}
	
}
