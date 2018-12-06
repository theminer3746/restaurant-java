package Table;

public class NormalTable extends Table {
	private final double SERVICE_CHARGE_RATE = 0.05;

	@Override
	public double getPrice() {
		return bill.getBillableTotal() * SERVICE_CHARGE_RATE;
	}

	@Override
	public String getName() {
		return "Normal Table Service Charge";
	}

}
