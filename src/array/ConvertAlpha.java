package array;

public class ConvertAlpha {

    static String[] temp = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static int getCombination(String str) {
        int n = str.length();
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            int val = Integer.parseInt(str);
            if (val <= 26) {
                return 2;
            }
        }

        //


        return 0;
    }

    public static void main(String[] args) {
        String input = "2261";

        int count = getCombination(input);
        System.out.println(count);
    }
}
