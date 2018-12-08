package application;

import Exception.NotEnoughSeatException;
import Table.NormalTable;
import Table.PrivateTable;
import Table.Table;
//import logic.RestaurantManagement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TableGrid extends GridPane {

	boolean status;

	public TableGrid() {
		setHgap(5);
		setVgap(5);
		setMinSize(300, 500);
		setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));

		AddTable(new NormalTable("6", 6), 0, 0);
		AddTable(new PrivateTable("7", 8), 2, 2);

		/*
		 * for (Table table : tables) { ///go through tables arraylist and add new
		 * tableBtn }
		 */

		this.status = false;
	}

	public void AddTable(Table table, int xPos, int yPos) {
		Button tableBtn = new Button(table.getTableNumber());

		if (table instanceof NormalTable) {
			tableBtn.getStyleClass().add(table.getClass().getSimpleName());

		} else if (table instanceof PrivateTable) {
			tableBtn.getStyleClass().add(table.getClass().getSimpleName());

		} else {
			tableBtn.getStyleClass().add(table.getClass().getSimpleName());

		}
		tableBtn.setOnAction(e -> {
			if (table.getGuestAmount() <= 0) {
				Stage stage = new Stage();
				VBox pane = new VBox();
				pane.setMinWidth(250);
				pane.setAlignment(Pos.TOP_CENTER);
				pane.setPadding(new Insets(5));
				pane.setSpacing(5);
				Scene scene = new Scene(pane);

				Label label = new Label("Please Input Customer's Amount");
				TextField text = new TextField();
				text.setPromptText("customer(s)");

				HBox btns = new HBox();
				btns.setSpacing(5);
				btns.setAlignment(Pos.CENTER_RIGHT);
				Button confirm = new Button("Confirm");
				confirm.setOnAction(i -> {
					try {
						int amount = Integer.parseInt(text.getText());
						if (amount <= 0) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error");
							alert.setHeaderText("Error");
							alert.setContentText("The Amount Of Customers Must be Positive");
							alert.show();
						} else {
							table.setGuestAmount(amount);
							tableBtn.getStyleClass().clear();
							tableBtn.getStyleClass().add("Seated" + table.getClass().getSimpleName());
							stage.close();

						}
					} catch (NumberFormatException e1) {
						if (text.getText().isEmpty()) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Message");
							alert.setHeaderText("Message");
							alert.setContentText("Please Fill In Customer Amount");
							alert.show();
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error");
							alert.setHeaderText("Error");
							alert.setContentText("Incorrect Amount Format");
							alert.show();
						}
					} catch (NotEnoughSeatException e1) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Error");
						alert.setContentText("The Amount Of Customers Exceed The Available Seats");
						alert.show();
					}
				});
				Button cancel = new Button("Cancel");
				cancel.setOnAction(i -> {
					stage.close();
				});
				btns.getChildren().addAll(confirm, cancel);

				pane.getChildren().addAll(label, text, btns);
				stage.setTitle("Seating");
				stage.setScene(scene);
				stage.show();
			} else {
				Stage stage = new Stage();
				VBox orderWindow = new VBox();
				orderWindow.setMinWidth(250);
				orderWindow.setAlignment(Pos.TOP_CENTER);
				orderWindow.setPadding(new Insets(5));
				orderWindow.setSpacing(5);
				Scene scene = new Scene(orderWindow);

				Label label = new Label("Menu List");
				orderWindow.getChildren().add(label);
				orderWindow.getChildren().add(new OrderInput(table, "Dimsum")); /////
				/*
				 * for (all menu list) { orderWindow.getChildren().add(new OrderInput(menu's
				 * name); }
				 */
				if (table.getBill().getBillableTotal() != 0) {
					Button check = new Button("Check");
					check.setOnMouseClicked(e1 -> {
						Stage checkStage = new Stage();

					});
				}

				Button close = new Button("Close");
				close.setOnAction(e1 -> {
					stage.close();
				});
				orderWindow.getChildren().add(close);
				stage.setTitle("Order(s)");
				stage.setScene(scene);
				stage.show();
			}

		});
		add(tableBtn, xPos, yPos);
	}

	/*
	 * public void seated(Button tableBtn, String tableType) { if (tableType == "")
	 * { tableBtn.getStyleClass().add("SeatedNormalTable"); } }
	 */

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
