package test.com.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    int id;
    String name;
    double salary;
    Department department;
    BigDecimal a;
    BigDecimal b;

    public BigDecimal getCombination() {
        return a.add(b);
    }

}