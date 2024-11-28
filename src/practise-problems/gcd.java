package test;

public class gcd {
    public static void main(String[] args) {
        int a = 4;
        int b = 8;
        int gcd = gcd(a, b);
        System.out.println(gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
