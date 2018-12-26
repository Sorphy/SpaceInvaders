package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileWriterHandler {
	
	private String fileName;
	
	public FileWriterHandler() {
		this.fileName = "score.csv";
		
		File yourFile = new File(this.fileName);
		try {
			yourFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public void write(String text){
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true))) {
			writer.append(text);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			System.out.println("Error while writting to file: " + e.getMessage());
		}

	}
	
	public String read(){
		String output = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
			String line = "";
			while((line = reader.readLine()) != null) {
				output += line + "\r\n";
			}
		} catch (IOException e) {

			System.out.println("Error while reading to file: " + e.getMessage());
		}
		
		return output;
	}
	
	public Map<String, String> parse(String text) {
		String[] lines = text.split("\r\n");
		
		if(lines.length < 1 || lines[0] == "") return null;
		
		Map<String, String> score = new HashMap<String, String>();
		for (String line : lines) {
			String[] values = line.split(";");
			score.put(values[0], values[1]);
		}
		return score;
		
	}

	
}
