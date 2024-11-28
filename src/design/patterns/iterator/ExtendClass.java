package design.patterns.iterator;

public class ExtendClass {
    static class A {
        void call() {
            System.out.println("A");
        }
    }

    static class B extends A {
        void call() {
            System.out.println("B");
        }
    }

    static class C extends B {
        void call() {
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        A c=new B();
        c.call();
    }
}
