package Table;

import java.util.ArrayList;

public class TableList {
	private static TableList instance;
	private ArrayList<Table> tables;

	private TableList() {
		tables = new ArrayList<Table>();
		populateTableData();
	}

	public static TableList getInstance() {
		if (instance == null) {
			instance = new TableList();
		}

		return instance;
	}

	private void populateTableData() {
		tables.add(new NormalTable("01A", 4, 0, 0));
		tables.add(new NormalTable("02A", 6, 1, 0));
		tables.add(new NormalTable("03A", 4, 2, 0));
		tables.add(new NormalTable("04A", 4, 3, 0));
		tables.add(new NormalTable("05A", 4, 4, 0));
		tables.add(new NormalTable("06A", 8, 0, 1));
		tables.add(new NormalTable("07A", 2, 1, 1));
		tables.add(new NormalTable("08A", 2, 2, 1));
		tables.add(new NormalTable("09A", 4, 3, 1));
		tables.add(new NormalTable("10A", 4, 4, 1));

		tables.add(new PrivateTable("01B", 10, 1, 3));
		tables.add(new PrivateTable("02B", 10, 3, 3));
	}

	public void addTableToList(Table table) {
		this.tables.add(table);
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}
}
