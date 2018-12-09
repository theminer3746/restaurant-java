package logic;

import java.util.ArrayList;

public class MenuList {
	private static MenuList instance;
	private ArrayList<Menu> menus;
	
	public MenuList() {
		menus = new ArrayList<Menu>();
	}

	public static MenuList getInstance() {
		if(instance == null) {
			instance = new MenuList();
		}
		
		return instance;
	}
	
	public void addMenu(Menu menu) {
		menus.add(menu);
	}
}
