package Table;

import Exception.NotEnoughSeatException;
import logic.Bill;
import logic.Billable;

public abstract class Table implements Billable {
	protected Bill bill;
	protected String tableNumber;
	protected int guestAmount;
	protected int maximumGuest;
	protected int posx;
	protected int posy;

	public Table(String tableNumber, int maximumGuest) {
		this.bill = new Bill();
		this.tableNumber = tableNumber;
		this.maximumGuest = maximumGuest;
	}

	public abstract String getName();

	public abstract double getPrice();

	public abstract double calculateServiceCharge(double bill);

	public double getTotal() {
		return bill.getBillableTotal() + getPrice();
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getGuestAmount() {
		return guestAmount;
	}

	public void setGuestAmount(int guestAmount) throws NotEnoughSeatException {
		if (guestAmount > maximumGuest) {
			throw new NotEnoughSeatException(maximumGuest);
		}

		this.guestAmount = guestAmount;
	}

	public int getMaximumGuest() {
		return maximumGuest;
	}

	public void setMaximumGuest(int maximumGuest) {
		this.maximumGuest = maximumGuest;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
}
