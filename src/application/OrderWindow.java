package application;

import Table.Table;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Menu;
import logic.Restaurant;

public class OrderWindow extends Stage {
	public OrderWindow(Table table, Button tableBtn, Restaurant restaurant, KitchenPane kitchenPane) {
		VBox orderWindow = new VBox();
		orderWindow.setMinWidth(250);
		orderWindow.setAlignment(Pos.TOP_CENTER);
		orderWindow.setPadding(new Insets(5));
		orderWindow.setSpacing(5);
		Scene scene = new Scene(orderWindow);

		Label label = new Label("Menu List");
		orderWindow.getChildren().add(label);
		
		 for (Menu menu : restaurant.getMenuList().getMenus()) {
			 orderWindow.getChildren().add(new OrderInput(table, menu, restaurant.getKitchen().getOrderList(), kitchenPane));
		 }
		 
		if (table.getBill().getBillableTotal() == 0) {
			Button checkBtn = new Button("Check");
			checkBtn.setOnMouseClicked(e1 -> {
				new CheckWindow(table, tableBtn, this);
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
