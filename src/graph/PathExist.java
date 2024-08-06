package graph;

import java.util.ArrayList;
import java.util.List;

public class PathExist {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList=new ArrayList();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList());
        }

        for(int i=0;i<n-1;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        return dfs(adjList,source,destination,edges.length,visited);
    }

    public static boolean dfs(List<List<Integer>> adjList, int src, int dest, int n, boolean[] visited){
        if(!visited[src]){
            visited[src]=true;
            if(src==dest){
                return true;
            }
            for(Integer v:adjList.get(src)){
                if(dfs(adjList,v,dest,n,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr={{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n=6;
        int src=0;
        int des=5;
        boolean res=validPath(n,arr,src,des);
        System.out.println(res);
    }
}
