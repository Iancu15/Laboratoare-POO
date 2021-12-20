package task2;

public class Student {
	private String name;
	private Integer year;
	
	public Student(String xname, Integer xyear) {
		this.name = xname;
		this.year = xyear;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public Integer GetYear() {
		return this.year;
	}
}
