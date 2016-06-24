package com.temboo.Library.Google.Gmailv2.Messages;

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
	A ResultSet with methods tailored to the values returned by the GetNextMessage Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetNextMessageResultSet extends ResultSet {
		
	public GetNextMessageResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Body" output from this Choreo execution

	@return String - (string) The message body.
	*/
	public String getBody() {
		return this.getResultString("Body");
	}
	/** 
	Retrieve the value for the "From" output from this Choreo execution

	@return String - (string) The sender address.
	*/
	public String getFrom() {
		return this.getResultString("From");
	}
	/** 
	Retrieve the value for the "MessageID" output from this Choreo execution

	@return String - (string) The ID of the message.
	*/
	public String getMessageID() {
		return this.getResultString("MessageID");
	}
	/** 
	Retrieve the value for the "NewAccessToken" output from this Choreo execution

	@return String - (string) Contains a new AccessToken when the RefreshToken is provided.
	*/
	public String getNewAccessToken() {
		return this.getResultString("NewAccessToken");
	}
	/** 
	Retrieve the value for the "ResponseStatusCode" output from this Choreo execution

	@return String - (integer) The response code returned from Google. A 200 is expected for a successful request. A 404 indicates that the stored history id has become invalid or expired. See Choreo notes for more details.
	*/
	public String getResponseStatusCode() {
		return this.getResultString("ResponseStatusCode");
	}
	/** 
	Retrieve the value for the "Snippet" output from this Choreo execution

	@return String - (string) The email body snippet.
	*/
	public String getSnippet() {
		return this.getResultString("Snippet");
	}
	/** 
	Retrieve the value for the "Subject" output from this Choreo execution

	@return String - (string) The message subject.
	*/
	public String getSubject() {
		return this.getResultString("Subject");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from Google.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}