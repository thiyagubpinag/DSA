package array;

public class PartitionArr {
    static class A {
        void check() {
            System.out.println("Method foo() in class A");
        }
    }

    static class B extends A {
        void check() {
            System.out.println("Method foo() in class B");
        }
    }

    static class C extends B {
        void check() {
            System.out.println("Method foo() in class C");
        }
    }

    static class D extends B {
        // Inherits foo() from class B
    }

    public static void main(String[] args) {
        int[] arr={-1,0,7,9,0};
        int low=-1;

        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==0){
                low++;
                int temp=arr[low];
                arr[low]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println("Done");


        A d = new C();
        d.check();

    }
}
