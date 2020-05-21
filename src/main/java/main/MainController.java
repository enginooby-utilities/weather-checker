package main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.exceptions.UnirestException;

import api.result.WeatherResult;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import okhttp3.ResponseBody;

public class MainController {
	public final static String CHARSET = "UTF-8";
	public static WeatherResult weatherResult;
	public API placeAPI = new API();
	public API weatherAPI = new API();
	
	@FXML
	ProgressIndicator indicator = new ProgressIndicator();

	@FXML
	public void initialize() {
		indicator.setVisible(false);
		initAPI();
	}

	public void initAPI() {
		weatherAPI.setHost("https://community-open-weather-map.p.rapidapi.com/weather");
		weatherAPI.setX_rapidapi_host("community-open-weather-map.p.rapidapi.com");
		weatherAPI.setApi_key("d73df3ae49mshca0b07de4534617p129fbdjsn2c63492818c7");

		placeAPI.setHost("https://maps.googleapis.com/maps/api/place/findplacefromtext/");
		placeAPI.setApi_key("AIzaSyDy79x0BfH9mMTn6NAUHeYExZK93S8o8YE");
	}

	public String getImageByLocation(String location) throws UnirestException, UnsupportedEncodingException {
		placeAPI.setQuery(String.format("input=%s" + "&inputtype=textquery&fields=photos&key=",
				URLEncoder.encode(location + "", CHARSET)));

		JSONObject object = placeAPI.getGoogleApiObjResponse();
		JSONArray candidates = object.getJSONArray("candidates");
		JSONObject photosObj = ((JSONObject) candidates.get(0));
		JSONArray photos = photosObj.getJSONArray("photos");
		JSONObject item = (JSONObject) photos.get(0);
		String photo_reference = item.getString("photo_reference");

		String prefix = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=700&photoreference=";
		String suffix = "&key=" + placeAPI.getApi_key();
		String url = prefix + photo_reference + suffix;
		return url;
	}

	public void getWeatherByCoordinate(Double lat, Double lon) throws UnirestException, IOException {
		weatherAPI.setQuery(String.format("lat=%s&lon=%s", URLEncoder.encode(lat + "", CHARSET),
				URLEncoder.encode(lon + "", CHARSET)));

		ResponseBody responseBody = weatherAPI.getRapidApiResponseBody();
		ObjectMapper objectMapper = new ObjectMapper();
		weatherResult = objectMapper.readValue(responseBody.string(), WeatherResult.class);
	}

	public void getWeatherByLocation(String location) throws UnirestException, IOException {
		weatherAPI.setQuery(String.format("q=%s" + "&units=metric", URLEncoder.encode(location, CHARSET)));

		ResponseBody responseBody = weatherAPI.getRapidApiResponseBody();
		ObjectMapper objectMapper = new ObjectMapper();
		weatherResult = objectMapper.readValue(responseBody.string(), WeatherResult.class);
	}

	@FXML
	private Label result;
	@FXML
	private TextField txt_location = new TextField();
	@FXML
	private ImageView image;
	@FXML
	private TextField txt_lat = new TextField();
	@FXML
	private TextField txt_lon = new TextField();
	@FXML
	ListView list = new ListView();
	@FXML
	ListView list2 = new ListView();
	

	@FXML
	public void generateWeatherByLocation(ActionEvent event)
			throws UnirestException, JsonParseException, JsonMappingException, IOException {
		result.setText("");
		indicator.setVisible(true);
		txt_lat.clear();
		txt_lon.clear();
		Task task = new Task<Void>() { // create new task
			@Override
			public Void call() throws UnirestException, IOException {
				getWeatherByLocation(txt_location.getText());
				Platform.runLater(new Runnable() { // return to application thread
					@Override
					public void run() {
						try {
							displayResults();
						} catch (UnsupportedEncodingException | UnirestException e) {
							e.printStackTrace();
						}
					}
				});
				return null;
			}
		};
		new Thread(task).start(); // execute task in new thread

	}

	public void generateWeatherByCoordinate(ActionEvent event)
			throws NumberFormatException, UnirestException, IOException {
		result.setText("");
		indicator.setVisible(true);
		txt_location.clear();
		Task task = new Task<Void>() { // create new task
			@Override
			public Void call() throws UnirestException, IOException {
				getWeatherByCoordinate(Double.valueOf(txt_lat.getText()), Double.valueOf(txt_lon.getText()));
				Platform.runLater(new Runnable() { // return to application thread
					@Override
					public void run() {
						try {
							displayResults();
						} catch (UnsupportedEncodingException | UnirestException e) {
							e.printStackTrace();
						}
					}
				});
				return null;
			}
		};
		new Thread(task).start(); // execute task in new thread
	}

	public void displayResults() throws UnsupportedEncodingException, UnirestException {
		indicator.setVisible(false);
		result.setText(weatherResult.getName() + ", " + weatherResult.getSysObject().getCountry() + " - "
				+ weatherResult.getWeatherObject().get(0).getDescription());
		String url = getImageByLocation(weatherResult.getName());
		image.setImage(new Image(url));

		list.getItems().clear();
		list.getItems().add("Temp: " + weatherResult.getMainObject().getTemp() + " Celsius");
		list.getItems().add("Feels like: " + weatherResult.getMainObject().getFeels_like() + " Celsius");
		list.getItems().add("Min temp: " + weatherResult.getMainObject().getTemp_min() + " Celsius");
		list.getItems().add("Max temp: " + weatherResult.getMainObject().getTemp_max() + " Celsius");
		list.getItems().add("Humidity: " + weatherResult.getMainObject().getHumidity() + "%");
		list.getItems().add("Wind speed: " + weatherResult.getWindObject().getSpeed() + "m/s");
		list.getItems().add("Wind direction: " + weatherResult.getWindObject().getDeg() + " degrees");

		list2.getItems().clear();
		list2.getItems().add("Latitude: " + weatherResult.getCoordObject().getLat());
		list2.getItems().add("Longitude: " + weatherResult.getCoordObject().getLon());
		list2.getItems().add("Sunrise: " + weatherResult.getSysObject().getSunrise());
		list2.getItems().add("Sunset: " + weatherResult.getSysObject().getSunset());
		list2.getItems().add("Timezone: " + weatherResult.getTimezone());
		list2.getItems().add("Pressure: " + weatherResult.getMainObject().getPressure() + "hPa");
		list2.getItems().add("Cloudiness: " + weatherResult.getCloudsObject().getAll() + "%");

	}

	public String prettifyingJson(JSONObject object) {
//		System.out.println(prettifyingJson(object));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement je = new JsonParser().parse(object.toString());
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}

}
