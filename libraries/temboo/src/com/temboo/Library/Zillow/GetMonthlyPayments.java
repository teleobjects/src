package com.temboo.Library.Zillow;

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
GetMonthlyPayments

Retrieve estimated monthly payments, including principal and interest based on current interest rates.
*/
public class GetMonthlyPayments extends Choreography {

	/**
	Create a new instance of the GetMonthlyPayments Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetMonthlyPayments(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zillow/GetMonthlyPayments"));
	}

	/** 
	Set the value of the DollarsDown input for this Choreo. 

	@param Integer - (optional, integer) Specify the dollar amount that is placed for a down payment. This variable can be used in place of DownPaymentAmount.
	*/
	public void setDollarsDown(Integer value) {
		this.inputs.setInput("DollarsDown", value);
	}

	/** 
	Set the value of the DollarsDown input for this Choreo as a String. 

	@param String - (optional, integer) Specify the dollar amount that is placed for a down payment. This variable can be used in place of DownPaymentAmount.
	*/
	public void setDollarsDown(String value) {
		this.inputs.setInput("DollarsDown", value);	
	}
	/** 
	Set the value of the DownPaymentAmount input for this Choreo. 

	@param Integer - (optional, integer) Enter the percentage of the total properly price that will be used as a down payment. If < 20%, mortage insurance info is also returned.
	*/
	public void setDownPaymentAmount(Integer value) {
		this.inputs.setInput("DownPaymentAmount", value);
	}

	/** 
	Set the value of the DownPaymentAmount input for this Choreo as a String. 

	@param String - (optional, integer) Enter the percentage of the total properly price that will be used as a down payment. If < 20%, mortage insurance info is also returned.
	*/
	public void setDownPaymentAmount(String value) {
		this.inputs.setInput("DownPaymentAmount", value);	
	}
	/** 
	Set the value of the OutputFormat input for this Choreo. 

	@param String - (optional, string) Enter the desired query output format.  Enter: xml, or json.  Default output is set to: xml.
	*/
	public void setOutputFormat(String value) {
		this.inputs.setInput("OutputFormat", value);
	}


	/** 
	Set the value of the Price input for this Choreo. 

	@param Integer - (required, integer) Enter the price for which the monthly payment is to be calculated.
	*/
	public void setPrice(Integer value) {
		this.inputs.setInput("Price", value);
	}

	/** 
	Set the value of the Price input for this Choreo as a String. 

	@param String - (required, integer) Enter the price for which the monthly payment is to be calculated.
	*/
	public void setPrice(String value) {
		this.inputs.setInput("Price", value);	
	}
	/** 
	Set the value of the ZWSID input for this Choreo. 

	@param String - (required, string) Enter a Zillow Web Service Identifier (ZWS ID).
	*/
	public void setZWSID(String value) {
		this.inputs.setInput("ZWSID", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param Integer - (optional, integer) Enter the zip code of the property.  If null, no property tax, or hazard insurance data will be returned.
	*/
	public void setZip(Integer value) {
		this.inputs.setInput("Zip", value);
	}

	/** 
	Set the value of the Zip input for this Choreo as a String. 

	@param String - (optional, integer) Enter the zip code of the property.  If null, no property tax, or hazard insurance data will be returned.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetMonthlyPaymentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetMonthlyPaymentsResultSet(result);
	}
	
}
