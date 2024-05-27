package array;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        int carry = 0;
        int numerator;
        while (maxLength-- >0) {
            int sum = 0;
            if (maxLength < a.length()) {
                sum += (Integer.parseInt(String.valueOf(a.charAt(maxLength))));
            }
            if (maxLength < b.length()) {
                sum += (Integer.parseInt(String.valueOf(b.charAt(maxLength))));
            }
            sum += carry;
            numerator = sum % 2;
            res.insert (0,String.valueOf(numerator));
            if (sum % 2 == 0) {
                carry = 1;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = addBinary("1010", "1011");
        System.out.println(res);
    }
}
