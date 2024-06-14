package string;

import java.util.ArrayList;
import java.util.List;

public class HappyString {
    public static void main(String[] args) {
        char a = 'a';
        a++;
        String str="hello";

        System.out.println(str.contains("lo"));
        System.out.println(a);
        getHappyString(3, 9);
    }

    static List<String> resultList = new ArrayList<>();

    public static String getHappyString(int n, int k) {
        StringBuilder input = new StringBuilder("a");
        for(int i=0;i<n;i++){
            getHappyStringRec(input, i, n);
        }
        return null;
    }

    private static void getHappyStringRec(StringBuilder input, int index, int n) {
        if (input.length() == n) {
            resultList.add(input.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i != index) {
                char tempIndex = (char) (97+i);
                input.append(tempIndex);
                getHappyStringRec(input, i, n);
                input.deleteCharAt(input.length() - 1);
            }
        }

    }
}
