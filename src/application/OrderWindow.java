package application;

import Table.Table;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Menu;
import logic.Order;
import logic.Restaurant;

public class OrderWindow extends Stage {
	public OrderWindow(Table table, Button tableBtn, Restaurant restaurant, KitchenPane kitchenPane,
			ObservableList<Label> logServeList, TableGrid tableGrid) {
		VBox orderWindow = new VBox();
		orderWindow.setMinWidth(250);
		orderWindow.setAlignment(Pos.TOP_CENTER);
		orderWindow.setPadding(new Insets(5));
		orderWindow.setSpacing(5);
		Scene scene = new Scene(orderWindow);

		Label label = new Label("Menu List");
		orderWindow.getChildren().add(label);

		for (Menu menu : restaurant.getMenuList().getMenus()) {
			orderWindow.getChildren().add(
					new OrderInput(table, menu, restaurant.getKitchen().getOrderList(), kitchenPane, logServeList));
		}

		if (table.getBill().getBillableTotal() != 0) {
			Button checkBtn = new Button("Check");
			checkBtn.setOnMouseClicked(e1 -> {

				boolean found = false;
				for (Order order : restaurant.getKitchen().getOrderList().getOrders()) {
					if (order.getTable().getTableNumber() == table.getTableNumber()) {
						found = true;
					}
				}
				if (found == true) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Error");
					alert.setContentText("Some of this table's order(s) is still being prepared in the kitchen");
					alert.show();
				} else {
					new CheckWindow(table, tableBtn, this, logServeList, tableGrid, kitchenPane, restaurant);
				}

			});
			orderWindow.getChildren().add(checkBtn);
		}

		Button close = new Button("Close");
		close.setOnAction(e1 -> {
			close();
		});
		orderWindow.getChildren().add(close);
		setTitle("Order(s)");
		setScene(scene);
		show();
	}

}
