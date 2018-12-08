package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Kitchen extends StackPane {
	private ObservableList<Label> logOrderList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	
	private boolean status;
	
	public Kitchen() {
		this.status = false;
		
		setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
			CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		logListView = new ListView<Label>(logOrderList);
		logListView.setPrefWidth(250);
		logListView.setFocusTraversable(false);
		logListView.setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		logListView.setPlaceholder(new Label("No Orders"));
		
		getChildren().add(logListView);
		
		/*Label newLabel = new Label("1");
		logOrderList.add(newLabel);
		logListView.scrollTo(newLabel);*/
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

}
