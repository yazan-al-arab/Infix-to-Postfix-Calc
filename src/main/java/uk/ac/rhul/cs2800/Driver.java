package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}