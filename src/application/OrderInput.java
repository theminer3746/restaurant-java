package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class OrderInput extends HBox  {
	
	
	public OrderInput(String name) {
		setAlignment(Pos.CENTER_LEFT);
		setSpacing(5);
		Label orderName = new Label(name);
		Button order = new Button("Order");
		/////
		getChildren().addAll(orderName, order);
	}
}
