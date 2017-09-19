package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Invoice {
	
	private BufferedWriter bufferedWriter;
	private File file;
	
	public Invoice(String name) throws IOException {
		file = new File(name);
		bufferedWriter = new BufferedWriter(new FileWriter(file));
	}
	
	public void write(String line) throws IOException{
		bufferedWriter.write(line);
		bufferedWriter.newLine();
	}
	
	public void close() throws IOException{
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	public File getFile(){
		return file;
	}

}
