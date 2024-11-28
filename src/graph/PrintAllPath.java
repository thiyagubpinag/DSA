package graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {
    static class Graph{
        private int v;

        // adjacency list
        private ArrayList<Integer>[] adjList;

        // Constructor
        public Graph(int vertices)
        {

            // initialise vertex count
            this.v = vertices;

            // initialise adjacency list
            initAdjList();
        }

        // utility method to initialise
        // adjacency list
        @SuppressWarnings("unchecked")
        private void initAdjList()
        {
            adjList = new ArrayList[v];

            for (int i = 0; i < v; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        // add edge from u to v
        public void addEdge(int u, int v)
        {
            // Add v to u's list.
            adjList[u].add(v);
        }
    }

    public static void main(String[] args)
    {
        // Create a sample graph
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        System.out.println(
                "Following are all different paths from "
                        + s + " to " + d);
        printAllPaths(g,s, d);
    }

    private static void printAllPaths(Graph g, int s, int d) {
        List<Integer> path=new ArrayList<>();
        boolean[] visited=new boolean[g.v];
        path.add(s);
        visited[s]=true;
        g.adjList[s].forEach(v-> printAllPathsUtils(visited,path,g,v,d));
    }

    private static void printAllPathsUtils(boolean[] visited,List<Integer> path, Graph g, int s, int d) {

        visited[s]=true;
        path.add(s);
        if(s==d){
            System.out.println(new ArrayList(path));
        }else{
            g.adjList[s].forEach(v->{
                if(!visited[v]){
                    printAllPathsUtils(visited,path,g,v,d);
                }
            });
        }
        visited[s]=false;
        path.removeLast();

    }
}
