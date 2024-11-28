package com.design.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class IterDesignPattern {

    static class Student {
        int rollNo;
        String collegeName;

        public Student(int rollNo, String collegeName) {
            this.rollNo = rollNo;
            this.collegeName = collegeName;
        }

        @Override
        public String toString() {
            return "Student{" + "rollNo=" + rollNo + ", collegeName='" + collegeName + '\'' + '}';
        }
    }

    static class StudentList implements Iterable {
        List<Student> studentList;

        public StudentList(List<Student> studentList) {
            this.studentList = studentList;
        }

        @Override
        public Iterator iterator() {
            return new GetFirstFive(studentList);
        }

    }

    static class GetFirstFive implements Iterator<Student> {
        List<Student> studentList;
        int size = 0;

        public GetFirstFive(List<Student> studentList) {
            this.studentList = studentList;
        }

        @Override
        public boolean hasNext() {
            if (size < 5) {
                return true;
            }
            return false;
        }

        @Override
        public Student next() {
            return studentList.get(size++);
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        IntStream.range(1, 10).forEach(i -> studentList.add(new Student(i, "College")));

        StudentList list = new StudentList(studentList);

        list.forEach(i->{
            System.out.println(i);
        });

    }


}
