package games;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.Random;

public class TicTacToe extends Application {

	@Override
	public void start(Stage stage) {

		GridPane grid = new GridPane();
		grid.setHgap(.1);
		grid.setVgap(.1);
		grid.setPadding(new Insets(0, 10, 0, 10));

		Image[] imgs = new Image[2];
		imgs[0] = new Image("images/x.gif");
		imgs[1] = new Image("images/o.gif");

		ImageView[] markers = new ImageView[9];
		Random random = new Random();
		for (int i=0; i<9; i++)
			markers[i]= new ImageView (imgs[random.nextInt(2)]);
		//Cell
		grid.add(markers[0],0,0);

		//Cell
		grid.add(markers[1], 1, 0);

		//Cell
		grid.add(markers[2], 2, 0);

		//Cell
		 grid.add(markers[3], 0, 1);

		//Cell
		 grid.add(markers[4], 1, 1);

		//Cell
		 grid.add(markers[5], 2, 1);

		//Cell
		 grid.add(markers[6], 0, 2);

		//Cell
		grid.add(markers[7], 1, 2);

		//Cell
		 grid.add(markers[8], 2, 2);

		for (int i = 0; i < 3; i++)
			grid.getRowConstraints().add(new RowConstraints(133));
		for (int i = 0; i < 3; i++)
			grid.getColumnConstraints().add(new ColumnConstraints(133));



		Scene scene = new Scene(grid, 400, 400);
		scene.setFill(Color.WHITE);


		stage.setTitle("Tic Tac Toe");
		stage.setWidth(400);
		stage.setHeight(400);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();


		 /* Scene scene2 = new Scene(new LinePane(), 200, 200);
		  stage.setTitle("ShowLine");
		  stage.setScene(scene2); 
		*/
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

  class LinePane extends Pane {
  	public LinePane() {
  		Line vertical1 = new Line(133, 10, 133, 390);
  		vertical1.setStrokeWidth(3);
  		vertical1.setStroke(Color.BLACK);
  		getChildren().add(vertical1);

  		Line horizontal1 = new Line(266, 10, 266, 390);
  		horizontal1.setStrokeWidth(3);
  		horizontal1.setStroke(Color.BLACK);
  		getChildren().add(horizontal1);

  		Line vertical2 = new Line(10, 133, 390, 133);
  		vertical2.setStrokeWidth(3);
  		vertical2.setStroke(Color.BLACK);
  		getChildren().add(vertical2);

  		Line horizontal2 = new Line(10, 266, 390, 266);
  		horizontal2.setStrokeWidth(3);
  		horizontal2.setStroke(Color.BLACK);
  		getChildren().add(horizontal2);

}}