package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Notify {
	private Alert alert;

	public Notify() {
	}

	public Notify(Alert.AlertType alertType) {
		alert = new Alert(AlertType.ERROR);
	}

	///// Customer ERROR
	public void showNegativeCustomerAmountError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("The Amount Of Customers Must Be Positive").show();
	}

	public void showEmptyCustomerTextFieldError() {
		this.setTitle("Message").setHeaderText("Message").setContentText("Please Fill In Customer(s) Amount").show();
	}

	public void showIncorrectCustomerAmountFormatError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("Incorrect Amount Format").show();
	}

	public void showGuestExceedCapacity(int maximumSeat) {
		this.setTitle("Error").setHeaderText("Error")
				.setContentText("The Amount Of Customers Exceed The Available Seats (" + maximumSeat + ")").show();
	}

	///// Order ERROR
	public void showNegativeQuantityError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("The Quantity Must Be Positive").show();
	}

	public void showEmptyQuantityTextFieldError() {
		this.setTitle("Message").setHeaderText("Message").setContentText("Please Fill In Order's Amount").show();
	}

	public void showIncorrectQuantityFormatError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("Incorrect Quantity Format").show();
	}

	///// Kitchen Pane ERROR
	public void showEmptyOrderError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("There Is No Order").show();
	}

	public void showNegativeServePosError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("The Order's Number Must Be Positive").show();
	}

	public void showExceedServePosError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("The Order's Number Must Be In Orders' Range")
				.show();
	}

	public void showEmptyServePosTextFieldError() {
		this.setTitle("Message").setHeaderText("Message").setContentText("Please Fill In Order's Number").show();
	}

	public void showIncorrectServePosFormatError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("Incorrect Order's Number Format").show();
	}
	
	///// Check ERROR
	public void showNegativePaymentAmountError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("The Payment Must Be Positive").show();
	}
	
	public void showNotEnoughPaymentAmountError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("The Payment Is Less Than Total Price").show();
	}

	public void showEmptyPaymentTextFieldError() {
		this.setTitle("Message").setHeaderText("Message").setContentText("Please Fill In Payment Amount").show();
	}

	public void showIncorrectPaymentAmountFormatError() {
		this.setTitle("Error").setHeaderText("Error").setContentText("Incorrect Payment Format").show();
	}

	public Notify setTitle(String title) {
		alert.setTitle(title);

		return this;
	}

	public Notify setHeaderText(String header) {
		alert.setHeaderText(header);

		return this;
	}

	public Notify setContentText(String context) {
		alert.setContentText(context);

		return this;
	}

	public void show() {
		alert.show();
	}
}
