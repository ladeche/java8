package test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestCopyFile {
	
	public static void main(String[] args) {
		
		// Use of Channels to manage a copy in a single operation.
		
		try(FileChannel fcIn = new FileInputStream("C:/tmp/batch.log").getChannel();
		    FileChannel fcOut = new FileOutputStream("C:/tmp/batch.channel.log").getChannel()) {
			ByteBuffer buffer = ByteBuffer.allocate((int) fcIn.size());
			fcIn.read(buffer);
			buffer.position(0);
			fcOut.write(buffer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
