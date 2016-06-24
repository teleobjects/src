package com.temboo.Library.Foursquare.Lists;

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
AddItem

Allows a user to add an item to a list.
*/
public class AddItem extends Choreography {

	/**
	Create a new instance of the AddItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Lists/AddItem"));
	}

	/** 
	Set the value of the ItemID input for this Choreo. 

	@param String - (conditional, string) The id of an item on a list that you wish to copy to the target list. Used in conjuction with ListID. Note that one of the following must be specified: VenueID, TipID, ItemListID, or ItemID.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);
	}


	/** 
	Set the value of the ItemListID input for this Choreo. 

	@param String - (conditional, string) The ID of a list that contains an item that you wish to copy to the new list. Used in conjuction with ItemID. Note that one of the following must be specified: VenueID, TipID, ItemListID, or ItemID.
	*/
	public void setItemListID(String value) {
		this.inputs.setInput("ItemListID", value);
	}


	/** 
	Set the value of the ListID input for this Choreo. 

	@param String - (required, string) The ID of the list that  you are adding an item to. This can be a user-created list id or one of tips, todos, or dones.
	*/
	public void setListID(String value) {
		this.inputs.setInput("ListID", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (optional, string) If the target is a user-created list, this will create a public tip on the venue. If the target is todos, the text will be a private note that is only visible to the author.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	/** 
	Set the value of the TipID input for this Choreo. 

	@param String - (conditional, string) The id of a tip to add to the list. Cannot be used in conjunction with the Text and URL inputs. Note that one of the following must be specified: VenueID, TipID, ItemListID, or ItemID.
	*/
	public void setTipID(String value) {
		this.inputs.setInput("TipID", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (optional, string) If adding a new tip using the Text input, this can associate a url with the tip.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the VenueID input for this Choreo. 

	@param String - (conditional, string) The id of a venue to add to the list. Note that one of the following must be specified: VenueID, TipID, ItemListID, or ItemID.
	*/
	public void setVenueID(String value) {
		this.inputs.setInput("VenueID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddItemResultSet(result);
	}
	
}
