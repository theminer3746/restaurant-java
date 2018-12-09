package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Restaurant;

public class KitchenPane extends VBox {
	private ObservableList<Label> logOrderList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	
	private boolean status;
	
	public KitchenPane(Restaurant restaurant) {
		setAlignment(Pos.CENTER_RIGHT);
		setSpacing(5);
		
		logListView = new ListView<Label>(logOrderList);
		logListView.setPrefWidth(250);
		logListView.setFocusTraversable(false);
		logListView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		logListView.setPlaceholder(new Label("No Orders"));
		logListView.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		HBox serveTab = new HBox();
		serveTab.setSpacing(5);
		serveTab.setAlignment(Pos.CENTER_RIGHT);
		Button serveBtn = new Button("Serve");
		TextField servePos = new TextField();
		servePos.setPromptText("Serve Order Number");
		serveBtn.setOnMouseClicked(e -> {
			
			if (!logOrderList.isEmpty()) {
				try {
					int pos = Integer.parseInt(servePos.getText());
					if (pos <= 0) {
						Notify notify = new Notify(AlertType.ERROR);
						notify.showNegativeServePosError();
						
					} else if (pos > logOrderList.size()) {
						Notify notify = new Notify(AlertType.ERROR);
						notify.showExceedServePosError();
					} else {
						logOrderList.remove(pos - 1);
						restaurant.serve(pos);
					}
				} catch (NumberFormatException e1) {
					if (servePos.getText().isEmpty()) {
						Notify notify = new Notify(AlertType.ERROR);
						notify.showEmptyServePosTextFieldError();

					} else {
						Notify notify = new Notify(AlertType.ERROR);
						notify.showIncorrectServePosFormatError();
					}
				}
			} else {
				Notify notify = new Notify(AlertType.ERROR);
				notify.showEmptyOrderError();
			}
		});
		serveTab.getChildren().addAll(servePos, serveBtn);
		
		getChildren().addAll(logListView, serveTab);
		
		/*Label newLabel = new Label("1");
		logOrderList.add(newLabel);
		
		Label newLabel2 = new Label("2");
		logOrderList.add(newLabel2);*/
		
		this.status = false;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void order(Label label) {
		getLog().add(label);
	}
	
	public ObservableList<Label> getLog() {
		return this.logOrderList;
	}
}
