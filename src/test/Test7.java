package test;

public class Test7 {

    public static void main(String[] args) {
        int[] arrr = {1, -3, 5, -2, -9, 1};
        int target = 1;


        int maxEndHere = 0;
        int start = 0;
        int sum = 0;
        int n = arrr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arrr[i];
            maxEndHere = i;
            if (sum >= target || sum < 0) {
                start = i;
                sum = arrr[i];
            }
            max = Math.max(max, maxEndHere - start + 1);
        }

        System.out.println(max);


    }
}
