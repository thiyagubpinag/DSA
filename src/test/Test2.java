package test;

public class Test2 {
    public static String compressedString(String word) {
        int i = 0;
        int j = 0;
        int n = word.length();
        String res = "";
        int count = 0;
        while (j < n) {
            if (word.charAt(i) == word.charAt(j)) {
                count++;
                j++;
                if (count == 9) {
                    res += (count + "" + word.charAt(i));
                    count = 0;
                }
            } else {
                if(count>=1)res += (count + "" + word.charAt(i));
                count = 0;
                i = j;
            }
        }
        if(count>=1)res += (count + "" + word.charAt(n - 1));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaay"));
    }
}
