package csesproblemset.search_sorting;

import java.util.Scanner;

public class NumberOfRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arrStr = sc.nextLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int count = solve(arr, n);
        System.out.println(count);
    }

    // Function to find the number of rounds
    static int solve(int[] arr, int N)
    {
        // Variable to store the final answer
        int ans = 1;

        // Array to store the index of numbers from 1 to N
        long[] indices = new long[N + 1];

        // Store the index of all elements of arr[]
        for (int i = 0; i < N; i++) {
            indices[(int)arr[i]] = i;
        }

        // If num occurs after (num + 1), increment ans by 1
        for (int num = 1; num < N; num++) {
            if (indices[num + 1] < indices[num])
                ans++;
        }
        return ans;
    }
}
