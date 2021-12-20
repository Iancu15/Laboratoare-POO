package task1;

public class Complex {
	private int real;
	private int imaginary;
	
	public Complex(int real, int imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public Complex(){
		this(0, 0);
	}
	
	public Complex(Complex complex){
		this.real = complex.real;
		this.imaginary = complex.imaginary;
	}
	
	public int getReal() {
		return this.real;
	}
	
	public int getImaginary() {
		return this.imaginary;
	}
	
	public void setReal(int real) {
		this.real = real;
	}
	
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	
	public void addWithComplex(Complex complex) {
		this.real += complex.real;
		this.imaginary += complex.imaginary;
	}
	
	public void showNumber() {
		System.out.println(this.real + " " + this.imaginary + "j");
	}
}
