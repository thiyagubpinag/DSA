package com.practise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestChain {
    public static void main(String[] args) {
        String[] input = {"xbc","pcxbcf","xb","cxbc","pcxbc"};

        List<List<Integer>> adjList = new ArrayList<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        Arrays.sort(input, Comparator.comparingInt(String::length));
        makeGraph(input, adjList);

        int n = adjList.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (!memo.containsKey(i)) {
                max = Math.max(max, dfsUtil(i, adjList, memo));
            }
        }

        System.out.println(max);
    }

    private static int dfsUtil(int u, List<List<Integer>> adjList, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(u)) {
            return memo.get(u);
        }
        adjList.get(u).forEach(v -> memo.put(u, 1 + dfsUtil(v, adjList, memo)));
        memo.put(u, memo.getOrDefault(u, 1));
        return memo.get(u);
    }

    private static void makeGraph(String[] input, List<List<Integer>> adjList) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i+1; j < n; j++) {
                if (checkOneDiff(input[i], input[j])) {
                    temp.add(j);
                }
            }
            adjList.add(temp);
        }

    }

    private static boolean checkOneDiff(String i, String j) {
        int count=0;
        //ba bca
        if(j.length()!=i.length()+1){
            return false;
        }
        for(int m=0,n=0;m<i.length()&&n<j.length();m++,n++){
            if(i.charAt(m)!=j.charAt(n)){
                count++;
                n++;
            }
        }
        return count<=1;
    }
}
