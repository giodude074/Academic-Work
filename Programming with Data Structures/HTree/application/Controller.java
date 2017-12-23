package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Controller {
	@FXML
	private Pane displayPane;
	@FXML
	private TextField input;

	@FXML
	public void displayH(ActionEvent e) {
		int orderNum = Integer.parseInt(input.getText());
		drawLine(orderNum, 250, 250, 250); //order, height x, width, size
	}

	private void drawH(double x, double y, double size) {
		double x0 = x - size / 2;
		double y0 = y - size / 2;
		double x1 = x + size / 2;
		double y1 = y + size / 2;

		displayPane.getChildren().addAll(new Line(x0, y0, x0, y1), new Line(x1, y0, x1, y1), new Line(x0, y, x1, y)); // adds
																														// lines

	}

	private void drawLine(int orderNum, double x, double y, double size) {
		if (orderNum < 0)
			return; // base case

		drawH(x, y, size); // draw big H

		double x0 = x - size / 2;
		double y0 = y - size / 2;
		double x1 = x + size / 2;
		double y1 = y + size / 2;

		drawLine(orderNum - 1, x0, y0, size / 2); // up left
		drawLine(orderNum - 1, x1, y0, size / 2); // up right
		drawLine(orderNum - 1, x0, y1, size / 2); // down left
		drawLine(orderNum - 1, x1, y1, size / 2); // down right

	}

}
