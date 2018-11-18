package game;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import utils.FileWriterHandler;

public class TopScorePageController implements Initializable{

	@FXML
	private TableView<Map.Entry<String, String>> scoreTable;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.scoreTable.setEditable(false);
		
		try {
			FileWriterHandler fileHandler = new FileWriterHandler();
			Map<String, String> score = fileHandler.parse(fileHandler.read());
			
			
	        // use fully detailed type for Map.Entry<String, String> 
	        TableColumn<Map.Entry<String, String>, String> nameColumn = new TableColumn<>("Name");
	        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
	                // this callback returns property for just one cell, you can't use a loop here
	                // for first column we use key
	                return new SimpleStringProperty(p.getValue().getKey());
	            }
	        });

	        TableColumn<Map.Entry<String, String>, String> pointsColumn = new TableColumn<>("Value");
	        pointsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
	                // for second column we use value
	                return new SimpleStringProperty(p.getValue().getValue());
	            }
	        });

	        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(score.entrySet());
	       /* final TableView<Map.Entry<String,String>> table = new TableView<>(items);
*/
	        this.scoreTable.setItems(items);
	        this.scoreTable.getColumns().setAll(nameColumn, pointsColumn);
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

		
		
		
		

		
		//this.scoreTable.getColumns().addAll(nameColumn, pointColumn);
		//this.scoreTable.setItems(value);
	}

}
