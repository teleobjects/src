package com.temboo.Library.Delicious;

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
RenameTag

Renames a specified tag.
*/
public class RenameTag extends Choreography {

	/**
	Create a new instance of the RenameTag Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RenameTag(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Delicious/RenameTag"));
	}

	/** 
	Set the value of the NewTag input for this Choreo. 

	@param String - (required, string) The new tag name.
	*/
	public void setNewTag(String value) {
		this.inputs.setInput("NewTag", value);
	}


	/** 
	Set the value of the OldTag input for this Choreo. 

	@param String - (required, string) The existing tag to rename.
	*/
	public void setOldTag(String value) {
		this.inputs.setInput("OldTag", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The password that corresponds to the specified Delicious account username.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A valid Delicious account username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RenameTagResultSet run() {
		JSONObject result = super.runWithResults();
		return new RenameTagResultSet(result);
	}
	
}
