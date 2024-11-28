package test.com.stream;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MainClass {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person(1, "Alex", 100d, new Department(1, "HR"), BigDecimal.ONE,BigDecimal.TEN),
                new Person(2, "Brian", 200d, new Department(1, "HR"),BigDecimal.ONE,BigDecimal.ONE),
                new Person(3, "Charles", 900d, new Department(2, "Finance"),BigDecimal.ONE,BigDecimal.ONE),
                new Person(4, "David", 200d, new Department(2, "Finance"),BigDecimal.ONE,BigDecimal.ONE),
                new Person(5, "Edward", 200d, new Department(2, "Finance"),BigDecimal.ONE,BigDecimal.ONE),
                new Person(6, "Frank", 800d, new Department(3, "ADMIN"),BigDecimal.ONE,BigDecimal.ONE),
                new Person(7, "George", 900d, new Department(3, "ADMIN"),BigDecimal.ONE,BigDecimal.ONE));

        Map<Department, BigDecimal> groupedData = persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.reducing(BigDecimal.ZERO,Person::getCombination,BigDecimal::add)
                ));



        // Process the grouped data
        for (Map.Entry<Department, BigDecimal> entry : groupedData.entrySet()) {
            Department department = entry.getKey();
            BigDecimal totalSalary = entry.getValue();

            System.out.println(department+","+totalSalary);
        }
    }
}
