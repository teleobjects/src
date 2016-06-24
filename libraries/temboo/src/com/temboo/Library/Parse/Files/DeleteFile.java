package com.temboo.Library.Parse.Files;

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
DeleteFile

Deletes a file stored on Parse.
*/
public class DeleteFile extends Choreography {

	/**
	Create a new instance of the DeleteFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Files/DeleteFile"));
	}

	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the file to delete. Note that this is the name generated and returned by Parse after uploading the file.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the MasterKey input for this Choreo. 

	@param String - (required, string) The Master Key provided by Parse.
	*/
	public void setMasterKey(String value) {
		this.inputs.setInput("MasterKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteFileResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteFileResultSet(result);
	}
	
}
