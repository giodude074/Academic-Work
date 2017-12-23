
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.web.WebViewBuilder;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class HAuS extends Application{

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("H.Au.S");
		primaryStage.setResizable(false);

		VBox main=new VBox();
		main.setId("mainVBox");

		Scene FirstScene=new Scene(main,420,420);
		FirstScene.getStylesheets().add(HAuS.class.getResource("Style2.css").toExternalForm());

		main.getChildren().add(top());
		main.getChildren().add(mid());
		main.getChildren().add(bot());

		primaryStage.setScene(FirstScene);
		primaryStage.show();		

	}



	public HBox top(){

		HBox top=new HBox();
		top.setId("topHBox");

		Image logo=new Image("logo.jpg");
		ImageView iv1 = new ImageView();
		iv1.setFitHeight(100);
		iv1.setFitWidth(100);

		iv1.setImage(logo);
		Text name=new Text("H.Au.S");
		name.setStyle("-fx-font-size:40;-fx-font-weight: bolder; ");
		name.setFill(Color.LIGHTBLUE);
		 Reflection r = new Reflection();
         r.setFraction(0.7f);
         name.setEffect(r);
         
        
		top.getChildren().add(iv1);        
		top.getChildren().add(name);

		return top;

	}



	public HBox mid(){
		VBox midleft=new VBox();
		midleft.setId("midLeftVBox");
		Button log=new Button("Log Details");
		Button drone=new Button("Drone Details");
		drone.setOnAction(k->{
			WebView webviewBrowser = new WebView();
			Stage live =new Stage();

			live.setTitle("DRONE ACTION");
			BorderPane borderPane=new BorderPane();
			borderPane.setCenter( webviewBrowser );
			final WebEngine engine = webviewBrowser.getEngine();
			engine.load( "https://www.youtube.com/watch?v=0GRaAHexsVk" );
			engine.setJavaScriptEnabled( true );
			Scene sc=new Scene(borderPane,800,600);
			live.setScene(sc);
			live.show();

		});

		Button stream=new Button("Live-Stream");
		stream.setOnAction(k->{
			WebView webviewBrowser = new WebView();
			Stage live =new Stage();
		
			live.setTitle("LIVE STREAM - H.Au.S");
			BorderPane borderPane=new BorderPane();
			borderPane.setCenter( webviewBrowser );
			final WebEngine engine = webviewBrowser.getEngine();
			engine.load( "http://192.168.43.45/" );
			engine.setJavaScriptEnabled( true );
			Scene sc=new Scene(borderPane,800,800);
			live.setScene(sc);
			live.show();

		});
		Button access=new Button("View Pics/Vids");

		access.setOnAction(m->{
			DirectoryChooser chooser = new DirectoryChooser();
			chooser.setTitle("LSM DATABASE");
			File defaultDirectory = new File("C:/Users/Pranil/Pictures");
			chooser.setInitialDirectory(defaultDirectory);
			File selectedDirectory = chooser.showDialog(new Stage());
		});
		midleft.getChildren().add(log);
		midleft.getChildren().add(drone);
		midleft.getChildren().add(stream);
		midleft.getChildren().add(access);

		log.setId("dark-blue");
		drone.setId("dark-blue");
		stream.setId("dark-blue");
		access.setId("dark-blue");

		VBox midright=new VBox();
		VBox up=new VBox();
		up.setStyle("-fx-spacing:5;-fx-alignment:center;");
		up.setAlignment(Pos.CENTER);

		HBox down=new HBox();
		down.setId("TopRightButtons");

		Text SS=new Text("CURRENT STATUS");
		SS.setFill(Color.rgb(154, 154, 154, .99));
		

		SS.setStyle("-fx-font-size:20;-fx-font-weight: bolder;");

		Button green=new Button("Protected");
		green.setAlignment(Pos.CENTER);
		green.setStyle("-fx-text-fill:green;");
		green.setId("lion");


		down.getChildren().add(green);
		up.getChildren().add(SS);
		up.getChildren().add(down);
		midright.setId("midRightVBox");
		Text sec=new Text("SECURITY");
		sec.setId("SECURITY");
		sec.setFill(Color.rgb(154, 154, 154, .99));
		Button onoff=new Button("");
		Button onoff2=new Button("");
		midright.getChildren().add(sec);
		midright.getChildren().add(onoff);
		midright.getChildren().add(up);
		up.setSpacing(40);





		onoff.setId("ONOFF1");

		onoff2.setId("ONOFF2");
		onoff.setOnAction(e-> {
			if(midright.getChildren().contains(onoff)){

				midright.getChildren().clear();
				midright.getChildren().add(sec);
				midright.getChildren().add(onoff2);
				midright.getChildren().add(up);

			}
			else if(midright.getChildren().contains(onoff2)){
				midright.getChildren().clear();
				midright.getChildren().add(sec);
				midright.getChildren().add(onoff);
				midright.getChildren().add(up);
			}
		}
				);

		onoff2.setOnAction(e-> {
			if(midright.getChildren().contains(onoff)){
				midright.getChildren().clear();
				midright.getChildren().add(sec);
				midright.getChildren().add(onoff2);
				midright.getChildren().add(up);

			}
			else if(midright.getChildren().contains(onoff2)){

				midright.getChildren().clear();
				midright.getChildren().add(sec);
				midright.getChildren().add(onoff);
				midright.getChildren().add(up);

			}
		}
				);


		HBox mid=new HBox();
		mid.setId("midHBox");
		mid.getChildren().add(midleft);
		mid.getChildren().add(midright);

		return mid;
	}

	public HBox bot(){
		Text txt=new Text("Please Call 1-800-MYHOUSE for 24/7 assistance.");
txt.setFill(Color.WHITE);
		HBox bot=new HBox();
		bot.setStyle("-fx-padding:0,10,10,20;-fx-alignment:center;");
		bot.setId("BotHBox");
		bot.getChildren().add(txt);
		return bot;
	}


	public static void buttons(Button x){

	}






}
