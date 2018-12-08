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

	public void showNegativeCustomerAmountError() {
		this.setTitle("Error").setHeaderText("Error")
				.setContentText("The Amount Of Customers Must be Positive").show();
	}
	
	public void showEmptyCustomerTextFieldError() {
		this.setTitle("Message").setHeaderText("Message")
				.setContentText("Please Fill In Customer(s) Amount").show();
	}
	
	public void showIncorrectCustomerAmountFormatError() {
		this.setTitle("Error").setHeaderText("Error")
				.setContentText("Incorrect Amount Format").show();
	}

	public void showGuestExceedCapacity(int maximumSeat) {
		this.setTitle("Error").setHeaderText("Error")
				.setContentText("The Amount Of Customers Exceed The Available Seats (" + maximumSeat + ")").show();
	}
	
	public void showNegativeQuantityError() {
		this.setTitle("Error").setHeaderText("Error")
				.setContentText("The Quantity Must be Positive").show();
	}
	
	public void showEmptyQuantityTextFieldError() {
		this.setTitle("Message").setHeaderText("Message")
				.setContentText("Please Fill In Order's Amount").show();
	}
	
	public void showIncorrectQuantityFormatError() {
		this.setTitle("Error").setHeaderText("Error")
				.setContentText("Incorrect Quantity Format").show();
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
