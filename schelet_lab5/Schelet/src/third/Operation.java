package third;

public class Operation implements Minus, Plus, Mult, Div {
	private float mynumber;
	
	public Operation(float number) {
		this.mynumber = number;
	}
	
	@Override
	public void div(float number) {
		if(number != 0)
			mynumber = mynumber / number;
	}

	@Override
	public void mult(float number) {
		mynumber = mynumber * number;
	}

	@Override
	public void plus(float number) {
		mynumber = mynumber + number;
	}

	@Override
	public void minus(float number) {
		mynumber = mynumber - number;
	}
	
	public float getNumber() {
		return mynumber;
	}
}
