package logic;

public class Kitchen {
	private OrderList orderList;
	private static Kitchen instance;

	private Kitchen() {
		this.orderList = new OrderList();
	}

	public static Kitchen getInstance() {
		if (instance == null) {
			instance = new Kitchen();
		}

		return instance;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}
}
