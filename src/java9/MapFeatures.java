package java9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapFeatures {

    @Getter
    @Setter
    @AllArgsConstructor
    static class Student{
        int id;
        String name;
    }

    public static void main(String[] args) {
        String sentence="Welcome to the java world . the best author is telusko";
        Student student1=new Student(1,"A");
        Student student2=new Student(2,"B");
        List<Student> studentList=new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);

        Map<String, Long> wordCountMap = Arrays.stream(sentence.split(" "))
                .collect(Collectors.toMap(Function.identity(),v->1L, Long::sum));

        List<String> temp= studentList.stream().map(Student::getName).toList();

        System.out.println(temp);

    }
}
