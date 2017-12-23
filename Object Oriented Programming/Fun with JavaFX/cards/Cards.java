package cards;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Random;

public class Cards extends Application {

	@Override
	public void start(Stage stage) {

		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		setRand(hBox);

		// Creates buttons, Holds in an HBox
		HBox b = new HBox();
		b.setAlignment(Pos.BOTTOM_CENTER);
		b.setSpacing(10);
		Button btRefresh = new Button("Refresh");

		// Create and register the handler
		btRefresh.setOnAction(e -> setRand(hBox));

		b.getChildren().add(btRefresh);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(hBox);
		borderPane.setBottom(b);
		BorderPane.setMargin(b, new Insets(10, 10, 10, 10));
		borderPane.setPadding(new Insets(10, 10, 0, 10));
		borderPane.autosize();

		Scene scene = new Scene(borderPane, borderPane.getPrefWidth(), borderPane.getPrefHeight());
		stage.setTitle("Playing Cards");
		stage.setScene(scene);
		stage.show();

	}

	private void setRand(HBox pane) {
		String suit, c;

		boolean[] faceup = new boolean[52];
		int count = 0;
		Random rand = new Random();

		pane.getChildren().clear();
		while (count < 4) {
			int card = rand.nextInt(52);

			if (card % 13 == 1)
				c = "ace";
			else if (card % 13 == 11)
				c = "jack";
			else if (card % 13 == 12)
				c = "queen";
			else if (card % 13 == 0)
				c = "king";
			else
				c = Integer.toString(card % 13);

			if (card / 13 == 1)
				suit = "hearts";
			else if (card / 13 == 1)
				suit = "diamonds";
			else if (card / 13 == 1)
				suit = "clubs";
			else
				suit = "spades";

			if (!faceup[card]) {
				faceup[card] = true;
				ImageView imgView1 = new ImageView("images/" + c + "_of_" + suit + ".png");
				imgView1.setFitWidth(150);
				imgView1.setFitHeight(210);
				pane.getChildren().add(imgView1);
				count++;
			}
		}
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
}