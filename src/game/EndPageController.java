package game;

import java.net.URL;
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
	private TextField nameInput;
	
	
	public EndPageController(GameWindow window, GameLoop loop) {
		this.window = window;
		this.loop = loop;
	}
	
	@FXML
	public void saveScore(ActionEvent event) {
		if(nameInput.getText().isEmpty()) {return;}
		try {
			FileWriterHandler fileHandler = new FileWriterHandler();
			fileHandler.write(nameInput.getText() + ";" + this.loop.getPoints());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		this.window.initWelcomePage();
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.scoreLabel.setText(String.valueOf(this.loop.getPoints()));
		
	}

}
