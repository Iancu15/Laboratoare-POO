package ex2;

public class Car {
	private int price;
	private int year;
	private CarType type;
	
	public enum CarType {
		  DACIA, LADA, MARUTI
	}

	public Car(int price, int year, CarType type) {
		this.price = price;
		this.year = year;
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type.toString();
	}
}
