package test.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class TestSerialize {

	public static void main(String[] args) {
		
		Vehicle v = null;
		String vId = null;
		
		System.out.println("Enter vehicle Id");
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			vId=in.readLine();
			if (vId.equals("exit")) {
				System.exit(0);
			}
			v = new Vehicle(vId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		v.setColor("Yellow");
		v.setWheels(4);
		
		String serFile = "C:/tmp/vehicle"+vId+".ser";
		try (FileOutputStream fos = new FileOutputStream(serFile);
		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(v);
			// voir aussi Vehicle.writeObject
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Vehicle "+vId+" serialized.");
		
	}

}
