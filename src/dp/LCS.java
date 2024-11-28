package dp;

public class LCS {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "abdcd";
        int res = getCommonSubSequence(a, b, a.length() - 1, b.length() - 1);
        System.out.println(res);
    }

    private static int getCommonSubSequence(String a, String b, int aLength, int bLength) {
        if (aLength < 0 || bLength < 0) {
            return 0;
        }
        if (a.charAt(aLength) == b.charAt(bLength)) {
            return 1 + getCommonSubSequence(a, b, aLength - 1, bLength - 1);
        }

        return Math.max(
                getCommonSubSequence(a, b, aLength - 1, bLength),
                getCommonSubSequence(a, b, aLength, bLength - 1));
    }
}
