package array;

public class HackPrevention {
    public static void main(String[] args) {
        String s = "JaP";
        int left = 0;
        int right = 1;
        int n = s.length();
        int triplet = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int count = 1;
        while (right < n) {
            if (Character.isLowerCase(s.charAt(right))) {
                lowerCase++;
            }
            if (Character.isUpperCase(s.charAt(right))) {
                upperCase++;
            }
            if (s.charAt(right) == s.charAt(left)) {
                count++;
                if (count == 3) {
                    triplet++;
                    left = right;
                }
            } else {
                count = 1;
                left++;
            }
            right++;
        }
        int resultCount = 0;
        if (lowerCase == 0) {
            resultCount++;
        }
        if (upperCase == 0) {
            resultCount++;
        }
        resultCount += triplet;
        if (s.length() < 6) {
            int rem = 6 - s.length();
            resultCount += rem;
        }
        System.out.println(resultCount);
    }
}
