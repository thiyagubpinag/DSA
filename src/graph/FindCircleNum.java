package graph;

import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindCircleNum {
    class Node {
        int parent;
        int rank;

        public Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < n; i++) {
            int[] connections = isConnected[i];
            for (int j = 0; j < connections.length; j++) {
                if (i != j && connections[j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            nodeList.add(new Node(-1, 0));
        }
        for (int i = 0; i < adjList.size(); i++) {
            unionAdd(nodeList, adjList);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).parent == -1) {
                set.add(i);
            } else {
                set.add(nodeList.get(i).parent);
            }
        }
        return set.size();
    }

    private void unionAdd(List<Node> nodeList, List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> vList = adjList.get(i);
            for (Integer v : vList) {
                int u = i;
                int uPar = findParent(u, nodeList);
                int vPar = findParent(v, nodeList);
                if (uPar != vPar) {
                    union(uPar, vPar, nodeList);
                }
            }
        }
    }

    private void union(int uPar, int vPar, List<Node> nodeList) {
        int uRank = nodeList.get(uPar).rank;
        int vRank = nodeList.get(vPar).rank;
        if (uRank > vRank) {
            nodeList.get(vPar).parent = uPar;
        } else if (uRank < vRank) {
            nodeList.get(uPar).parent = vPar;
        } else {
            nodeList.get(vPar).parent = uPar;
            nodeList.get(uPar).rank++;
        }
    }

    private int findParent(int i, List<Node> nodeList) {
        if (nodeList.get(i).parent == -1) {
            return i;
        }
        Node node = nodeList.get(i);
        node.parent = findParent(nodeList.get(i).parent, nodeList);
        nodeList.set(i, node);
        return nodeList.get(i).parent;
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        int[][] a = {{1, 0, 1}, {0, 1, 1}, {0, 1, 1}};
        int res=findCircleNum.findCircleNum(a);
        System.out.println(res);
    }
}
