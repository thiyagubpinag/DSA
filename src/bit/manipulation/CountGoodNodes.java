package bit.manipulation;

import java.util.ArrayList;
import java.util.List;

public class CountGoodNodes {
    public static int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adjList = new ArrayList();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
        }

        return getCountNodes(adjList, 0);
    }

    public static int getCountNodes(List<List<Integer>> adjList, int u) {
        if (adjList.get(u).isEmpty()) {
            return 1;
        }
        boolean flag = true;
        int prevVal = -1;
        int count = 0;
        int totalCount=0;
        for (Integer v : adjList.get(u)) {
            int countNodes = getCountNodes(adjList, v);
            if (count == 0) {
                prevVal = countNodes;
            } else if (prevVal != countNodes) {
                flag = false;
            }
            count++;
            prevVal = countNodes;
            totalCount+=countNodes;
        }
        if (flag) {
            return (adjList.get(u).size()*prevVal) + 1;
        }
        return totalCount;
    }


    public static void main(String[] args) {
        int[][] a = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int res = countGoodNodes(a);
        System.out.println(res);
    }
}
