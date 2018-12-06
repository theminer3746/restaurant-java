package application;

//import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TableGrid extends GridPane {
	//private ArrayList<Button> TableList;
	
	public TableGrid() {
		setHgap(5);
		setVgap(5);
		setMinSize(100, 100);
		
		AddTable("normal");
		
		//TableList = new ArrayList<Button>();
		// read text "table" file 
		/*for (Object e : TableList) {
			/* int x_pos = e.getXpos();
			 * int y_pos = e.getYpos();
			 * if (e.isOccupied()) {
			 * 	// 
			 * }
			 
		}*/
		
		setVisible(false);
		
		
	}
	
	public void AddTable(String tableType/* Table table*/) {
		Button tableBtn = new Button();
		
		if (tableType == "normal" /*table.getName() == "normal*/ ) {
			tableBtn.getStyleClass().add("normalTable");
			
		} else if (tableType == "private") {
			tableBtn.getStyleClass().add("privateTable");
			
		} else {
			tableBtn.getStyleClass().add("Table");
			
		}
		/*tableBtn.setOnAction(e -> {
			Stage stage = new Stage();
			
		});*/
		//TableList.add(tableBtn);
		add(tableBtn, 0, 0);
	}
	
	public void seated(Button table) {
		table.setStyle(
				"-fx-background-color: red");
	}
	
	public void setBackGround(GraphicsContext gc) {
		gc.setFill(javafx.scene.paint.Color.BLUE);
		gc.fillRect(0, 0, 250, 400);
	}

}
