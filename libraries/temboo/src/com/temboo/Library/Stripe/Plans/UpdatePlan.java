package com.temboo.Library.Stripe.Plans;

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
UpdatePlan

Updates the name of an existing plan.
*/
public class UpdatePlan extends Choreography {

	/**
	Create a new instance of the UpdatePlan Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdatePlan(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Plans/UpdatePlan"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the PlanID input for this Choreo. 

	@param String - (required, string) The unique identifier of the plan you want to update
	*/
	public void setPlanID(String value) {
		this.inputs.setInput("PlanID", value);
	}


	/** 
	Set the value of the PlanName input for this Choreo. 

	@param String - (conditional, string) The new name of the plan which will be displayed in the Stripe web interface.
	*/
	public void setPlanName(String value) {
		this.inputs.setInput("PlanName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdatePlanResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdatePlanResultSet(result);
	}
	
}
