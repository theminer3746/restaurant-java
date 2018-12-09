package application;

import Table.Table;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Menu;
import logic.Order;
import logic.OrderList;

public class OrderInput extends HBox {

	public OrderInput(Table table, Menu menu, OrderList orderList, KitchenPane kitchenPane, ObservableList<Label> logServeList) {
		setAlignment(Pos.CENTER_RIGHT);
		setSpacing(5);
		Label orderName = new Label(menu.getName());
		TextField quantity = new TextField();
		quantity.setPromptText("Quantity");
		Button orderBtn = new Button("Order");
		orderBtn.setOnMouseClicked(e -> {
			try {
				int amount = Integer.parseInt(quantity.getText());
				if (amount <= 0) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showNegativeQuantityError();

				} else {
					Order order = new Order(menu, table);
					order.setAmount(amount);
					orderList.addToOrders(order);
					kitchenPane.order(new Label("Table's Number : " + table.getTableNumber() + ", " + menu.getName() + amount));
					
					logServeList.add(new Label("Table's Number : " + table.getTableNumber() + ", " + menu.getName() + amount));
					
					quantity.setText("");

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
		getChildren().addAll(orderName, quantity, orderBtn);
	}
}