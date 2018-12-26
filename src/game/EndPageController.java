package game;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.FileWriterHandler;

public class EndPageController implements Initializable{
	
	private GameWindow window;
	private GameLoop loop;
	
	
	@FXML
	private Label scoreLabel;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private TextField nameInput;
	
	
	public EndPageController(GameWindow window, GameLoop loop) {
		this.window = window;
		this.loop = loop;
	}
	
	@FXML
	public void saveScore(ActionEvent event) {
		if(nameInput.getText().isEmpty()) {return;}
		
		FileWriterHandler fileHandler = new FileWriterHandler();
		
		String content = fileHandler.read();
		if(!content.isEmpty() && content != "") {
			Map<String, String> scores = fileHandler.parse(fileHandler.read());
			if(scores != null) {
				for(Map.Entry<String, String> score : scores.entrySet()) {
					if(score.getKey().equals(nameInput.getText())){
						this.errorLabel.setText("Choose another name.");
						return;
					}
				}	
			}
		}
			
		fileHandler.write(nameInput.getText() + ";" + this.loop.getPoints());
		
		this.window.initWelcomePage();
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.scoreLabel.setText(String.valueOf(this.loop.getPoints()));
		
	}

}
