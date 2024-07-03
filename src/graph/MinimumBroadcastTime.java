package graph;

import java.util.*;

public class MinimumBroadcastTime {

    static class Node {
        int des;
        int weight;


        public Node(int des, int weight) {
            this.des = des;
            this.weight = weight;
        }
    }

    public static int minBroadcastTime(List<List<Integer>> nodes, int n, int k) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        HashMap<Integer, List<Node>> map = new HashMap<>();
        nodes.forEach(i -> {
            List<Node> neighbourList = map.getOrDefault(i.get(0), new ArrayList<>());
            neighbourList.add(new Node(i.get(1), i.get(2)));
            map.put(i.get(0), neighbourList);
        });

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(i -> i.weight));

        queue.add(new Node(k, 0));
        distance[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int src = node.des;
            List<Node> neighBour = map.get(node.des);
            if (neighBour != null && !neighBour.isEmpty()) {
                neighBour.forEach(i -> {
                    int dest = i.des;
                    int destTime = i.weight;
                    if (destTime + distance[src] < distance[dest]) {
                        distance[dest] = destTime + distance[src];
                        queue.add(new Node(dest, distance[dest]));
                    }
                });
            }
        }

        for (int i = 1; i <= n; i++)
            if (distance[i] == Integer.MAX_VALUE) return -1;

        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, distance[i]);

        return max;


    }


    public static void main(String[] args) {
        int nodes = 4;
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(2, 1, 1), Arrays.asList(2, 3, 1), Arrays.asList(3, 4, 1));
        int startNode = 2;

        int minTime = minBroadcastTime(edges, nodes, startNode);
        System.out.println("Minimum broadcast time: " + minTime);
    }
}

