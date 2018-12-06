package logic;

import java.util.ArrayList;

public class Bill {
	private ArrayList<Billable> billable;

	public void addToBill(Billable billable) {
		this.billable.add(billable);
	}

	public double getBillableTotal() {
		double total = 0;

		for (Billable item : this.billable) {
			total += item.getPrice();
		}

		return total;
	}
}
