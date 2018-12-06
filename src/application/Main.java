package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		Scene scene = new Scene(root);
		//scene.getStylesheets().add("ProgMeth.css");
		root.setPadding(new Insets(5));
		root.setSpacing(5);
		root.setMinWidth(250);
		root.setMinHeight(400);
		
		primaryStage.setTitle("Restaurant");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
