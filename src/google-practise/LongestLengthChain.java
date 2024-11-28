import java.util.HashMap;

import java.util.*;

public class LongestLengthChain {

    class Graph {
        HashMap<String, List<String>> adj;

        Graph() {
            adj = new HashMap<>();
        }

        void addEdge(String u, String v) {
            List<String> l = adj.getOrDefault(u, new ArrayList<>());
            l.add(v);
            adj.put(u, l);
        }

        int dfs(String[] words) {
            HashMap<String, Integer> visitedMap = new HashMap<>();
            int max = 1;
            for (String word : words) {
                max = Math.max(max, dfsUtils(word, visitedMap));
            }
            return max;
        }

        private int dfsUtils(String word, HashMap<String, Integer> visitedMap) {
            if (visitedMap.containsKey(word)) {
                return visitedMap.get(word);
            }
            if (adj.get(word) == null) {
                return 1;
            }

            int count = 1;
            for (String neighbor : adj.get(word)) {
                count = Math.max(count, 1 + dfsUtils(neighbor, visitedMap));
            }

            visitedMap.put(word, count);
            return count;

        }

    }

    public int getLcs(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = 1 + getLcs(i - 1, j - 1, word1, word2, dp);
        } else {
            dp[i][j] = Math.max(getLcs(i - 1, j, word1, word2, dp), getLcs(i, j - 1, word1, word2, dp));
        }

        return dp[i][j];
    }

    public int longestStrChain(String[] words) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            List<String> l = map.getOrDefault(words[i].length(), new ArrayList<>());
            l.add(words[i]);
            map.put(words[i].length(), l);
        }

        Graph graph = new Graph();
        while (map.size() > 0) {
            int len = map.keySet().iterator().next();
            List<String> l = map.get(len);
            map.remove(len);

            for (int i = 0; i < l.size(); i++) {
                List<String> p = map.get(len + 1);
                if (p == null || p.isEmpty()) {
                    break;
                }
                for (int j = 0; j < p.size(); j++) {
                    int[][] dp = new int[l.get(i).length()][p.get(j).length()];
                    for (int k = 0; k < dp.length; k++) {
                        Arrays.fill(dp[k], -1);
                    }
                    int lcsLen = getLcs(
                            l.get(i).length() - 1,
                            p.get(j).length() - 1,
                            l.get(i),
                            p.get(j),
                            dp);
                    if (lcsLen == len) {
                        String source = l.get(i);
                        String destination = p.get(j);
                        graph.addEdge(source, destination);
                    }
                }

            }
        }

        return graph.dfs(words);

    }

    public static void main(String[] args) {
        String[] words = { "a", "b", "ba", "bca", "bda", "bdca", "bdcal" };
        LongestLengthChain l = new LongestLengthChain();
        int res = l.longestStrChain(words);
        System.out.println(res);

    }
}
