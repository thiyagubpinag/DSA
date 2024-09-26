package thread;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class StudentService {
    public static void main(String[] args) {
        Student stu1=new Student(1,"Thiyagu");
        Student stu2=new Student(1,"Thiyagu");
        System.out.println(stu1.equals(stu2));

        System.out.println(getLatestSwitch(Double.valueOf("23")));

        SplittableRandom random = new SplittableRandom();
        int randomNumberInRange = random.nextInt(10, 20);
        System.out.println(randomNumberInRange);

        double a = 0.1;
        double b = 0.2;
        double c = a + b;

        BigDecimal bd1=BigDecimal.valueOf(0.1);
        BigDecimal bd2=BigDecimal.valueOf(0.3);
        BigDecimal bd3=bd1.add(bd2);
        System.out.println(bd3);


        System.out.println(c);
    }


    public static String getLatestSwitch(Object obj){
        return switch (obj){
            case Double d -> "Double";
            case Integer i -> "Integer";
            case BigDecimal bd -> "Big Decimal";
            default -> "Not an Object";
        };
    }
}
