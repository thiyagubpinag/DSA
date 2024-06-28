package queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    static class Student {
        public String name;
        public Double cgpa;

        // A parameterized student constructor
        public Student(String name, double cgpa) {

            this.name = name;
            this.cgpa = cgpa;
        }

        public String getName() {
            return name;
        }

        public Double getCgpa() {
            return cgpa;
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' + ", cgpa=" + cgpa + '}';
        }
    }

    static public class Employee {
        String name;
        int age;
        double salary;
        long mobile;

        // constructors, getters & setters

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public long getMobile() {
            return mobile;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Thiyagu", 75);
        Student student2 = new Student("Pugazh", 65);
        Student student3 = new Student("Vaidee", 85);
        Student student4 = new Student("Pugazh12", 15);
        Student student5 = new Student("Pugazh3", 15);
        Student student6 = new Student("Pugazh4", 15);
        Comparator<Student> comp=Comparator.comparing(Student::getCgpa).thenComparing(Student::getName);
        PriorityQueue<Student> queue = new PriorityQueue<>(Collections.reverseOrder(comp));

        queue.add(student1);
        queue.add(student2);
        queue.add(student3);
        queue.add(student4);
        queue.add(student5);
        queue.add(student6);


        while (!queue.isEmpty()) {
            System.out.println(queue.peek().toString());
            queue.poll();
        }

        Comparator<Employee> employee_Name_Age_Comparator
                = Comparator.comparing(Employee::getName)
                .thenComparingInt(Employee::getAge);


    }
}
