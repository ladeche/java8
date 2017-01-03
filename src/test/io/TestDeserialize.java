package test.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class TestDeserialize {

	public static void main(String[] args) {
		
		Vehicle v = null;
		String vId = null;
		
		System.out.println("Enter vehicle Id");
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			vId=in.readLine();
			if (vId.equals("exit")) {
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String serFile = "C:/tmp/vehicle"+vId+".ser";
		try (FileInputStream fis = new FileInputStream(serFile);
		     ObjectInputStream ois = new ObjectInputStream(fis)) {
			v = (Vehicle) ois.readObject();
			// voir aussi Vehicle.readObject

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Vehicle "+vId+" deserialized.");
		System.out.println(v.getColor()+"-"+v.getWheels());
		
	}

}
