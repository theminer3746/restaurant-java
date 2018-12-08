package Exception;

public class NotEnoughSeatException extends Exception {

	private int maxSeat;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 212634037099705829L;

	public NotEnoughSeatException() {
		super();
	}
	
	public NotEnoughSeatException(int maxSeat) {
		super();
		this.maxSeat = maxSeat;
	}

	public int getMaxSeat() {
		return maxSeat;
	}

	public void setMaxSeat(int maxSeat) {
		this.maxSeat = maxSeat;
	}
	
}
