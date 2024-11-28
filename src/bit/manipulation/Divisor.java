package bit.manipulation;

public class Divisor {
    public static void main(String[] args) {
        int dividend=22;
        int divisor=3;

        int n=dividend;
        int d=divisor;
        int ans=0;
        while(n>=d) {
            int count = 0;
            while (n >= (d * (1 << count+1))) {
                count++;
            }
            ans+=(1<<count);
            n=n-(d*(1<<count));
        }
        System.out.println(ans);

    }
}
