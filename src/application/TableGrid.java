package application;

import Table.Table;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import logic.Restaurant;

public class TableGrid extends GridPane {

	boolean status;

	public TableGrid(Restaurant restaurant, KitchenPane kitchenPane) {
		setGrid();

		setMinSize(300, 350);
		setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));

		for (Table table : restaurant.getTableList().getTables()) { 
			AddTable(table, restaurant,kitchenPane); 
		}
		

		this.status = false;
	}

	public void AddTable(Table table, Restaurant restaurant,KitchenPane kitchenPane) {
		Button tableBtn = new Button(table.getTableNumber());
		tableBtn.getStyleClass().add(table.getClass().getSimpleName());

		tableBtn.setOnAction(e -> {
			if (table.getGuestAmount() <= 0) {
				new SeatingWindow(table, tableBtn);
			} else {
				new OrderWindow(table, tableBtn, restaurant, kitchenPane);
			}

		});
		add(tableBtn, table.getPosx(), table.getPosy());
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setGrid() {
		for (int i = 0; i < 6; i++) {
			getColumnConstraints().add(new ColumnConstraints(50));
		}

		for (int i = 0; i < 7; i++) {
			getRowConstraints().add(new RowConstraints(50));
		}
	}

}
