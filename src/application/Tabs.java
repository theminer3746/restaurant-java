package application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Tabs extends HBox {

	public Tabs(VBox root, TableGrid tableGrid, KitchenPane kitchen) {
		setSpacing(5);

		Button counterBtn = new Button("Counter");
		counterBtn.setOnAction(e -> {
			boolean gridStatus = tableGrid.getStatus();
			boolean kitchenStatus = kitchen.getStatus();
			if (gridStatus == true) {

			} else if (gridStatus == false && kitchenStatus == false) {
				root.getChildren().add(tableGrid);
			} else {
				root.getChildren().remove(kitchen);
				root.getChildren().add(tableGrid);
			}
			tableGrid.setStatus(true);
			kitchen.setStatus(false);
		});

		Button kitchenBtn = new Button("Kitchen");
		kitchenBtn.setOnAction(e -> {
			boolean gridStatus = tableGrid.getStatus();
			boolean kitchenStatus = kitchen.getStatus();
			if (kitchenStatus == true) {

			} else if (gridStatus == false && kitchenStatus == false) {
				root.getChildren().add(kitchen);
			} else {
				root.getChildren().remove(tableGrid);
				root.getChildren().add(kitchen);
			}
			tableGrid.setStatus(false);
			kitchen.setStatus(true);
		});

		Button closeBtn = new Button("Close");
		closeBtn.setOnAction(e -> {
			System.exit(0);
		});

		getChildren().addAll(counterBtn, kitchenBtn, closeBtn);
	}
	
	
}
