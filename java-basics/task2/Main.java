package task2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
			Course curs = new Course(4);
			
			Student stud1 = new Student("Gigel", 4);
			Student stud2 = new Student("Marius", 3);
			Student stud3 = new Student("Nichita", 1);
			Student stud4 = new Student("Valeria", 3);

			curs.add(stud1);
			curs.add(stud2);
			curs.add(stud3);
			curs.add(stud4);
			
			ArrayList<Student> students = curs.filterYear(Integer.valueOf(args[0]));

			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i).GetName());
			}
			
			Student stud5 = new Student("Gigel", 4);
			if(stud5.equals(stud1)) {
				System.out.println("Sunt egale");
			} else {
				System.out.println("Sunt diferite");
			}
	}
}
