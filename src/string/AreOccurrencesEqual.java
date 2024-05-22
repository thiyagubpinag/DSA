package string;

public class AreOccurrencesEqual {
    public static boolean areOccurrencesEqual(String s) {
        int[] a = new int[26];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            a[((int) s.charAt(i)) - 97] += 1;
            max = Math.max(max, a[((int) s.charAt(i)) - 97]);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && a[i] != max) {
                return false;
            }
        }
        return true;

    }

    public static String kthDistinct(String[] s, int k) {
        int[] a = new int[26];
        for (int i = 0; i < s.length; i++) {
            a[s[i].charAt(0) - 97] += 1;
        }

        for (int i = 0; i < s.length; i++) {
            if (a[s[i].charAt(0) - 97] == 1) {
                k--;
                if (k == 0) {
                    return s[i];
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abacbc";
        boolean res = areOccurrencesEqual(s);
        System.out.println(res);
        String[] b = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        String res1 = kthDistinct(b, k);
        System.out.println(res1);

    }
}
