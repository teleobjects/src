package com.temboo.Library.Google.ComputeEngine.Disks;

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
CreateSnapshot

Creates a snapshot of a specified disk.
*/
public class CreateSnapshot extends Choreography {

	/**
	Create a new instance of the CreateSnapshot Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateSnapshot(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Disks/CreateSnapshot"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description for the snapshot resource.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Disk input for this Choreo. 

	@param String - (required, string) The name of the persistent disk resource to use to create this snapshot.
	*/
	public void setDisk(String value) {
		this.inputs.setInput("Disk", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the snapshot resource being created.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Project input for this Choreo. 

	@param String - (required, string) The ID of a Google Compute project.
	*/
	public void setProject(String value) {
		this.inputs.setInput("Project", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the SourceDiskID input for this Choreo. 

	@param String - (required, string) The ID of the disk being used to create the snapshot.
	*/
	public void setSourceDiskID(String value) {
		this.inputs.setInput("SourceDiskID", value);
	}


	/** 
	Set the value of the StorageBytes input for this Choreo. 

	@param Integer - (optional, integer) The size of the storage used by the snapshot.
	*/
	public void setStorageBytes(Integer value) {
		this.inputs.setInput("StorageBytes", value);
	}

	/** 
	Set the value of the StorageBytes input for this Choreo as a String. 

	@param String - (optional, integer) The size of the storage used by the snapshot.
	*/
	public void setStorageBytes(String value) {
		this.inputs.setInput("StorageBytes", value);	
	}
	/** 
	Set the value of the StorageBytesStatus input for this Choreo. 

	@param String - (optional, string) Indicates whether storageBytes is in a stable state, or it is being adjusted as a result of shared storage reallocation. Valid values: are "UPDATING" AND "UP_TO_DATE".
	*/
	public void setStorageBytesStatus(String value) {
		this.inputs.setInput("StorageBytesStatus", value);
	}


	/** 
	Set the value of the Zone input for this Choreo. 

	@param String - (required, string) The name of the zone associated with this request.
	*/
	public void setZone(String value) {
		this.inputs.setInput("Zone", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateSnapshotResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateSnapshotResultSet(result);
	}
	
}
