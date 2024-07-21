package graph;

import java.util.*;

public class CourseScheudle {

    static class Node {
        int parent;
        int rank;

        Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            nodeList.add(new Node(-1, 0));
        }

        return unionAdd(nodeList, prerequisites, numCourses);
    }

    private static boolean unionAdd(List<Node> nodeList, int[][] edges, int n) {
        for (int[] edge : edges) {
            int start = findParent(edge[0], nodeList);
            int end = findParent(edge[1], nodeList);
            if (start != end) {
                pathCompressionByRank(nodeList, start, end);
            } else {
                return false;
            }
        }
        return true;
    }

    private static int findParent(int x, List<Node> nodeList) {
        Node parentNode = nodeList.get(x);
        if (parentNode.parent == -1) {
            return x;
        }
        int parent = findParent(parentNode.parent, nodeList);
        parentNode.parent = parent;
        nodeList.set(x, parentNode);
        return nodeList.get(x).parent;
    }

    private static void pathCompressionByRank(List<Node> nodeList, int start, int end) {
        Node startNode = nodeList.get(start);
        Node endNode = nodeList.get(end);

        if (startNode.rank > endNode.rank) {
            endNode.parent = start;
        } else if (startNode.rank < endNode.rank) {
            startNode.parent = end;
        } else {
            endNode.parent = start;
            endNode.rank++;
        }

    }

    public static void main(String[] args) {
        int[][] course = {{1,4},{2,4},{3,1},{3,2}};
        boolean flag = canFinish(course.length, course);
        System.out.println(flag);
    }


}
