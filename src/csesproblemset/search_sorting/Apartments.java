//package csesproblemset.search_sorting;

import java.util.*;

public class Apartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        String[] arrStr2 = sc.nextLine().split(" ");
        String[] arrStr3 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        int k = Integer.parseInt(arrStr1[2]);
        int[] desiredApartmentSize = new int[n];
        int[] apartmentSize = new int[m];
        for (int i = 0; i < n; i++) {
            desiredApartmentSize[i]=(Integer.parseInt(arrStr2[i]));
        }
        for (int i = 0; i < m; i++) {
            apartmentSize[i]=(Integer.parseInt(arrStr3[i]));
        }
        Arrays.sort(desiredApartmentSize);
        Arrays.sort(apartmentSize);

        int count = solve(desiredApartmentSize, apartmentSize,n,m, k);

        System.out.println(count);
    }

    static int solve(int[] A, int[] B, int N, int M, int K)
    {
        // Sort both the arrays in ascending order
        Arrays.sort(A);
        Arrays.sort(B);

        // Maintain two pointers to store the current value
        // in both the arrays
        int ptrA = 0, ptrB = 0, ans = 0;
        while (ptrA < N && ptrB < M) {
            // Check if the applicant at index ptrA can
            // purchase the apartment at index ptrB
            if (Math.abs(A[ptrA] - B[ptrB]) <= K) {
                // Increase the number of purchases
                ans += 1;
                ptrA += 1;
                ptrB += 1;
            }
            // If the current applicant's demand is too
            // small, move to the next applicant
            else if (A[ptrA] < B[ptrB]) {
                ptrA += 1;
            }
            // If the current apartment's size is too small,
            // move to the next apartment
            else {
                ptrB += 1;
            }
        }
        return ans;
    }

}
