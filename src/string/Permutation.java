package string;

public class Permutation {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("abc");
        permutationStr(a, 0, a.length() - 1);
    }

    private static void permutationStr(StringBuilder a, int left, int right) {
        if (left == right) {
            System.out.println(a);
            return;
        }
        for (int i = left; i <= right; i++) {
            char temp = a.charAt(i);
            a.setCharAt(i, a.charAt(left));
            a.setCharAt(left, temp);
            permutationStr(a, left + 1, right);
            temp = a.charAt(i);
            a.setCharAt(i, a.charAt(left));
            a.setCharAt(left, temp);
        }

    }
}
