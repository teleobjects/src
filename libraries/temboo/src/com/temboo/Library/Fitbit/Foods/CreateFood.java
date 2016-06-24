package com.temboo.Library.Fitbit.Foods;

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
CreateFood

Create new private food for a user.
*/
public class CreateFood extends Choreography {

	/**
	Create a new instance of the CreateFood Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateFood(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Foods/CreateFood"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Calories input for this Choreo. 

	@param Integer - (required, integer) The number of calories per serving size.
	*/
	public void setCalories(Integer value) {
		this.inputs.setInput("Calories", value);
	}

	/** 
	Set the value of the Calories input for this Choreo as a String. 

	@param String - (required, integer) The number of calories per serving size.
	*/
	public void setCalories(String value) {
		this.inputs.setInput("Calories", value);	
	}
	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description for the food entry.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the FormType input for this Choreo. 

	@param String - (optional, string) Form type; (LIQUID or DRY).
	*/
	public void setFormType(String value) {
		this.inputs.setInput("FormType", value);
	}


	/** 
	Set the value of the MeasurementUnitID input for this Choreo. 

	@param Integer - (required, integer) The default measurement unit.
	*/
	public void setMeasurementUnitID(Integer value) {
		this.inputs.setInput("MeasurementUnitID", value);
	}

	/** 
	Set the value of the MeasurementUnitID input for this Choreo as a String. 

	@param String - (required, integer) The default measurement unit.
	*/
	public void setMeasurementUnitID(String value) {
		this.inputs.setInput("MeasurementUnitID", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the food.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ServingSize input for this Choreo. 

	@param Integer - (required, integer) The default serving size.
	*/
	public void setServingSize(Integer value) {
		this.inputs.setInput("ServingSize", value);
	}

	/** 
	Set the value of the ServingSize input for this Choreo as a String. 

	@param String - (required, integer) The default serving size.
	*/
	public void setServingSize(String value) {
		this.inputs.setInput("ServingSize", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateFoodResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateFoodResultSet(result);
	}
	
}
