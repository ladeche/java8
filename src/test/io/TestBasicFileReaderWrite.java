package test.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBasicFileReaderWrite {

	public static void main(String[] args) {
		char[] c = new char[128];
		
		try (FileReader fr = new FileReader("C:/tmp/batch.log");
			 FileWriter fw = new FileWriter("C:/tmp/copy.log")) {
			int count=0;
			int read =0;
			while((read = fr.read(c))!=-1) {
				fw.write(c);
				count+=read;
				System.out.println("count="+count);
			}
			System.out.println("Wrote:"+count);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
