package dp;


import java.util.*;

// Java program for the above approach
class WordBreakII {
    public static int countSentences(String[] dict, String s) {
        Set<String> wordSet = new HashSet<>(Set.of(dict)); // Convert dictionary to Set for faster lookups
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                //System.out.println(word);
                if (wordSet.contains(word)) {
                    dp[i] += dp[j]; // Combine previous valid sentences with current word
                }
            }
        }

        return dp[n]; // Number of sentences using entire string
    }

    public static int wordBreak(int n, List<String> dict, String s) {
        //Write your code here
        Set<String> wordSet = new HashSet<>();
        for(int i=0;i<dict.size();i++){
            wordSet.add(dict.get(i));
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                System.out.println(word);
                if (wordSet.contains(word)) {
                    dp[i] += dp[j];
                }
            }
            System.out.println(dp[i]);
        }

        return dp[n];

    }

    public static void main(String[] args) {
        String[] dict = {"he", "hebrew", "brew", "bible", "isa", "book", "is", "a"};
        String s = "hebrewbibleisabook";
        int count = countSentences(dict, s);
        System.out.println("Number of possible sentences: " + count);
        int res=wordBreak(3,List.of("I","am","Iam","a"),"Iam");
        System.out.println(res);
    }
}

// This code is contributed by subhamgoyal2014.
