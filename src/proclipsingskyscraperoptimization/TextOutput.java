package proclipsingskyscraperoptimization;

import java.io.*;

public class TextOutput{
	
	String Levels, Floors, ColumnGrids, Columns, Beams;
	PrintWriter output = null;
	
	public static void main(String[] args)throws IOException{
		
	}
	
	void writeFile(){
		
		String text = "Test";
		String fileName = "test.txt";

		try {
			output = new PrintWriter(fileName);
			
		} catch (IOException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
			e.printStackTrace();
		}
		output.write(text);
		output.close();
		System.out.println("Your file has been written");  
	}
}
