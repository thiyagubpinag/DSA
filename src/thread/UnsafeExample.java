package thread;

import sun.misc.Unsafe;

public class UnsafeExample {
    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();
        long value = unsafe.allocateMemory(1024);
        System.out.println(value);
    }
}
