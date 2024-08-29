package dp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public static int longestStringChain(String[] words) {
        // Sort the words by length in ascending order
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // Create a map to store the maximum chain length for each word
        Map<String, Integer> dp = new HashMap<>();

        // Initialize the maximum chain length
        int maxChainLength = 0;

        // Iterate through each word
        for (String word : words) {
            // Initialize the current chain length to 1
            dp.put(word, 1);

            // Iterate through each character in the word
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(newWord) && dp.get(word) < dp.get(newWord) + 1) {
                    dp.put(word, dp.get(newWord) + 1);
                }
            }

            // Update the maximum chain length if necessary
            maxChainLength = Math.max(maxChainLength, dp.get(word));
        }

        return maxChainLength;
    }

    public static void main(String[] args) {
        String[] words = {"x", "xx", "y", "xyx"};
        int longestChain = longestStringChain(words);
        System.out.println("Longest string chain length: " + longestChain);
    }
}