package application;

import Table.Table;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

public class OrderInput extends HBox {

	public OrderInput(Table table, String name) {
		setAlignment(Pos.CENTER_LEFT);
		setSpacing(60);
		Label orderName = new Label(name);
		TextField quantity = new TextField();
		quantity.setPromptText("Quantity");
		Button order = new Button("Order");
		order.setOnMouseClicked(e -> {
			try {
				int amount = Integer.parseInt(quantity.getText());
				if (amount <= 0) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showNegativeQuantityError();

				} else {
					// create new order add to orderlist
					/// place order

				}
			} catch (NumberFormatException e1) {
				if (quantity.getText().isEmpty()) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showEmptyQuantityTextFieldError();

				} else {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showIncorrectQuantityFormatError();
				}
			}
		});
		getChildren().addAll(orderName, quantity, order);
	}
}