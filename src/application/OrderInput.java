package application;

import Table.Table;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import logic.Order;

public class OrderInput extends HBox  {
	
	
	public OrderInput(Table table, String name) {
		setAlignment(Pos.CENTER_LEFT);
		setSpacing(150);
		Label orderName = new Label(name);
		TextField quantity = new TextField();
		quantity.setPromptText("Quantity");
		Button order = new Button("Order");
		order.setOnMouseClicked(e -> {
			int orderQuantity = quantity.getText();
			// create new order add to orderlist
		});
		getChildren().addAll(orderName, order);
	}
}
