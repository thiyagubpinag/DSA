package array;

import java.util.Arrays;
import java.util.Collections;

public class MaxOutput {
    public static int solve(int d, int n) {
        int totalMembers = d;
        int noOfGroups = n;

        int group = totalMembers / noOfGroups;

        if (noOfGroups * group == totalMembers) {
            return group;
        }

        int remainngPeople = totalMembers - (noOfGroups * group);

        int lastGroup = group + remainngPeople;
        while (group != gcd(group, lastGroup)) {
            group--;
            lastGroup += (noOfGroups - 1);
        }

        //Write your code here
        return group;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int d = 21;
        int n = 4;
        int res = solve(d, n);
        System.out.println(res);


    }
}
