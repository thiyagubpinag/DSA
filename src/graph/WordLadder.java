package graph;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {


        HashMap<Character, Integer> leftMap = new HashMap<>();
        HashMap<Character, Integer> rightMap = new HashMap<>();
        HashMap<String, List<String>> adjMatrix = new HashMap<>();
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        int n = wordList.size();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<String> tempList = new ArrayList<>();
            leftMap.clear();
            convertStringToMap(leftMap, wordList.get(i));
            for (int j = 0; j < n; j++) {
                rightMap.clear();
                convertStringToMap(rightMap, wordList.get(j));
                if (i != j && compareMap(leftMap, rightMap)) {
                    tempList.add(wordList.get(j));
                }
            }
            adjMatrix.put(wordList.get(i), tempList);
        }

        int steps = 1;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        set.clear();
        set.add(beginWord);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String str = queue.poll();
                if (str.equalsIgnoreCase(endWord)) {
                    return steps;
                }
                adjMatrix.get(str).forEach((value) -> {
                    if (!set.contains(value)) {
                        queue.add(value);
                        set.add(value);
                    }
                });
            }
            steps++;
        }

        return 0;
    }

    private static boolean compareMap(HashMap<Character, Integer> leftMap, HashMap<Character, Integer> rightMap) {
        int count = 0;
        for (Character temp : leftMap.keySet()) {
            Integer left = rightMap.get(temp);
            Integer right = rightMap.remove(temp);
            if (count > 1) {
                return false;
            }
            if (right!=null && left != right) {
                count++;
            }
        }
        if (count > 1) {
            return false;
        } else if (rightMap.size() > 1) {
            return false;
        } else if (rightMap.size() == 1 && count > 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void convertStringToMap(HashMap<Character, Integer> leftMap, String input) {
        char[] inputCharArray = input.toCharArray();
        for (int i = 0; i < inputCharArray.length; i++) {
            leftMap.put(inputCharArray[i], leftMap.getOrDefault(inputCharArray[i], 0) + 1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "leet";
        String endWord = "code";

        List<String> wordList = new ArrayList(List.of(new String[]{"lest", "leet", "lose", "code", "lode", "robe", "lost"}));

        int output = ladderLength(beginWord, endWord, wordList);
        System.out.println(output);
    }
}
