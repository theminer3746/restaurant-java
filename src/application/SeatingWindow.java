package application;

import Exception.NotEnoughSeatException;
import Table.Table;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeatingWindow extends Stage {
	public SeatingWindow(Table table, Button tableBtn) {
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
					close();

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
			close();
		});
		btns.getChildren().addAll(confirm, cancel);

		pane.getChildren().addAll(label, text, btns);
		setTitle("Seating");
		setScene(scene);
		show();
	}
}
