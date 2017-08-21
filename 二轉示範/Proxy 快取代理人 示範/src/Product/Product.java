package Product;

import java.util.UUID;

public class Product {
	private String uuid;
	private static int AMOUNT = 1213;
	private int sequenceId;
	private String name;
	private int price;
	private double weight;
	private double height;
	
	
	public Product(String name, int price, double weight, double height) {
		this.uuid = UUID.randomUUID().toString();
		this.sequenceId = AMOUNT ++;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.height = height;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getSequenceId() {
		return sequenceId;
	}
	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		return uuid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return uuid.equals(((Product)obj).getUuid());
	}

	@Override
	public String toString() {
		return String.format("Id: %s, 流水號: %d%n 名字: %s, 價格: %d%n 重量: %f, 高度: %f", uuid, sequenceId, name, price
				, weight, height);
	}
	
	
	
}
