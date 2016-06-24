package com.temboo.Library.Amazon.S3;

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
	A ResultSet with methods tailored to the values returned by the GetBase64EncodedObject Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetBase64EncodedObjectResultSet extends ResultSet {
		
	public GetBase64EncodedObjectResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "DeleteMarker" output from this Choreo execution

	@return String - (boolean) Returns true if the object retrieved was a Delete Marker otherwise no value.
	*/
	public String getDeleteMarker() {
		return this.getResultString("DeleteMarker");
	}
	/** 
	Retrieve the value for the "ETag" output from this Choreo execution

	@return String - (string) The ETag string for the file.
	*/
	public String getETag() {
		return this.getResultString("ETag");
	}
	/** 
	Retrieve the value for the "Expiration" output from this Choreo execution

	@return String - (string) Appears if the object expiration is configured. It includes expiry-date and URL-encoded rule-id key value pairs providing object expiration information.
	*/
	public String getExpiration() {
		return this.getResultString("Expiration");
	}
	/** 
	Retrieve the value for the "Restore" output from this Choreo execution

	@return String - (string) Provides information about the object restoration operation and expiration time of the restored object copy.
	*/
	public String getRestore() {
		return this.getResultString("Restore");
	}
	/** 
	Retrieve the value for the "ServerSideEncryption" output from this Choreo execution

	@return String - (string) If the object is stored using server-side encryption, response includes this header with value of the encryption algorithm used. Valid Values: AES256.
	*/
	public String getServerSideEncryption() {
		return this.getResultString("ServerSideEncryption");
	}
	/** 
	Retrieve the value for the "VersionID" output from this Choreo execution

	@return String - (string) Returns the version ID of the retrieved object if it has a unique version ID.
	*/
	public String getVersionID() {
		return this.getResultString("VersionID");
	}
	/** 
	Retrieve the value for the "WebsiteRedirectLocation" output from this Choreo execution

	@return String - (string) For a bucket configured as a website, this metadata can be set so the website will evaluate the request for the object as a 301 redirect to another object in the same bucket or an external URL.
	*/
	public String getWebsiteRedirectLocation() {
		return this.getResultString("WebsiteRedirectLocation");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (string) The base64-encoded contents of the file you are retrieving.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}