import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Student stud1 = new Student(1, "Patricia", "Georgescu", 3);
        Student stud2 = new Student(2, "George", "Georgescu", 3);
        Student stud4 = new Student(4, "Mirela", "Oprescu", 9);
        Student stud5 = new Student(5, "Mirela", "Mirabela", 9);
        Student stud3 = new Student(3, "Stoe", "Madam", 5);
        
        List<Student> students = new ArrayList<>();
        students.add(stud1);
        students.add(stud2);
        students.add(stud3);
        students.add(stud4);
        students.add(stud5);
        
        System.out.println("-----------------------LIST--------------------\n");
        System.out.println(students);
        Collections.sort(students);
        System.out.println("\n-------------------SORTED-LIST-----------------\n");
        System.out.println(students);
        students.sort((x, y) -> y.getAverageGrade().intValue() - x.getAverageGrade().intValue());
        System.out.println("\n---------------LAMBDA-SORTED-LIST---------------\n");
        System.out.println(students);
        
        PriorityQueue<Student> studentsQueue = new PriorityQueue<>(5, (x, y) -> Long.compare(x.getId(), y.getId()));
        studentsQueue.addAll(students);
        System.out.println("\n-------------------PRIORITY-QUEUE-----------------\n");
        for (Student student : studentsQueue) {
            System.out.println(student);
        }
        
        Map<Student, LinkedList<String>> studentSchedule = new HashMap<>();
        LinkedList<String> student1Schedule = new LinkedList<>();
        student1Schedule.add("Franceza");
        student1Schedule.add("Filozofie");
        student1Schedule.add("Teoria Sistemelor");
        studentSchedule.put(stud1, student1Schedule);
        
        LinkedList<String> student2Schedule = new LinkedList<>(student1Schedule);        
        student2Schedule.add("Sport");
        studentSchedule.put(stud2, student2Schedule);
        
        LinkedList<String> student3Schedule = new LinkedList<>(student2Schedule);
        student3Schedule.remove(2);
        student3Schedule.add("USO");
        studentSchedule.put(stud3, student3Schedule);
        
        LinkedList<String> student4Schedule = new LinkedList<>(student2Schedule);
        student4Schedule.remove(0);
        student4Schedule.add("Calculatoare Numerice 2");
        studentSchedule.put(stud4, student4Schedule);
        
        LinkedList<String> student5Schedule = new LinkedList<>(student2Schedule);
        student5Schedule.remove(2);
        student5Schedule.add("SO");
        studentSchedule.put(stud5, student5Schedule);
        
        System.out.println("\n---------------------MAP----------------------\n");
        for (Map.Entry<Student, LinkedList<String>> schedule : studentSchedule.entrySet()) {
            System.out.println(schedule.getKey());
            System.out.println(schedule.getValue());
            System.out.println("\n");
        }
        
        LinkedHashSetEven listEven = new LinkedHashSetEven();
        listEven.add(4);
        listEven.add(1);
        listEven.add(6);
        listEven.add(3);
        listEven.add(13);
        listEven.add(4);
        listEven.add(0);
        System.out.println("\n---------------------EVEN-LIST----------------------\n");
        for (Integer number : listEven) {
            System.out.println(number);
        }
        
        /***
         * Pentru LinkedHashSet isi pastreaza ordinea de la citire
         * In HashSet si TreeSet sunt puse in ordine crescatoare
         */
    }
}
