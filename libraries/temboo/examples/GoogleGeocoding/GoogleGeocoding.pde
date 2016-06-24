// More examples & getting started tutorials can be found at: 
// https://temboo.com/processing

// Import the Temboo library core and appropriate Choreos
import com.temboo.core.*;
import com.temboo.Library.Google.Geocoding.*;

// Create a session using your Temboo account application details
// If you don't have a Temboo account, sign up here:
// http://temboo.com/signup
// If you do have a Temboo account, find your application details here:
// http://temboo.com/account/applications
TembooSession session = new TembooSession("teleobjects", "teleobjects", "d1YKYX3a5Y6V1LAyYebWzB1RczFVkwrN");

// Set up some global variables
String location = "New York, NY";
float latitude, longitude;

void setup() {
  // Run the GeocodeByAddress Choreo function
  runGeocodeByAddressChoreo();
}

void runGeocodeByAddressChoreo() {
  // Create the Choreo object using your Temboo session
  GeocodeByAddress geocodeByAddressChoreo = new GeocodeByAddress(session);

  // Set inputs
  geocodeByAddressChoreo.setAddress(location);

  // Run the Choreo and store the results
  GeocodeByAddressResultSet geocodeByAddressResults = geocodeByAddressChoreo.run();

  // Save latitude and longitude as floats
  latitude = float(geocodeByAddressResults.getLatitude());
  longitude = float(geocodeByAddressResults.getLongitude());

  // Print latitude and longitude
  println("location: " + location);
  println("latitude: " + latitude);
  println("longitude: " + longitude);
}