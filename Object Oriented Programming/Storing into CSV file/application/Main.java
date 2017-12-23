package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/xml/App.fxml"));
        stage.setTitle("Hi");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}