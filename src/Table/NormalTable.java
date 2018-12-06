package Table;

public class NormalTable extends Table {
	private final double SERVICE_CHARGE_RATE = 0.05;
	protected int maximumGuest = 6;
	
	@Override
	public double getPrice() {
		return getBillableTotal() * SERVICE_CHARGE_RATE;
	}

	@Override
	public String getName() {
		return "Normal Table Service Charge";
	}

}
