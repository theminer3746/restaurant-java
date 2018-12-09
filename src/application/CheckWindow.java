package application;

import Exception.NotEnoughSeatException;
import Table.Table;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Bill;
import logic.Restaurant;

public class CheckWindow extends Stage {

	private ListView<Label> logListView;

	public CheckWindow(Table table, Button tableBtn, Stage stage,
			TableGrid tableGrid, KitchenPane kitchenPane, Restaurant restaurant) {
		
		VBox checkWindow = new VBox();
		Scene checkScene = new Scene(checkWindow);
		checkScene.getStylesheets().add("Restaurant.css");
		checkWindow.setSpacing(5);
		checkWindow.setPadding(new Insets(5));
		checkWindow.setAlignment(Pos.CENTER_RIGHT);

		logListView = new ListView<Label>(table.getServedOrderList());
		logListView.setPrefWidth(250);
		logListView.setFocusTraversable(false);
		logListView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		logListView.setPlaceholder(new Label("No Orders"));
		logListView.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		Label serviceCharge = new Label(
				"Service Charge : " + table.getFormattedServiceCharge(table.getBillableTotal()));

		Label total = new Label("Total : " + table.getFormattedTotal());
		
		Label recievelabel = new Label("Recieve Total");
		TextField recieve = new TextField();
		recieve.setPromptText("Recieve Total :");
		HBox payment = new HBox();
		payment.setAlignment(Pos.CENTER_RIGHT);
		payment.setSpacing(5);
		payment.getChildren().addAll(recievelabel, recieve);

		Button confirm = new Button("Confirm");
		confirm.setOnMouseClicked(e2 -> {
			try {
				double amount = Double.parseDouble(recieve.getText());
				if (amount <= 0) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showNegativePaymentAmountError();
					
				} else if (amount < Double.parseDouble(table.getFormattedTotal())) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showNotEnoughPaymentAmountError();
					
				} else {
					
						Stage confirmationStage = new Stage();
						VBox confirmationBox = new VBox();
						confirmationBox.setPrefWidth(150);
						confirmationBox.setSpacing(5);
						confirmationBox.setPadding(new Insets(5));
						Scene confirmScene = new Scene(confirmationBox);
						confirmationBox.setAlignment(Pos.CENTER);
						Label change = new Label("Change is " + (amount - Double.parseDouble(table.getFormattedTotal())));
						Button close = new Button("Close");
						close.setOnMouseClicked(e4 -> {
							try {
								table.setBill(new Bill());
								table.setGuestAmount(0);
								tableGrid.getChildren().remove(tableBtn);
								tableGrid.AddTable(table, restaurant, kitchenPane);
								table.getServedOrderList().clear();
								confirmationStage.close();
								this.close();
								stage.close();
							} catch (NotEnoughSeatException e) {
								e.printStackTrace();
							}
						});
						confirmationBox.getChildren().addAll(change, close);
						confirmationStage.setTitle("Confirm Change");
						confirmationStage.setScene(confirmScene);
						confirmationStage.show();
					
				}
			} catch (NumberFormatException e4) {
				if (recieve.getText().isEmpty()) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showEmptyPaymentTextFieldError();

				} else {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showIncorrectPaymentAmountFormatError();
				}
			}

		});
		Button cancel = new Button("Cancel");
		cancel.setOnMouseClicked(e2 -> {
			close();
		});
		checkWindow.getChildren().addAll(logListView, serviceCharge, total, payment, confirm, cancel);

		setTitle("Check");
		setScene(checkScene);
		show();
	}

	public void setCSS(Button tableBtn, Table table) {
		tableBtn.getStyleClass().clear();
		tableBtn.getStyleClass().add(table.getClass().getSimpleName());
	}

}