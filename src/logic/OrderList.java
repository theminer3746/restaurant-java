package logic;

import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orders;
	
	public OrderList() {
		this.orders = new ArrayList<Order>();
	}

	public void addToOrders(Order order) {
		this.orders.add(order);
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
