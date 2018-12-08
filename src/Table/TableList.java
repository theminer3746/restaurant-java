package Table;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import jdk.nashorn.internal.parser.JSONParser;

public class TableList {
	private static TableList instance;
	private ArrayList<Table> tables;
	
	private TableList() {
		populateTableData();
	}
	
	public static TableList getInstance() {
		if(instance == null) {
			instance = new TableList();
		}
		
		return instance;
	}
	
	private void populateTableData() {
		//JSONArray arr = new JSONArray();
		
		try {
			String uri = ClassLoader.getSystemResource("tables.json").toString();
			FileReader fileReader = new FileReader(uri);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addTableToList(Table table) {
		//TODO
		this.tables.add(table);
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}
}
