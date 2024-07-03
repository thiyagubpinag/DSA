package graph;

import java.util.*;

public class GroupSimilarItems {

    public static List<List<String>> groupSimilarItems(List<List<String>> items) {
        // Map emails to a list of item indexes sharing that email
        Map<String, List<Integer>> emailToItems = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);
            String name = item.get(0);
            List<String> emails = item.subList(1, item.size());
            for (String email : emails) {
                emailToItems.putIfAbsent(email, new ArrayList<>());
                emailToItems.get(email).add(i);
            }
        }

        // Disjoint-set forest for efficient grouping
        int[] parent = new int[items.size()];
        int[] rank = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        makeUnion(emailToItems, parent, rank);

        // Group items based on their root in the disjoint-set forest
        Map<Integer, List<String>> groups = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            int root = findRoot(parent, i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).addAll(items.get(i));
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            HashSet<String> set = new LinkedHashSet<>();
            for (int i = 0; i < group.size(); i++) {
                set.add(group.get(i));
            }
            result.add(set.stream().toList());
        }

        return result;
    }

    private static int findRoot(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = findRoot(parent, parent[i]);
        }
        return parent[i];
    }

    private static void makeUnion(Map<String, List<Integer>> emailToItems, int[] parent, int[] rank) {
        for (List<Integer> itemIndexes : emailToItems.values()) {
            for (int i = 1; i < itemIndexes.size(); i++) {
                union(parent, rank, itemIndexes.get(0), itemIndexes.get(i));
            }
        }
    }

    private static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = findRoot(parent, x);
        int rootY = findRoot(parent, y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        items.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        items.add(Arrays.asList("Mary", "mary@mail.com"));
        items.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> groups = groupSimilarItems(items);

        System.out.println(groups);

        // Output:
        // John john00@mail.com john_newyork@mail.com johnsmith@mail.com
        // Mary mary@mail.com
        // John johnnybravo@mail.com
    }
}
