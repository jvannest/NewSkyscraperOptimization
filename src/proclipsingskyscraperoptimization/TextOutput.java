package proclipsingskyscraperoptimization;

import java.io.*;

public class TextOutput{
  public static void main(String[] args)throws IOException{
  Writer output = null;
  String text = "Test";
  File file = new File("write.txt");
  output = new BufferedWriter(new FileWriter(file));
  output.write(text);
  output.close();
  System.out.println("Your file has been written");  
  }
}
