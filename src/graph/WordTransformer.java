package graph;

import java.util.*;
import java.util.stream.Collectors;

public class WordTransformer {
    public static int shortestTransformationLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> wordSet = wordList.stream().collect(Collectors.toSet());
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder(startWord));
        int depth = 0;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize != 0) {
                StringBuilder word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        if (word.charAt(i) == (char) (97 + j)) {
                            continue;
                        }
                        char temp = word.charAt(i);
                        word.setCharAt(i, (char) (97 + j));
                        if (word.toString().equals(targetWord)) {
                            return depth + 2;
                        }
                        if (wordSet.contains(word.toString())) {
                            queue.add(new StringBuilder(word));
                        }
                        word.setCharAt(i, temp);
                    }
                }
                qSize--;
            }
            depth++;
        }


        return -1;
    }

    public static void main(String[] args) {

        String[] a = {"glue", "glut", "geut", "neut", "next", "hill"};

        String start = "blue";
        String end = "next";
        int res = shortestTransformationLength(start, end, new ArrayList<>(Arrays.asList(a)));
        System.out.println(res);

    }
}
