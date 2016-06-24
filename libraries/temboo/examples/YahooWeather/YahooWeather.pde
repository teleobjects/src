// More examples & getting started tutorials can be found at: 
// https://temboo.com/processing

// Import the Temboo library core and appropriate Choreos
import com.temboo.core.*;
import com.temboo.Library.Yahoo.Weather.*;

// Create a session using your Temboo account application details
// If you don't have a Temboo account, sign up here:
// http://temboo.com/signup
// If you do have a Temboo account, find your application details here:
// http://temboo.com/account/applications
TembooSession session = new TembooSession("ACCOUNT_NAME", "APP_NAME", "APP_KEY");

//Delare location array 
String[] location;
int currentLocation = 0;

// Declare fonts
PFont fontTemperature, fontLocation, fontInstructions;

// Give on-screen user instructions
String instructions = "Press any key to change cities";

// Set up some global values
int temperature;
XML weatherResults;

void setup() {
  size(350, 350);

  // Set up fonts
  fontTemperature = createFont("Arial Black", 150);
  fontLocation = createFont("Arial Black", 36);
  fontInstructions = createFont("Arial Black", 16);
  fill(255); // Font color

  // Set up locations
  location = new String[4]; // Total number of locations listed below
  location[0] = "New York";
  location[1] = "Los Angeles";
  location[2] = "Buenos Aires";
  location[3] = "Nome, Alaska";

  // Display initial location
  runGetWeatherByAddressChoreo(); // Run the GetWeatherByAddress Choreo function
  getTemperatureFromXML(); // Get the temperature from the XML results
  displayColor(); // Set the background color
  displayText(); // Display text
}

void draw() {
  if (keyPressed) {
    // Switch to next location
    currentLocation++;

    // If you've reached the end of the list, go back to the start
    if (currentLocation > location.length-1 ) {
      currentLocation = 0;
    }

    runGetWeatherByAddressChoreo(); // Run the GetWeatherByAddress Choreo function
    getTemperatureFromXML(); // Get the temperature from the XML results
    displayColor(); // Set the background color
    displayText(); // Display text
  }
}

void runGetWeatherByAddressChoreo() {
  // Create the Choreo object using your Temboo session
  GetWeatherByAddress getWeatherByAddressChoreo = new GetWeatherByAddress(session);

  // Set inputs
  getWeatherByAddressChoreo.setAddress(location[currentLocation]);

  // Run the Choreo and store the results
  GetWeatherByAddressResultSet getWeatherByAddressResults = getWeatherByAddressChoreo.run();

  // Store results in an XML object
  weatherResults = parseXML(getWeatherByAddressResults.getResponse());
}

void getTemperatureFromXML() {
  // Narrow down to weather condition
  XML condition = weatherResults.getChild("channel/item/yweather:condition");

  // Get the current temperature in Fahrenheit from the weather conditions
  temperature = condition.getInt("temp");

  // Print temperature value
  println("The current temperature in "+location[currentLocation]+" is "+temperature+"ºF");
}

void displayColor() {
  // Set up the temperature range in Fahrenheit
  int minTemp = 10;
  int maxTemp = 95;

  // Convert temperature to a 0-255 color value
  float temperatureColor = map(temperature, minTemp, maxTemp, 0, 255);    

  // Set background color using temperature on a blue to red scale     
  background(color(temperatureColor, 0, 255-temperatureColor));
}

void displayText() {
  // Set up text margins
  int margin = 35;
  int marginTopTemperature = 150;
  int marginTopLocation = 175;

  // Display temperature
  textFont(fontTemperature);
  text(temperature, margin, marginTopTemperature);

  // Display location
  textFont(fontLocation);
  text(location[currentLocation], margin, marginTopLocation, width-margin, height-margin);

  // Display instructions
  textFont(fontInstructions);
  text(instructions, margin, height-margin);
}
