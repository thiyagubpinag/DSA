package test;

public class Test12 {
    enum Test{
        TEST1,TEST2
    }

    public static void main(String[] args) {
        System.out.println(Test.valueOf("TEST1"));
    }
}
