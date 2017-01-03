package test.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Vehicle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	public Vehicle(String id) {
		super();
		this.id = id;
	}
	private int wheels;
	private String color;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(new Date());
	}
	
	private void readObject (ObjectInputStream ois) throws IOException,ClassNotFoundException {
		ois.defaultReadObject();
		Date date = (Date) ois.readObject();
		System.out.println("Last saved"+date);
	}

}
