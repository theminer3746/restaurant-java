package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Billable;

public class KitchenPane extends VBox {
	private ObservableList<Label> logOrderList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	
	private boolean status;
	
	private ArrayList<Billable> billable;
	
	public KitchenPane() {
		billable = new ArrayList<Billable>();
		this.status = false;
		setAlignment(Pos.CENTER_RIGHT);
		setSpacing(5);
		
		/*setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
			CornerRadii.EMPTY, BorderWidths.DEFAULT)));*/
		
		logListView = new ListView<Label>(logOrderList);
		logListView.setPrefWidth(250);
		logListView.setFocusTraversable(false);
		logListView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		logListView.setPlaceholder(new Label("No Orders"));
		logListView.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Button serve = new Button("Serve");
		serve.setOnMouseClicked(e -> {
			if (!logOrderList.isEmpty()) {
				logOrderList.remove(0);
				//// serve the menu
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText("There Are No Order");
				alert.show();
			}
		});
		
		getChildren().addAll(logListView,serve);
		
		Label newLabel = new Label("1");
		logOrderList.add(newLabel);
		logListView.scrollTo(newLabel);
		
		Label newLabel2 = new Label("2");
		logOrderList.add(newLabel);
		logListView.scrollTo(newLabel);
		
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void addToBill(Billable billable) {
		this.billable.add(billable);
	}

}
