package application;

import java.text.NumberFormat;

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

	private ListView<Label> logServedView;

	public CheckWindow(Table table, Button tableBtn, Stage stage, TableGrid tableGrid, KitchenPane kitchenPane,
			Restaurant restaurant) {

		VBox checkWindow = new VBox();
		Scene checkScene = new Scene(checkWindow);
		checkScene.getStylesheets().add("Restaurant.css");
		checkWindow.setSpacing(5);
		checkWindow.setPadding(new Insets(5));
		checkWindow.setAlignment(Pos.CENTER_RIGHT);

		logServedView = new ListView<Label>(table.getServedOrderList());
		// logServedView.setPrefWidth(250);
		logServedView.setFocusTraversable(false);
		logServedView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		logServedView.setPlaceholder(new Label("No Order"));
		logServedView.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		Label serviceCharge = new Label(
				"Service Charge : " + table.getFormattedServiceCharge(table.getBillableTotal()));

		Label total = new Label("Total : " + table.getFormattedTotal());

		Label receivelabel = new Label("Receive Total");
		TextField receive = new TextField();
		receive.setPromptText("Receive Total :");
		HBox payment = new HBox();
		payment.setSpacing(5);
		payment.setAlignment(Pos.CENTER_RIGHT);
		payment.getChildren().addAll(receivelabel, receive);

		Button confirm = new Button("Confirm");
		confirm.setOnMouseClicked(e2 -> {
			try {
				double amount = Double.parseDouble(receive.getText());
				if (amount <= 0) {
					Notify notify = new Notify(AlertType.ERROR);
					notify.showNegativePaymentAmountError();

				} else if (amount < table.getBillableTotal()) {
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
					/*Label change = new Label("Change is " + NumberFormat.getInstance()
							.format((amount - Double.parseDouble(table.getFormattedTotal()))));*/
					Label change = new Label("Change is " + NumberFormat.getInstance().format(amount - table.getTotal()));
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
				if (receive.getText().isEmpty()) {
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
		checkWindow.getChildren().addAll(logServedView, serviceCharge, total, payment, confirm, cancel);

		setTitle("Check");
		setScene(checkScene);
		show();
	}
}