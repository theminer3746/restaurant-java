package logic;

import Table.Table;

public class Order implements Billable {
	private Menu menu;
	private Table table;
	private String status;
	private int amount;

	public Order(Menu menu, Table table) {
		this.menu = menu;
		this.table = table;
	}

	@Override
	public double getPrice() {
		return amount * menu.getPrice();
	}

	@Override
	public String getName() {
		return amount + " * " + menu.getName();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}