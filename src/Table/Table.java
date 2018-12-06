package Table;

import java.util.ArrayList;

import Exception.NotEnoughSeatException;
import logic.Billable;

public abstract class Table implements Billable {
	protected ArrayList<Billable> billable;
	protected int guestAmount;
	protected int maximumGuest;
	
	public double getBillableTotal() {
		double total = 0;
		
		for(Billable item : this.billable) {
			total += item.getPrice();
		}
		
		return total;
	}
	
	public double getTotal() {
		double total = 0;
		
		total += getBillableTotal();
		
		total += getPrice();
		
		return total;
	}
	
	/**
	 * Get service charge for table
	 */
	public abstract double getPrice();

	public abstract String getName();

	public int getGuestAmount() {
		return guestAmount;
	}

	public void setGuestAmount(int guestAmount) throws NotEnoughSeatException {
		if(guestAmount > maximumGuest) {
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
