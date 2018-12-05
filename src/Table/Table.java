package Table;

import java.util.ArrayList;

import logic.Billable;

public abstract class Table implements Billable {
	protected ArrayList<Billable> billable;
	protected int guestAmount;
	
	public double getBillableTotal() {
		double total = 0;
		
		for(Billable item : this.billable) {
			total += item.getPrice();
		}
		
		return total;
	}
		total += getPrice();
		
		return total;
	}
	
	/**
	 * Get service charge for table
	 */
	public abstract double getPrice();

	public abstract String getName();
}
