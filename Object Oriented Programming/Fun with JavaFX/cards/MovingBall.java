package cards;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MovingBall extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		CirclePane circlePane = new CirclePane(200, 200, Math.min(200, 200) / 4);

		// Create buttons
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");

		// Create and register the handler
		btLeft.setOnAction(e -> circlePane.moveLeft());
		btRight.setOnAction(e -> circlePane.moveRight());
		btUp.setOnAction(e -> circlePane.moveUp());
		btDown.setOnAction(e -> circlePane.moveDown());

		// Hold buttons in an HBox
		HBox buttons = new HBox(btLeft, btRight, btUp, btDown);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10, 10, 10, 10));

		BorderPane pane = new BorderPane();
		pane.setCenter(circlePane);
		pane.setBottom(buttons);

		Scene scene = new Scene(pane, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Move Ball");
		stage.show();
	}

	private class CirclePane extends Pane {
		// creating circle
		private Circle circle;

		public CirclePane(double centerX, double centerY, double radius) {
			circle = new Circle(centerX, centerY, radius);
			getChildren().add(circle);
			// circle.setStroke(Color.BLACK); it looks ugly with the stroke
			circle.setFill(new Color(0, 1, 0.5, 0.5));
		}

		// Movement Methods
		public void moveLeft() {
			circle.setCenterX(circle.getCenterX() - 5);
		}

		public void moveRight() {
			circle.setCenterX(circle.getCenterX() + 5);
		}

		public void moveUp() {
			//if (circle.getCenterY() - circle.getRadius()  - 5 < 0) return; //restriction so it doesnt pass
			circle.setCenterY(circle.getCenterY() - 5);


		}

		public void moveDown() {
			circle.setCenterY(circle.getCenterY() + 5);
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}