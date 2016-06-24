package com.temboo.Library.WolframAlpha;

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
Query

Allows your application to submit free-form queries similar to the queries one might enter at the Wolfram|Alpha website.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/WolframAlpha/Query"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The App ID provided by Wolfram|Alpha.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the Assumption input for this Choreo. 

	@param String - (optional, string) Up to 10 comma-seperated assumptions to narrow a query.  Wolfram|Alpha provides you with a list of assumptons in the response of a previous query.  Please consult the documentation for more details.
	*/
	public void setAssumption(String value) {
		this.inputs.setInput("Assumption", value);
	}


	/** 
	Set the value of the Async input for this Choreo. 

	@param Boolean - (optional, boolean) Set to true to specify that asynchronous mode should be used. This allows partial results to come back before all the pods are computed.
	*/
	public void setAsync(Boolean value) {
		this.inputs.setInput("Async", value);
	}

	/** 
	Set the value of the Async input for this Choreo as a String. 

	@param String - (optional, boolean) Set to true to specify that asynchronous mode should be used. This allows partial results to come back before all the pods are computed.
	*/
	public void setAsync(String value) {
		this.inputs.setInput("Async", value);	
	}
	/** 
	Set the value of the ExcludePodID input for this Choreo. 

	@param String - (optional, string) Specifies the IDs of the pod(s) to exlude from the response. All pod IDs are returned by default.
	*/
	public void setExcludePodID(String value) {
		this.inputs.setInput("ExcludePodID", value);
	}


	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (optional, string) The desired result formats separated by commas. Valid values are image, plaintext, minput, moutput, cell, mathml, imagemap, sound, wav. Defaults to "plaintext,image".
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the FormatTimeout input for this Choreo. 

	@param BigDecimal - (optional, decimal) The number of seconds to allow Wolfram Alpha to spend in the "format" stage for the entire collection of pods. Default value is 8.0.
	*/
	public void setFormatTimeout(BigDecimal value) {
		this.inputs.setInput("FormatTimeout", value);
	}

	/** 
	Set the value of the FormatTimeout input for this Choreo as a String. 

	@param String - (optional, decimal) The number of seconds to allow Wolfram Alpha to spend in the "format" stage for the entire collection of pods. Default value is 8.0.
	*/
	public void setFormatTimeout(String value) {
		this.inputs.setInput("FormatTimeout", value);	
	}
	/** 
	Set the value of the IgnoreCase input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to force Wolfram Alpha to ignore case in queries. Defaults to false.
	*/
	public void setIgnoreCase(Boolean value) {
		this.inputs.setInput("IgnoreCase", value);
	}

	/** 
	Set the value of the IgnoreCase input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to force Wolfram Alpha to ignore case in queries. Defaults to false.
	*/
	public void setIgnoreCase(String value) {
		this.inputs.setInput("IgnoreCase", value);	
	}
	/** 
	Set the value of the IncludePodID input for this Choreo. 

	@param String - (optional, string) Specifies the IDs of the pod(s) to include in the response. All pod IDs are returned by default.
	*/
	public void setIncludePodID(String value) {
		this.inputs.setInput("IncludePodID", value);
	}


	/** 
	Set the value of the Input input for this Choreo. 

	@param String - (required, string) Specifies the input string (e.g., "5 largest countries").
	*/
	public void setInput(String value) {
		this.inputs.setInput("Input", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) When query results depend on your location, use this parameter to specify a latitude point.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) When query results depend on your location, use this parameter to specify a latitude point.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Location input for this Choreo. 

	@param String - (optional, string) When query results depend on your location, use this parameter to specify a location such as "Los Angeles, CA", or "Madrid".
	*/
	public void setLocation(String value) {
		this.inputs.setInput("Location", value);
	}


	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) When query results depend on your location, use this parameter to specify a longitude point.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) When query results depend on your location, use this parameter to specify a longitude point.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Magnification input for this Choreo. 

	@param BigDecimal - (optional, decimal) Controls the magnification of pod images. The default value is 1.0, indicating no magnification.
	*/
	public void setMagnification(BigDecimal value) {
		this.inputs.setInput("Magnification", value);
	}

	/** 
	Set the value of the Magnification input for this Choreo as a String. 

	@param String - (optional, decimal) Controls the magnification of pod images. The default value is 1.0, indicating no magnification.
	*/
	public void setMagnification(String value) {
		this.inputs.setInput("Magnification", value);	
	}
	/** 
	Set the value of the MaxWidth input for this Choreo. 

	@param Integer - (optional, integer) Used to change the default width of pod images. Width and MaxWidth apply to images of text and tables. This can be used to avoid undesirable line breaks if the value of Width is too small.
	*/
	public void setMaxWidth(Integer value) {
		this.inputs.setInput("MaxWidth", value);
	}

	/** 
	Set the value of the MaxWidth input for this Choreo as a String. 

	@param String - (optional, integer) Used to change the default width of pod images. Width and MaxWidth apply to images of text and tables. This can be used to avoid undesirable line breaks if the value of Width is too small.
	*/
	public void setMaxWidth(String value) {
		this.inputs.setInput("MaxWidth", value);	
	}
	/** 
	Set the value of the ParseTimeout input for this Choreo. 

	@param BigDecimal - (optional, decimal) The number of seconds to allow Wolfram Alpha to spend in the "parsing" stage of processing. Default value is 5.0.
	*/
	public void setParseTimeout(BigDecimal value) {
		this.inputs.setInput("ParseTimeout", value);
	}

	/** 
	Set the value of the ParseTimeout input for this Choreo as a String. 

	@param String - (optional, decimal) The number of seconds to allow Wolfram Alpha to spend in the "parsing" stage of processing. Default value is 5.0.
	*/
	public void setParseTimeout(String value) {
		this.inputs.setInput("ParseTimeout", value);	
	}
	/** 
	Set the value of the PlotWidth input for this Choreo. 

	@param Integer - (optional, integer) Controls the width at which plots and graphics are rendered. The default value is 200 pixels.
	*/
	public void setPlotWidth(Integer value) {
		this.inputs.setInput("PlotWidth", value);
	}

	/** 
	Set the value of the PlotWidth input for this Choreo as a String. 

	@param String - (optional, integer) Controls the width at which plots and graphics are rendered. The default value is 200 pixels.
	*/
	public void setPlotWidth(String value) {
		this.inputs.setInput("PlotWidth", value);	
	}
	/** 
	Set the value of the PodIndex input for this Choreo. 

	@param String - (optional, string) Specifies the index of the pod(s) to return. This is an alternative to specifying pods by title or ID. You can give a single number or a sequence like "2,3,5".
	*/
	public void setPodIndex(String value) {
		this.inputs.setInput("PodIndex", value);
	}


	/** 
	Set the value of the PodState input for this Choreo. 

	@param String - (optional, string) Specifies a pod state change, which replaces a pod with a modified version, such as a switch from Imperial to metric units.
	*/
	public void setPodState(String value) {
		this.inputs.setInput("PodState", value);
	}


	/** 
	Set the value of the PodTimeout input for this Choreo. 

	@param BigDecimal - (optional, decimal) The number of seconds to allow Wolfram Alpha to spend in the "format" stage for any one pod. Default value is 4.0.
	*/
	public void setPodTimeout(BigDecimal value) {
		this.inputs.setInput("PodTimeout", value);
	}

	/** 
	Set the value of the PodTimeout input for this Choreo as a String. 

	@param String - (optional, decimal) The number of seconds to allow Wolfram Alpha to spend in the "format" stage for any one pod. Default value is 4.0.
	*/
	public void setPodTimeout(String value) {
		this.inputs.setInput("PodTimeout", value);	
	}
	/** 
	Set the value of the PodTitle input for this Choreo. 

	@param String - (optional, string) Specifies the titles of the pod(s) to include in the response. All pod titles are returned by default. You can use * as a wildcard to match zero or more characters in pod titles.
	*/
	public void setPodTitle(String value) {
		this.inputs.setInput("PodTitle", value);
	}


	/** 
	Set the value of the Reinterpret input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to allow Wolfram Alpha to reinterpret queries that would otherwise not be understood. Defaults to false.
	*/
	public void setReinterpret(Boolean value) {
		this.inputs.setInput("Reinterpret", value);
	}

	/** 
	Set the value of the Reinterpret input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to allow Wolfram Alpha to reinterpret queries that would otherwise not be understood. Defaults to false.
	*/
	public void setReinterpret(String value) {
		this.inputs.setInput("Reinterpret", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format for the response. Valid values are JSON and XML. This will be ignored when providng an XPath query because results are returned as a string or JSON depending on the Mode specified.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ScanTimeout input for this Choreo. 

	@param BigDecimal - (optional, decimal) The number of seconds to allow Wolfram Alpha to compute results in the "scan" stage of processing. Default value is 3.0.
	*/
	public void setScanTimeout(BigDecimal value) {
		this.inputs.setInput("ScanTimeout", value);
	}

	/** 
	Set the value of the ScanTimeout input for this Choreo as a String. 

	@param String - (optional, decimal) The number of seconds to allow Wolfram Alpha to compute results in the "scan" stage of processing. Default value is 3.0.
	*/
	public void setScanTimeout(String value) {
		this.inputs.setInput("ScanTimeout", value);	
	}
	/** 
	Set the value of the Scanner input for this Choreo. 

	@param String - (optional, string) Specifies that only pods produced by the given scanner should be returned. (e.g. Numeric, Music).  Defaults to all pods.
	*/
	public void setScanner(String value) {
		this.inputs.setInput("Scanner", value);
	}


	/** 
	Set the value of the Translation input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to allow Wolfram Alpha to try to translate simple queries into English. Defaults to true.
	*/
	public void setTranslation(Boolean value) {
		this.inputs.setInput("Translation", value);
	}

	/** 
	Set the value of the Translation input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to allow Wolfram Alpha to try to translate simple queries into English. Defaults to true.
	*/
	public void setTranslation(String value) {
		this.inputs.setInput("Translation", value);	
	}
	/** 
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) Lets you specify the preferred measurement system, either "metric" or "nonmetric" (U.S. customary units).
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	/** 
	Set the value of the Width input for this Choreo. 

	@param Integer - (optional, integer) Used to change the default width of pod images. The default is 500 pixels. Width and MaxWidth apply to images of text and tables.
	*/
	public void setWidth(Integer value) {
		this.inputs.setInput("Width", value);
	}

	/** 
	Set the value of the Width input for this Choreo as a String. 

	@param String - (optional, integer) Used to change the default width of pod images. The default is 500 pixels. Width and MaxWidth apply to images of text and tables.
	*/
	public void setWidth(String value) {
		this.inputs.setInput("Width", value);	
	}
	/** 
	Set the value of the XPath input for this Choreo. 

	@param String - (optional, string) An XPath query to apply to the API results.
	*/
	public void setXPath(String value) {
		this.inputs.setInput("XPath", value);
	}


	/** 
	Set the value of the XPathMode input for this Choreo. 

	@param String - (optional, string) Valid values are "select" (the default) or "recursive". Recursive mode will iterate using the provided XPath. Select mode will return the first match at the position indicated by the provided XPath.
	*/
	public void setXPathMode(String value) {
		this.inputs.setInput("XPathMode", value);
	}


	/** 
	Set the value of the XPathRegex input for this Choreo. 

	@param String - (optional, string) A regular expression that can be applied to the result of the XPath query provided.
	*/
	public void setXPathRegex(String value) {
		this.inputs.setInput("XPathRegex", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
