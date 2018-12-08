package application;

import Exception.NotEnoughSeatException;
import Table.NormalTable;
import Table.PrivateTable;
import Table.Table;
import Table.TableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TableGrid extends GridPane {

	boolean status;

	public TableGrid(TableList tableList) {
		setGrid();
		/*
		 * setHgap(5); setVgap(5);
		 */
		setMinSize(300, 350);
		setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));

		Table normalTable = new NormalTable("6", 6);
		normalTable.setPosx(0);
		normalTable.setPosy(0);
		Table privateTable = new PrivateTable("10", 8);
		privateTable.setPosx(0);
		privateTable.setPosy(2);
		AddTable(normalTable);
		AddTable(privateTable);

		/// check after josn file implemented
		/*for (Table table : tableList.getTables()) {
			AddTable(table);
		}*/
		

		this.status = false;
	}

	public void AddTable(Table table) {
		Button tableBtn = new Button(table.getTableNumber());
		tableBtn.getStyleClass().add(table.getClass().getSimpleName());
		
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
							Notify notify = new Notify(AlertType.ERROR);
							notify.showNegativeCustomerAmountError();
							
						} else {
							table.setGuestAmount(amount);
							tableBtn.getStyleClass().clear();
							tableBtn.getStyleClass().add("Seated" + table.getClass().getSimpleName());
							stage.close();

						}
					} catch (NumberFormatException e1) {
						if (text.getText().isEmpty()) {
							Notify notify = new Notify(AlertType.ERROR);
							notify.showEmptyCustomerTextFieldError();
							
						} else {
							Notify notify = new Notify(AlertType.ERROR);
							notify.showIncorrectCustomerAmountFormatError();
						}
					} catch (NotEnoughSeatException e1) {
						Notify notify = new Notify(AlertType.ERROR);
						notify.showGuestExceedCapacity(e1.getMaxSeat());
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
						VBox checkWindow = new VBox();
						Scene checkScene = new Scene(checkWindow);
						checkWindow.setSpacing(5);
						checkWindow.setPadding(new Insets(5));
						checkWindow.setAlignment(Pos.CENTER_LEFT);
						
						/*
						 * 
						 */
						
						checkStage.setTitle("Check");
						checkStage.setScene(checkScene);
						checkStage.show();
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
		add(tableBtn, table.getPosx(), table.getPosy());
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setGrid() {
		for (int i = 0; i < 8; i++) {
			getColumnConstraints().add(new ColumnConstraints(40));
		}
		
		for (int i = 0; i < 9; i++) {
			getRowConstraints().add(new RowConstraints(40));
		}
	}

}
