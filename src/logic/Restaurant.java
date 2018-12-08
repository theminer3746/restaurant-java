package logic;

import Table.TableList;

public class Restaurant {
	private static Restaurant instance;
	private TableList tableList;
	
	private Restaurant() {
		tableList = TableList.getInstance();
	}
	
	public static Restaurant getInstance() {
		if(instance == null) {
			instance = new Restaurant();
		}
		
		return instance;
	}
}
