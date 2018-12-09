package Table;

public class PrivateTable extends Table {
	private final double SERVICE_CHARGE_RATE = 0.07;

	public PrivateTable(String tableNumber, int maximumGuest, int posx, int posy) {
		super(tableNumber, maximumGuest, posx, posy);
	}
	
	public PrivateTable() {
		super();
	}

	@Override
	public double calculateServiceCharge(double price) {
		return this.guestAmount * SERVICE_CHARGE_RATE * price;
	}
	
	@Override
	public double getPrice() {
		return this.guestAmount * SERVICE_CHARGE_RATE * bill.getBillableTotal();
	}

	@Override
	public String getName() {
		return "Private Table Service Charge";
	}

}
