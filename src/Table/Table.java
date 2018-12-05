package Table;

import java.util.ArrayList;

import logic.Billable;

public abstract class Table implements Billable {
	protected ArrayList<Billable> billable;
	protected int guestAmount;
	
	public float getTotal() {
		float total = 0;
		
		for(Billable item : this.billable) {
			total += item.getPrice();
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
