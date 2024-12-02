import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MinimumPrime {

    static ArrayList<Integer> primeList = new ArrayList<>();

    static void sieveOfEratosthenes(int n, int m) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (primeList.size() == m) {
                break;
            }
            if (prime[i] == true) {
                primeList.add(i);
            }
        }
    }

    public static int subset(int n, int sum) {
        if (n < 0 || sum < 0) {
            return Integer.MAX_VALUE;
        }

        if (sum == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        if (primeList.get(n) > sum) {
            int exclude = subset(n - 1, sum);
            if (exclude != Integer.MAX_VALUE) {
                min = Math.min(min, exclude);
            }
        } else {
            int include = subset(n, sum - primeList.get(n));
            int exclude = subset(n - 1, sum);
            if (include != Integer.MAX_VALUE) {
                min = Math.min(min, include + 1);
            }
            if (exclude != Integer.MAX_VALUE) {
                min = Math.min(min, exclude);
            }
        }

        return min;

    }

    public static void main(String[] args) {
        int n = 11;
        int m = 3;

        sieveOfEratosthenes(n, m);
        System.out.println(primeList);
        int res = subset(primeList.size() - 1, n);
        System.out.println(res);

    }
}
