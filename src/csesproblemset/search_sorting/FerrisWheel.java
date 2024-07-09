package csesproblemset.search_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FerrisWheel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        String[] arrStr2 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int x = Integer.parseInt(arrStr1[1]);
        int[] wheelSize = new int[n];
        for (int i = 0; i < n; i++) {
            wheelSize[i] = (Integer.parseInt(arrStr2[i]));
        }

        int res=solve(wheelSize,n,x);

        System.out.println(res);

    }

    static int solve(int[] arr, int N, long X)
    {

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Maintain two pointers for children with heaviest
        // and lightest weight
        int l = 0, h = N - 1;

        // Variable to store the number of gondolas
        int ans = 0;

        // Iterate until the heaviest and lightest pointers
        // meet or cross
        while (h >= l) {
            // If the heaviest and lightest child can fit in
            // a gondola, then pair them up
            if (arr[l] + arr[h] <= X) {
                ans++;
                l++;
                h--;
            }
            // If the heaviest and lightest child cannot fit
            // in a gondola, then put the heaviest child in
            // a separate gondola
            else {
                ans++;
                h--;
            }
        }

        // Return the total number of gondolas needed
        return ans;
    }
}
