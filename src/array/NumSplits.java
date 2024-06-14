package array;

import java.util.HashSet;

public class NumSplits {
    public static int getCount(String s, int[] count) {
        int totalCharacter = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            count[index]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                totalCharacter++;
            }
        }
        return totalCharacter;
    }

    public static int numSplits(String s) {
        int count = 0;
        int[] leftCount = new int[26];
        int[] rightCount = new int[26];
        int leftTotalCharacter = 0;
        int totalCharcater = getCount(s, rightCount);
        int rightTotalCharater = totalCharcater;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (leftCount[index] == 0) {
                leftTotalCharacter++;
            }
            leftCount[index]++;
            if (rightCount[index] == 1) {
                rightTotalCharater--;
            }
            rightCount[index]--;
            if (leftTotalCharacter == rightTotalCharater) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int res = numSplits("ccbbcaacbaabaaaaabbccabacccba");
        System.out.println(res);
    }
}
