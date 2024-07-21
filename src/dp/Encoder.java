package dp;

import java.util.HashMap;
import java.util.Scanner;

public class Encoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        int res = getEncoder(words);
        System.out.println(res);
    }

    private static int getEncoder(String[] words) {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 1; j < word.length(); j++) {
                String suffix = word.substring(j);
                if (map.containsKey(suffix)) {
                    map.remove(suffix);
                }
            }
        }
        String res = "";
        for (String key : map.keySet()) {
            res += (key + "#");
        }

        System.out.println(res);
        return res.length();
    }

}
