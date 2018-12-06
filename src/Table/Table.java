package Table;

import Exception.NotEnoughSeatException;
import logic.Bill;
import logic.Billable;

public abstract class Table implements Billable {
	protected Bill bill;
	protected int guestAmount;
	protected int maximumGuest;

	public Table() {
		this.bill = new Bill();
	}

	public Table(Bill bill) {
		this.bill = bill;
	}

	public abstract String getName();

	public abstract double getPrice();

	public abstract double calculateServiceCharge(double bill);
	
	public double getTotal() {
		return bill.getBillableTotal() + getPrice();
	}

	public int getGuestAmount() {
		return guestAmount;
	}

	public void setGuestAmount(int guestAmount) throws NotEnoughSeatException {
		if (guestAmount > maximumGuest) {
			throw new NotEnoughSeatException();
		}

		this.guestAmount = guestAmount;
	}

	public int getMaximumGuest() {
		return maximumGuest;
	}

	public void setMaximumGuest(int maximumGuest) {
		this.maximumGuest = maximumGuest;
	}
}
