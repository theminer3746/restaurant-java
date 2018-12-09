package application;

import Exception.NotEnoughSeatException;
import Table.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Bill;

public class CheckWindow extends Stage {
	
	//private ObservableList<Label> logOrdersList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	
	public CheckWindow(Table table, Button tableBtn, Stage stage, ObservableList<Label> logServeList) {
		VBox checkWindow = new VBox();
		Scene checkScene = new Scene(checkWindow);
		checkWindow.setSpacing(5);
		checkWindow.setPadding(new Insets(5));
		checkWindow.setAlignment(Pos.CENTER_RIGHT);

		logListView = new ListView<Label>(logServeList);
		logListView.setPrefWidth(250);
		logListView.setFocusTraversable(false);
		logListView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		logListView.setPlaceholder(new Label("No Orders"));
		logListView.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		/*
		 * 
		 */
		
		Label serviceCharge = new Label("Service Charge : " + table.calculateServiceCharge(table.getTotal()));
		
		Label total = new Label("Total : " + (table.calculateServiceCharge(table.getTotal()) + table.getTotal()));
		
		Button confirm = new Button("Confirm");
		confirm.setOnMouseClicked(e2 -> {
			try {
				table.setBill(new Bill());
				table.setGuestAmount(0);
				tableBtn.getStyleClass().clear();
				tableBtn.getStyleClass().add(table.getClass().getSimpleName());
				logServeList.clear();
				close();
				stage.close();
			} catch (NotEnoughSeatException e3) {
				
			}
			
		});
		Button cancel = new Button("Cancel");
		cancel.setOnMouseClicked(e2 -> {
			
		});
		checkWindow.getChildren().addAll(logListView, serviceCharge, total, confirm);

		setTitle("Check");
		setScene(checkScene);
		show();
	}
	
	/*public void addOrder(Label label) {
		logOrdersList.add(label);
	}*/

}
