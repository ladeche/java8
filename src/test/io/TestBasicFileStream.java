package test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBasicFileStream {
	
	public static void main(String[] args) {
		
		// FileStream /////////////////////

		byte[] b = new byte[128];
		
		try (FileInputStream fis = new FileInputStream("C:/tmp/Xtremsplit.exe");
			 FileOutputStream fos = new FileOutputStream("C:/tmp/copy.exe")) {
			System.out.println("Bytes available:"+fis.available());
			int count =0; int read=0;
			while ((read = fis.read(b)) != -1) {
				fos.write(b);
				count += read;
				System.out.println("count="+count);
			}
			System.out.println("Wrote:"+count);
		} catch (FileNotFoundException e) {
			System.out.println("File not found"+e);
		} catch (IOException e) {
			System.out.println("IO Exception"+e);
		} 
		
	}

}
