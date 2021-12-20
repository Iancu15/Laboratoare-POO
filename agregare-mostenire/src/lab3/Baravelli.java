package lab3;

public class Baravelli extends CandyBox {
	float radius;
	float height;
	
	public Baravelli() {
		this("undefined", "undefined", 0, 0);
	}
	
	public Baravelli(String flavor, String origin, float radius, float height) {
		super(flavor, origin);
		this.radius = radius;
		this.height = height;
	}
	
	@Override
	public float getVolume() {
		return (float)3.14 * this.radius * this.radius * this.height;
	}
	
	@Override
	public String toString() {
		float volume = getVolume();
		return "The " + this.origin + " " + this.flavor + " has volume " + volume;
	}
	
	public void printBaravelliDim() {
		System.out.println("Raza " + this.radius + " si inaltimea " + this.height);
	}
	
	public void printDim() {
		System.out.println("Raza " + this.radius + " si inaltimea " + this.height);
	}
}
