package com.graph.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
    public boolean detectCycleUtil(int u,List<List<Integer>> adjList,boolean[] visited,boolean[] recstack){
        visited[u]=true;
        recstack[u]=true;

        for(Integer v:adjList.get(u)){
            if(!visited[v] && detectCycleUtil(v,adjList,visited,recstack)){
                return true;
            }else if(recstack[v]){
                return true;
            }
        };

        recstack[u]=false;
        return false;

    }


    public boolean detectCycle(int numCourses,List<List<Integer>> adjList){
        boolean[] visited=new boolean[numCourses];
        boolean[] recstack=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(detectCycleUtil(i,adjList,visited,recstack)){
                    return true;
                }
            }
        }

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited=new boolean[numCourses];
        List<List<Integer>> adjList=new ArrayList();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adjList.get(u).add(v);
        }

        if(detectCycle(numCourses,adjList)){
            return new int[0];
        }

        Stack<Integer> stack=new Stack();

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                dfs(i,visited,adjList,stack);
            }
        }

        int[] res=new int[numCourses];
        int index=numCourses-1;
        while(!stack.isEmpty()){
            res[index--]=stack.pop();
        }
        return res;

    }

    public void dfs(int u,boolean[] visited,List<List<Integer>> adjList,Stack<Integer> stack){
        if(!visited[u]){
            visited[u]=true;

            adjList.get(u).forEach(v->{
                dfs(v,visited,adjList,stack);
            });

            stack.push(u);
        }
    }
}
