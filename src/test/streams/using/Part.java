package test.streams.using;

public class Part {
	private String name;
	private int partNumber;
	private int weight;
	private float price;
	private int quantity;

	public Part(String name, int partNumber, int weight, float price, int quantity) {
		this.name = name;
		this.partNumber = partNumber;
		this.weight = weight;
		this.price = price;
		this.quantity = quantity;
	}

	public Part(Part part) {
		this(part.name, part.partNumber, part.weight, part.price, part.quantity);
	}

	public Part() {
		this("Default", 12345, 10, 10.0f, 0);
	}

	public String getName() {
         return name;
    }


	public void setName(String name) {
		this.name = name;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean equals(Part part) {
		return this.name.equals(part.name);
	}

	public int comparator(Part part) {
		return this.name.compareTo(part.name);
	}

	public String toString() {
         return String.format(
                 "Name: %-8s Weight: %3d Part Number: %3d Price: %.2f Quantity: %5d",
                 this.name, this.weight, this.partNumber,
                 this.price, this.quantity);
   }
}
