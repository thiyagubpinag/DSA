package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class WordBreak {
    public static void main(String[] args) {
        String word = "applepenapple";
        String[] wordDict = {"apple", "pen"};
        HashSet<String> dict = new HashSet<>();
        for (String worddi : wordDict) {
            dict.add(worddi);
        }
        int n = word.length();

        int T[][] = new int[word.length()][word.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        int count=0;
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    count++;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        count++;
                    }
                }
            }
        }





        System.out.println(count);

    }
}
