package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDetonation {
    static class Node {
        int x;
        List<Integer> adjacent;

        public Node(int x) {
            this.x = x;
            this.adjacent = new ArrayList<>();
        }

    }


    public static int maximumDetonation(int[][] bombs) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            Node node = new Node(i);
            for (int j = 0; j < bombs.length; j++) {

                if (i != j) {
                    double dx = Math.pow(Math.abs(bombs[i][0] - bombs[j][0]), 2);
                    double dy = Math.pow(Math.abs(bombs[i][1] - bombs[j][1]), 2);
                    double rad = Math.pow(bombs[i][2], 2);
                    if (dx + dy <= rad) {
                        node.adjacent.add(j);
                    }
                }
            }
            nodeList.add(node);
        }
        return bfs(bombs, nodeList);

    }

    private static int bfs(int[][] bombs, List<Node> nodeList) {
        int n = bombs.length;
        int maxDetonated = 1;
        // try each bomb and choose that which contributes maximum detonation.
        for (int i = 0; i < n; i++) {
            int[] detonated = new int[n];
            int currDetonated = 0;
            Queue<Integer> q = new LinkedList<>();

            q.add(i);

            while (!q.isEmpty()) {
                int sz = q.size();
                for (int j = 0; j < sz; j++) {
                    int x = q.poll();
                    detonated[x] = 1;
                    currDetonated++;
                    for (Integer val : nodeList.get(x).adjacent) {
                        if (detonated[val] != 1) {
                            q.add(val);
                            detonated[val] = 1;
                        }
                    }
                }
            }
            maxDetonated = Math.max(maxDetonated, currDetonated);
            if(maxDetonated==bombs.length){
                return bombs.length;
            }
        }

        return maxDetonated;
    }

    public static void main(String[] args) {
        int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        int res = maximumDetonation(bombs);
        System.out.println(res);
    }
}
