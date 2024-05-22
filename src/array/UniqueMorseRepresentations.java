package array;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseRepresentations {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] tempArr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> set=new HashSet<>();
        String temp;
        for (int i = 0; i < words.length; i++) {
            temp = "";
            for (int j = 0; j < words[i].length(); j++) {
                temp += tempArr[(int) words[i].charAt(j) - 97];
            }
            set.add(temp);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin","zen","gig","msg"};
        int res=uniqueMorseRepresentations(words);
        System.out.println(res);
    }

}
