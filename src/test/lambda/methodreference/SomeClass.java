package test.lambda.methodreference;

import java.util.List;

public class SomeClass {
	private String message;
	private List<String> list;

	public SomeClass() {
		this.message = "Default Constructor";
		System.out.println(
				"+++SomeClass Default Constructor");
	}

	public SomeClass(String message) {
		this.message = message;
		System.out.println("+++SomeClass String Constructor");
	}

	public SomeClass(List<String> list) {
		this.list = list;
		System.out.println("+++SomeClass List Constructor");
	}

	public String getMessage() {
		return message;
	}
	public List<String> getList() {
		return list;
	}
}
