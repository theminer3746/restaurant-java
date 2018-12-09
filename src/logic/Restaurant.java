package logic;

import Table.TableList;

public class Restaurant {
	private static Restaurant instance;
	private TableList tableList;
	private MenuList menuList;
	
	private Restaurant() {
		tableList = TableList.getInstance();
		menuList = MenuList.getInstance();
	}
	
	public static Restaurant getInstance() {
		if(instance == null) {
			instance = new Restaurant();
		}
		
		return instance;
	}

	public TableList getTableList() {
		return tableList;
	}

	public void setTableList(TableList tableList) {
		this.tableList = tableList;
	}

	public MenuList getMenuList() {
		return menuList;
	}

	public void setMenuList(MenuList menuList) {
		this.menuList = menuList;
	}
}
