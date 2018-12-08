package application;

import Table.Table;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import logic.Order;

public class OrderInput extends HBox  {
	
	
	public OrderInput(Table table, String name) {
		setAlignment(Pos.CENTER_LEFT);
		setSpacing(150);
		Label orderName = new Label(name);
		Button order = new Button("Order");
		order.setOnMouseClicked(e -> {
			
			//table.getBill().addToBill(new Order(null, table));
		});
		getChildren().addAll(orderName, order);
	}
}
