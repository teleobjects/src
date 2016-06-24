package com.temboo.Library.Dropbox.FilesAndMetadata;

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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the ChunkedUpload Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class ChunkedUploadResultSet extends ResultSet {
		
	public ChunkedUploadResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Expires" output from this Choreo execution

	@return String - (string) The expiration time of the upload.
	*/
	public String getExpires() {
		return this.getResultString("Expires");
	}
	/** 
	Retrieve the value for the "NextOffset" output from this Choreo execution

	@return String - (string) The current byte offset that the server will expect. This value can be passed to the Offset input on subsequent requests when uploading chunks repeatedly.
	*/
	public String getNextOffset() {
		return this.getResultString("NextOffset");
	}
	/** 
	Retrieve the value for the "UploadSessionID" output from this Choreo execution

	@return String - (string) The upload ID returned after uploading an initial file chunk. This can be passed to the UploadID input for uploading subsequent chunks, and finally to the CommitChunkedUpload Choreo.
	*/
	public String getUploadSessionID() {
		return this.getResultString("UploadSessionID");
	}
}