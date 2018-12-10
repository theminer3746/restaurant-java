package Table;

import java.text.NumberFormat;

import Exception.NotEnoughSeatException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import logic.Bill;
import logic.Billable;

public abstract class Table implements Billable {
	private ObservableList<Label> ServedOrderList;
	protected Bill bill;
	protected String tableNumber;
	protected int guestAmount;
	protected int maximumGuest;
	protected int posx;
	protected int posy;
	private NumberFormat numberFormat;

	public Table(String tableNumber, int maximumGuest, int posx, int posy) {
		this.bill = new Bill();
		this.tableNumber = tableNumber;
		this.maximumGuest = maximumGuest;
		this.posx = posx;
		this.posy = posy;
		this.numberFormat = NumberFormat.getInstance();
		this.ServedOrderList = FXCollections.observableArrayList();
	}

	public Table() {
		this.bill = new Bill();
	}

	public abstract String getName();

	public abstract double getPrice();

	public String getFormattedPrice() {
		return numberFormat.format(getPrice());
	}

	public abstract double calculateServiceCharge(double bill);
	
	public String getFormattedServiceCharge(double bill) {
		return numberFormat.format(calculateServiceCharge(bill));
	}

	public double getTotal() {
		return bill.getBillableTotal() + getPrice();
	}

	public String getFormattedTotal() {
		return numberFormat.format(getTotal());
	}

	public double getBillableTotal() {
		return bill.getBillableTotal();
	}

	public String getFormattedBillableTotal() {
		return numberFormat.format(getBillableTotal());
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
	
	public ObservableList<Label> getServedOrderList() {
		return this.ServedOrderList;
	}
	
	public void addServedOrder(Label lebel) {
		this.ServedOrderList.add(lebel);
	}
}
