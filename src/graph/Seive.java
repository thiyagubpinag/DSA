package graph;

import java.util.*;

public class Seive {

    static class Graph{
        int V;
        List<List<Integer>> adjList=new ArrayList<>();

        public Graph(int v) {
            V = v;
            for(int i=0;i<v;i++){
                adjList.add(new ArrayList<>());
            }
        }

        void addList(int u,int v){
            adjList.get(u).add(v);
        }
    }

    static Set<String> primeSet=new HashSet<>();
    static void sieveOfEratosthenes(int n,int start)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for(int i = start; i <= n; i++)
        {
            if(prime[i] == true) {
                primeSet.add(String.valueOf(i));
            }
        }
    }
    public static void main(String[] args) {
        int start=1000;
        int end=9999;
        sieveOfEratosthenes(end,start);
        System.out.println(primeSet);

        Graph graph=new Graph(9999);
        for(String prime:primeSet){
            makeGraph(graph,prime);
        }

        System.out.println(graph);

        int src= 1033;
        int des=8179;

        if(primeSet.contains(String.valueOf(src)) && primeSet.contains(String.valueOf(des))){
            System.out.println(makeBfs(src,des,graph.adjList));
        }else{
            System.out.println("Not able to found.");
        }

    }

    private static int makeBfs(int src, int des, List<List<Integer>> adjList) {
        Queue<Integer> queue=new LinkedList<>();

        queue.add(src);
        int level=0;
        boolean[] visited=new boolean[9999];
        visited[src]=true;
        while(!queue.isEmpty()){
            int qSize=queue.size();
            for(int i=0;i<qSize;i++){
                Integer val=queue.poll();
                if(val==des){
                    return level+1;
                }
                for(Integer v : adjList.get(val)){
                    if(!visited[v]){
                        visited[v]=true;
                        queue.add(v);
                    }
                }
            }
            level++;
        }

        return -1;

    }

    private static void makeGraph(Graph graph, String prime) {
        for(int i=0;i<prime.length();i++){
            for(char j='1';j<='9';j++){
                if(prime.charAt(i)!=j){
                    String value= prime.substring(0, i) + j + prime.substring(i+1);
                    if(primeSet.contains(value)){
                        graph.addList(Integer.parseInt(prime),Integer.parseInt(value));
                    }
                }
            }
        }
    }
}
