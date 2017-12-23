package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Controller {
	@FXML
	private Pane displayPane;
	@FXML
	private TextField input;
	 double side = Math.min(500, 500) * 0.8; //width, height,
	 double triangleHeight = side * Math.sin(Math.toRadians(60));
	@FXML
	public void displayH(ActionEvent e) {
		int orderNum = Integer.parseInt(input.getText());
		drawLine(orderNum, 500, 125/2, 500); //order, height x, width, size

	}


	private void paint(double x, double y, double size) {
	      double x0 = (x / 2);
	      double y0 = y;
	      double x1 = (x / 2 - side / 2);
	      double y1 = y + triangleHeight;
	      double x2 = (x / 2 + side / 2);
	      double y2 = y + triangleHeight;

		displayPane.getChildren().addAll(new Line(x0, y0, x1, y1), new Line(x1, y1, x2, y2), new Line(x2, y2, x0, y0)); // adds lines
		//P1: x0 = 250.0   y0= 500.0
		//P2: x1 = 50.0   y1= 846.4101615137754
		//P3: x2 = 450.0   y2= 846.4101615137754

	}
	private void drawLine(int order, double x, double y, double size){
		if (order < 0)
		return; // base case
			paint(x,  y, size);
			double x0 = (x / 2);
		      double y0 = y;
		      double x1 = (x / 2 - side / 2);
		      double y1 = y + triangleHeight;
		      double x2 = (x / 2 + side / 2);
		      double y2 = y + triangleHeight;

		if (order >= 1){
			double distance1 = ((x2-x1)/3);
			double distance2 = ((y2-y1)/3);
         double pAx = ( x2+distance1);
         double pAy = ( y1+distance2);
         double pBx = ( x2-distance1);
         double pBy = ( y2-distance2);

         	double pCz1= ((distance1+distance2)/2 + Math.cos(Math.toRadians(30))*(pAy- pBy/3));

        	double pCz2= (pAy+pBy)/2 + Math.cos(Math.toRadians(30))*((pBy- pAy)/3);

			drawLine( order - 1, x1, pAx,size);
			drawLine( order - 1, pAx, pCz1,size/2);
			drawLine( order - 1, pCz2, pBy,size);
			drawLine( order - 1, pBy, pAy,size);
		}
	}
}

