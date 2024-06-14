package array;

import java.util.*;

public class MaxScoreWords {
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lettersInt = new int[26];
        for (int i = 0; i < letters.length; i++) {
            int index = letters[i] - 97;
            lettersInt[index]++;
        }
        int[] wordsTotal = new int[words.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            int[] temp = Arrays.copyOf(lettersInt, lettersInt.length);
            boolean flag = true;
            int sum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 97;
                sum += score[index];
                if (temp[index] <= 0) {
                    flag = false;
                    break;
                }
                temp[index]--;
            }
            if (flag) {
                max = Math.max(max, sum);
                wordsTotal[i] = sum;
            } else {
                wordsTotal[i] = -1;
            }
        }


        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            for (int j = 0; j < words.length; j++) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int k = 0; k < words[i].length(); k++) {
                    map.put(words[i].charAt(k), map.getOrDefault(words[i].charAt(k), 0) + 1);
                }
                if (i != j && wordsTotal[j] != -1) {

                }
            }
        }


        return max;
    }

    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int res = maxScoreWordsII(words, letters, score);
        System.out.println(res);
        System.out.println("Done");

        Queue<Integer> queue=new LinkedList<>();
        String a="abc";
        System.out.println(a.substring(1));

    }

    // Function to calculate the score of a single word
    public static int scoreCalculator(String word, int[] count, int[] scores) {
        char[] charArray = word.toCharArray();
        int[] charCount = new int[26];
        int score = 0;

        // Calculate the score of the word if it can be formed
        for (int i = 0; i < charArray.length; i++) {
            int pos = charArray[i] - 'a';
            charCount[pos]++;
            if (charCount[pos] <= count[pos]) {
                score += scores[pos];
            } else {
                return 0; // Word can't be formed
            }
        }
        return score;
    }

    // Function to calculate the maximum score of words that can be formed
    public static int maxScoreWordsII(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char ch : letters) {
            count[ch - 'a']++;
        }
        return maxSScoreHelper(0, words, score, count);
    }

    // Helper function to recursively calculate the maximum score
    public static int maxSScoreHelper(int index, String[] words, int[] score, int[] count) {
        if (index == words.length) return 0; // Base case: no more words to consider

        // Calculate the maximum score without including the current word
        int maxScore = maxSScoreHelper(index + 1, words, score, count);

        // Calculate the score if the current word is included
        int include = scoreCalculator(words[index], count, score);
        if (include > 0) {
            int[] tempCount = count.clone(); // Copying the array
            for (char ch : words[index].toCharArray()) {
                tempCount[ch - 'a']--;
            }
            // Update maxScore by including the current word and recursively calculate the score for the remaining words
            maxScore = Math.max(maxScore, include + maxSScoreHelper(index + 1, words, score, tempCount));
        }
        return maxScore;
    }
}
