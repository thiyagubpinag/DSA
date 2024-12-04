public class RegularExpression {
    public boolean regularExpression(String s, String p, int i, int j) {
        if (i < 0) {
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (i > 0 && j == 0) {
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return regularExpression(s, p, i - 1, j - 1);
        } else if (p.charAt(j) == '*') {
            return regularExpression(s, p, i - 1, j) || regularExpression(s, p, i, j - 1);
        } else {
            return false;
        }

    }

    public boolean isMatch(String s, String p) {
        return regularExpression(s, p, s.length() - 1, p.length() - 1);
    }

    public static void main(String[] args) {
        RegularExpression r = new RegularExpression();
        boolean result = r.isMatch("aa", "a*");
        System.out.println(result);
    }
}
