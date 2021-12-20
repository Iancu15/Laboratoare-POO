package lab3;

public class ChocAmor extends CandyBox {
	float length;
	
	public ChocAmor() {
		this("undefined", "undefined", 0);
	}
	
	public ChocAmor(String flavor, String origin, float length) {
		super(flavor, origin);
		this.length = length;
	}
	
	@Override
	public float getVolume() {
		return this.length * this.length * this.length;
	}
	
	@Override
	public String toString() {
		float volume = getVolume();
		return "The " + this.origin + " " + this.flavor + " has volume " + volume;
	}
	
	public void printChocAmorDim() {
		System.out.println("Lungimea " + this.length);
	}
	
	public void printDim() {
		System.out.println("Lungimea " + this.length);
	}
}
