package pages;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import game.GameWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import utils.FileWriterHandler;

public class TopScorePageController implements Initializable{

	private GameWindow window;
	
	public TopScorePageController(GameWindow window) {
		this.window = window;
	}
	
	@FXML
	private TableView<Map.Entry<String, String>> scoreTable;
	
	@FXML
	public void back(ActionEvent event) {
		this.window.initWelcomePage();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.scoreTable.setEditable(false);
		
		try {
			FileWriterHandler fileHandler = new FileWriterHandler();
			Map<String, String> score = fileHandler.parse(fileHandler.read());
			
	        TableColumn<Map.Entry<String, String>, String> nameColumn = new TableColumn<>("Name");
	        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
	                return new SimpleStringProperty(p.getValue().getKey());
	            }
	        });

	        TableColumn<Map.Entry<String, String>, String> pointsColumn = new TableColumn<>("Value");
	        pointsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
	                return new SimpleStringProperty(p.getValue().getValue());
	            }
	        });

	        if(score != null) {
	        	ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(score.entrySet());
		        this.scoreTable.setItems(items);
	        }

	        this.scoreTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        this.scoreTable.getColumns().setAll(nameColumn, pointsColumn);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
