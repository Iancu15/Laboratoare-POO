package task2;

import java.util.ArrayList;

public class Course {
	private String title;
	private String description;
	private ArrayList<Student> students;
	
	public Course(int number_students) {
		this.students = new ArrayList<Student>(number_students);
	}
	
	public ArrayList<Student> filterYear(Integer year) {
		ArrayList<Student> students_year = new ArrayList<Student>();
		for(int i = 0; i < this.students.size(); i++) {
			Student student = this.students.get(i);
			if(student.GetYear().equals(year)) {
				students_year.add(student);
			}
		}
		
		return students_year;
	}
	
	public void add(Student stud) {
		this.students.add(stud);
	}
}