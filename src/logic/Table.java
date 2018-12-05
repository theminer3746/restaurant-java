package logic;

import java.util.ArrayList;

public abstract class Table implements Billable {
	protected ArrayList<Billable> billable;
	protected int guestAmount;
	
	public abstract float getServiceCharge(); 
	
	public float getTotal() {
		float total = 0;
		
		for(Billable item : this.billable) {
			total += item.getPrice();
		}
		
		total += getServiceCharge();
		
		return total;
	}
	
	public abstract float getPrice();

	public abstract String getName();
}
