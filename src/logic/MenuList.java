package logic;

import java.util.ArrayList;

public class MenuList {
	private static MenuList instance;
	private ArrayList<Menu> menus;

	public MenuList() {
		menus = new ArrayList<Menu>();
		populateMenuList();
	}

	public static MenuList getInstance() {
		if (instance == null) {
			instance = new MenuList();
		}

		return instance;
	}

	private void populateMenuList() {
		menus.add(new Menu("Stuffed mushroom", 185));
		menus.add(new Menu("Carbonara spaghetti", 150));
		menus.add(new Menu("Seafood Trio spaghetti", 180));
		menus.add(new Menu("Hawaiian pizza", 200));
		menus.add(new Menu("Supreme pizza", 200));
		menus.add(new Menu("Lobster ravioli", 195));
		menus.add(new Menu("Mac N'Cheese", 145));
		menus.add(new Menu("Meatball", 175));
		menus.add(new Menu("Caesar Salad", 80));
		menus.add(new Menu("Greek Salad", 80));
	}

	public void addMenu(Menu menu) {
		menus.add(menu);
	}

	public ArrayList<Menu> getMenus() {
		return menus;
	}

	public void setMenus(ArrayList<Menu> menus) {
		this.menus = menus;
	}
}
