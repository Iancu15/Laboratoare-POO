package lab3;

public class Lindt extends CandyBox {
	float length;
	float width;
	float height;
	
	public Lindt() {
		this("undefined", "undefined", 0, 0, 0);
	}
	
	public Lindt(String flavor, String origin, float length, float width, float height) {
		super(flavor, origin);
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public float getVolume() {
		return this.length * this.width * this.height;
	}
	
	@Override
	public String toString() {
		float volume = getVolume();
		return "The " + this.origin + " " + this.flavor + " has volume " + volume;
	}
	
	public void printLindtDim() {
		System.out.println("Lungimea " + this.length + ", latimea " + this.width + " si inaltimea " + this.height);
	}
	
	public void printDim() {
		System.out.println("Lungimea " + this.length + ", latimea " + this.width + " si inaltimea " + this.height);
	}
}
