package thread;

public class SealedClassExample {

    static sealed class A permits C{
        public void display(){
            System.out.println("a display");
        }
    }

    static class B extends C{
        public void display(){
            System.out.println("b display");
        }
    }

    static non-sealed class C extends A{
        public void display(){
            System.out.println("b display");
        }
    }

    public static void main(String[] args) {
        B a=new B();
        a.display();

    }
}
