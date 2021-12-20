package task1;

public class Main {
	public static void main(String[] args) {
		Complex c1 = new Complex(1, 2);
		Complex c2 = new Complex(2, 1);
		
		c1.showNumber();
		c2.showNumber();
		c1.addWithComplex(c2);
		c1.showNumber();
	}
}
