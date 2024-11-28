package graph;

import java.util.*;

public class CheapFlight {
    static class Node{
        int v;
        int w;
        int k;
        public Node(int v,int w,int k){
            this.v=v;
            this.w=w;
            this.k=k;
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adjList=new ArrayList();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList());
        }

        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adjList.get(u).add(new Node(v,w,0));
        }

        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(i->i.w));
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        pq.add(new Node(src,0,0));

        while(!pq.isEmpty()){
            Node temp=pq.poll();
            int srcU=temp.v;
            int srcW=temp.w;
            if(srcU==dst){
                return srcW;
            }
            if(temp.k>k){
                continue;
            }

            for(Node node:adjList.get(srcU)){
                int destU=node.v;
                int destW=node.w;
                if(dist[destU]>dist[srcU]+destW){
                    dist[destU]=dist[srcU]+destW;
                    pq.add(new Node(destU,dist[destU],temp.k+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dest=3;
        int k=1;
        int n=4;
        findCheapestPrice(n,flights,src,dest,k);

    }
}
