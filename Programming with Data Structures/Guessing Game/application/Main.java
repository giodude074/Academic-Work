package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/xml/Layout.fxml"));
		    Parent root = loader.load();
		    Controller controller = loader.getController();
			Scene scene = new Scene(root,500,600);
			scene.getStylesheets().add("/styles/style.css");
			scene.setOnKeyReleased(event -> controller.handleInput(event));
			primaryStage.setScene(scene);
			primaryStage.setTitle("Homework 3");

			//primaryStage.setResizable(false);
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
