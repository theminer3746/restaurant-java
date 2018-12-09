package Table;

public class NormalTable extends Table {
	private final double SERVICE_CHARGE_RATE = 0.05;

	public NormalTable(String tableNumber, int maximumGuest, int posx, int posy) {
		super(tableNumber, maximumGuest, posx, posy);
	}

	public NormalTable() {
		super();
	}
	
	@Override
	public double calculateServiceCharge(double price) {
		return price * SERVICE_CHARGE_RATE;
	}

	@Override
	public double getPrice() {
		return bill.getBillableTotal() * SERVICE_CHARGE_RATE;
	}

	@Override
	public String getName() {
		return "Normal Table Service Charge";
	}

}
