package com.temboo.Library.NPR.StoryFinder;

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
GetListByID

Retrieves a list of NPR categories from a specified list type ID.
*/
public class GetListByID extends Choreography {

	/**
	Create a new instance of the GetListByID Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetListByID(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NPR/StoryFinder/GetListByID"));
	}

	/** 
	Set the value of the ChildrenOf input for this Choreo. 

	@param Integer - (optional, integer) Returns only items which are assigned to the given topic ID. For example, if Id=3006 and ChildrenOf=1008 only recent series which are assigned to "Arts & Life" are returned.
	*/
	public void setChildrenOf(Integer value) {
		this.inputs.setInput("ChildrenOf", value);
	}

	/** 
	Set the value of the ChildrenOf input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items which are assigned to the given topic ID. For example, if Id=3006 and ChildrenOf=1008 only recent series which are assigned to "Arts & Life" are returned.
	*/
	public void setChildrenOf(String value) {
		this.inputs.setInput("ChildrenOf", value);	
	}
	/** 
	Set the value of the HideChildren input for this Choreo. 

	@param Boolean - (optional, boolean) If set to "1", returns only topics which are not subtopics of another topic.
	*/
	public void setHideChildren(Boolean value) {
		this.inputs.setInput("HideChildren", value);
	}

	/** 
	Set the value of the HideChildren input for this Choreo as a String. 

	@param String - (optional, boolean) If set to "1", returns only topics which are not subtopics of another topic.
	*/
	public void setHideChildren(String value) {
		this.inputs.setInput("HideChildren", value);	
	}
	/** 
	Set the value of the Id input for this Choreo. 

	@param Integer - (required, integer) The id of the list type you want to retrieve. For example, the list type id for Music Genres is 3218).
	*/
	public void setId(Integer value) {
		this.inputs.setInput("Id", value);
	}

	/** 
	Set the value of the Id input for this Choreo as a String. 

	@param String - (required, integer) The id of the list type you want to retrieve. For example, the list type id for Music Genres is 3218).
	*/
	public void setId(String value) {
		this.inputs.setInput("Id", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are xml (the default), and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the StoryCountAll input for this Choreo. 

	@param Integer - (optional, integer) Returns only items with at least this number of associated stories.
	*/
	public void setStoryCountAll(Integer value) {
		this.inputs.setInput("StoryCountAll", value);
	}

	/** 
	Set the value of the StoryCountAll input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items with at least this number of associated stories.
	*/
	public void setStoryCountAll(String value) {
		this.inputs.setInput("StoryCountAll", value);	
	}
	/** 
	Set the value of the StoryCountMonth input for this Choreo. 

	@param Integer - (optional, integer) Returns only items with at least this number of associated stories published in the last month.
	*/
	public void setStoryCountMonth(Integer value) {
		this.inputs.setInput("StoryCountMonth", value);
	}

	/** 
	Set the value of the StoryCountMonth input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items with at least this number of associated stories published in the last month.
	*/
	public void setStoryCountMonth(String value) {
		this.inputs.setInput("StoryCountMonth", value);	
	}
	/** 
	Set the value of the StoryCountToday input for this Choreo. 

	@param Integer - (optional, integer) Returns only items with at least this number of associated stories published today.
	*/
	public void setStoryCountToday(Integer value) {
		this.inputs.setInput("StoryCountToday", value);
	}

	/** 
	Set the value of the StoryCountToday input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items with at least this number of associated stories published today.
	*/
	public void setStoryCountToday(String value) {
		this.inputs.setInput("StoryCountToday", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetListByIDResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetListByIDResultSet(result);
	}
	
}
