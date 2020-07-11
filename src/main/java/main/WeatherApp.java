package main;

import java.io.IOException;
import java.util.Scanner;
import main.MainController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class WeatherApp extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("WeatherApp.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Weather App");
		primaryStage.show();
	}

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, UnirestException, IOException {
//		runConsoleProgram(); //test program without GUI
		launch(args);

	}

	public static void runConsoleProgram()
			throws UnirestException, JsonParseException, JsonMappingException, IOException {
		MainController controller = new MainController();
		controller.initAPI();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("[0] Exit program");
			System.out.println("[1] Get weather by location");
			System.out.println("[2] Get weather by coordinate");
			System.out.print("Choose an option: ");
			int option = input.nextInt();
			switch (option) {
			case 0:
				input.close();
				System.exit(0);
				Unirest.shutdown();
				return;
			case 1:
				System.out.print("Location: ");
				Scanner input2 = new Scanner(System.in);
				String location = input2.nextLine();
				controller.getWeatherByLocation(location);
				System.out.println(MainController.weatherResult);
				break;
			case 2:
				System.out.print("Latitude: ");
				Scanner input3 = new Scanner(System.in);
				double lat = input3.nextDouble();
				Scanner input4 = new Scanner(System.in);
				System.out.print("Longitude: ");
				double lon = input4.nextDouble();
				controller.getWeatherByCoordinate(lat, lon);
				System.out.println(MainController.weatherResult);
				break;
			default:
				System.out.println("Invalid option!");
			}
		}
	}
}
