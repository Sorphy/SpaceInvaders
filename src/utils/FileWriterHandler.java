package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FileWriterHandler {
	
	private String fileName;
	private String baseDir;
	private String fullPath;
	
	public FileWriterHandler() {
		this.baseDir = FileWriterHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		this.fileName = "score.txt";
		this.fullPath = baseDir + fileName;
	}
	
	public void write(String text) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.getFullPath()), true));
		writer.append(text);
		writer.newLine();
		writer.flush();
	}
	
	public String read() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(this.getFullPath())));
		String output = "";
		String line = "";
		while((line = reader.readLine()) != null) {
			output += line + "\r\n";
		}
		return output;
	}
	
	public Map<String, String> parse(String text) {
		String[] lines = text.split("\r\n");
		Map<String, String> score = new HashMap<String, String>();
		for (String line : lines) {
			String[] values = line.split(";");
			score.put(values[0], values[1]);
		}
		return score;
		
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	
}
