package logic;

import java.util.ArrayList;

public class Menus {
	private ArrayList<Menu> menus;

	public Menus() {
		menus = new ArrayList<Menu>();
	}

	public void addMenu(Menu menu) {
		menus.add(menu);
	}
}
