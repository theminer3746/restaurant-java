package application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Tabs extends HBox {
	
	public Tabs() {
		setSpacing(5);
		
		Button counterBtn = new Button("Counter");
		//counterBtn.getStyleClass().add("customButton");
		counterBtn.setOnAction(e -> {
			//tableGrid.setVisible(true);
			/////
		});
		
		Button kitchenBtn = new Button("Kitchen");
		kitchenBtn.setOnAction(e -> {
			//tableGrid.setVisible(false);
			/////
		});
		
		Button closeBtn = new Button("Close");
		closeBtn.setOnAction(e -> {
			System.exit(0);
		});
		
		getChildren().addAll(counterBtn, kitchenBtn, closeBtn);
	}

}
