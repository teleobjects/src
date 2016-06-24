package com.temboo.Library.Xively.Products;

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
UpdateProduct

Updates an existing product batch.
*/
public class UpdateProduct extends Choreography {

	/**
	Create a new instance of the UpdateProduct Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateProduct(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Products/UpdateProduct"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CustomProduct input for this Choreo. 

	@param String - (optional, json) Optional custom configuration for creating your product in JSON. If you use this field the other optional parameters will be ignored. See Choreo description and Xively documentation for details.
	*/
	public void setCustomProduct(String value) {
		this.inputs.setInput("CustomProduct", value);
	}


	/** 
	Set the value of the Datastreams input for this Choreo. 

	@param String - (optional, json) Default device datastream JSON array. Every newly created device in this product will have this default datastream. Ex: [{"id":"channel1"},{"id":"demo"}].
	*/
	public void setDatastreams(String value) {
		this.inputs.setInput("Datastreams", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) Description of the product.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) Name of the product.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Private input for this Choreo. 

	@param String - (optional, string) Default device feed privacy settings. Valid values: "true", "false" (default). Note - leaving this blank will automatically change a private device feed to a public device feed.
	*/
	public void setPrivate(String value) {
		this.inputs.setInput("Private", value);
	}


	/** 
	Set the value of the ProductID input for this Choreo. 

	@param String - (required, string) The ID of the product you are trying to update.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateProductResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateProductResultSet(result);
	}
	
}
