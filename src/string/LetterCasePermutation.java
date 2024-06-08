package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void dfs(char[] chArr, List ans, int i) {
        if(i >= chArr.length){
            ans.add(String.valueOf(chArr));
            return;
        }
        char letter = chArr[i];
        if(letter  >= '0' && letter <= '9') {
            dfs(chArr, ans, i + 1);
        } else {
            chArr[i] = Character.toUpperCase(chArr[i]);
            dfs(chArr, ans, i + 1);
            chArr[i] = Character.toLowerCase(chArr[i]);
            dfs(chArr, ans, i + 1);
        }
    }


    public static void main(String[] args) {
        String a="a1b2";
        List<String> list=new ArrayList<>();
        dfs(a.toCharArray(),list,0);
        System.out.println(list);
    }
}
