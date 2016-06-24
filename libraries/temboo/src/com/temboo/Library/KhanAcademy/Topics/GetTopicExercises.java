package com.temboo.Library.KhanAcademy.Topics;

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
GetTopicExercises

Retrieves a list of all exercises for a given topic.
*/
public class GetTopicExercises extends Choreography {

	/**
	Create a new instance of the GetTopicExercises Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTopicExercises(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/KhanAcademy/Topics/GetTopicExercises"));
	}

	/** 
	Set the value of the TopicID input for this Choreo. 

	@param String - (required, string) The ID of the topic.
	*/
	public void setTopicID(String value) {
		this.inputs.setInput("TopicID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTopicExercisesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTopicExercisesResultSet(result);
	}
	
}
