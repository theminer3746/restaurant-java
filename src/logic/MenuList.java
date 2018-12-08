package logic;

import java.util.ArrayList;

public class MenuList {
	private ArrayList<Menu> menus;

	public MenuList() {
		menus = new ArrayList<Menu>();
	}

	public void addMenu(Menu menu) {
		menus.add(menu);
	}
}
