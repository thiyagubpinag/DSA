package csesproblemset.search_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FactoryMachines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        String[] arrStr2 = sc.nextLine().split(" ");
        Long n = Long.parseLong(arrStr1[0]);
        Long t = Long.parseLong(arrStr1[1]);
        List<Long> arr = new ArrayList<>();
        Arrays.stream(arrStr2).forEach(i -> arr.add(Long.parseLong(i)));
        Long max = arr.stream().max(Long::compare).get() * t;


        long low = 1;
        long high = max;
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (acceptCondition(mid, arr, t)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean acceptCondition(Long mid, List<Long> arr, Long t) {
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += (mid / arr.get(i));
            if (sum >= t) {
                return true;
            }
        }
        return false;
    }
}
