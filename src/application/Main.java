package application;

import application.Tabs;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.Restaurant;

public class Main extends Application {
	
	//define offset
	private double xOffset = 0;
	private double yOffset = 0;
	
	TableGrid tableGrid;
	KitchenPane kitchen;
	
	Restaurant restaurant;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		restaurant = Restaurant.getInstance();
		tableGrid = new TableGrid(restaurant.getTableList());
		kitchen = new KitchenPane();
		
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		
		VBox root = new VBox();
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
		});
		
		 root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	    });
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("Restaurant.css");
		root.setPadding(new Insets(5));
		root.setSpacing(5);
		root.setMinWidth(750);
		root.setMinHeight(400);
		
		Tabs tabs = new Tabs(root, tableGrid, kitchen);
		root.getChildren().addAll(tabs);
		
		primaryStage.setTitle("Restaurant");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
