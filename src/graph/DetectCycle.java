package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {


    static class Graph{
        int v;
        List<List<Integer>> adjList=new ArrayList<>();

        public Graph(int v) {
            this.v = v;
            initList();
        }

        private void initList() {
            for(int i=0;i<v;i++){
                adjList.add(new ArrayList<>());
            }
        }

        private void addEdge(int u,int v){
            adjList.get(u).add(v);
        }

    }

    public static void main(String[] args) {
        Graph graph=new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
       // graph.addEdge(3,1);

        boolean cycleExist=cycle(graph);
        System.out.println(cycleExist);

    }

    private static boolean cycle(Graph graph) {
        boolean[] visited=new boolean[graph.v];
        boolean[] recStack=new boolean[graph.v];

        for(int i=0;i<graph.v;i++){
            if(!visited[i] && cycleUtils(visited,recStack,i,graph)){
                return true;
            }
        }

        return false;

    }

    private static boolean cycleUtils(boolean[] visited,boolean[] recStack,int src, Graph graph) {

        visited[src]=true;
        recStack[src]=true;

        for(Integer v:graph.adjList.get(src)){
            if(!visited[v] && cycleUtils(visited,recStack,v,graph)){
                return true;
            }else if(recStack[v]){
                return true;
            }
        }

        recStack[src]=false;
        return false;
    }
}
