package com.jpmorgan;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        char[] inputList="LLLEEEMMHHHHHHCCCCCCC".toCharArray();
        int k=3;
        HashMap<Character,Integer> map=new HashMap<>();
        int n=inputList.length;
        for(int i=0;i<n;i++){
            map.put(inputList[i],map.getOrDefault(inputList[i],0)+1);
        }


        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        pq.addAll(map.entrySet());

        for(int i=0;i<k;i++){
            System.out.println(pq.poll().getKey());
        }

        //
        int[][] inp={{1,3},{2,6},{8,10},{15,18}};
        merge(inp);


    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));


        int i=0;
        int n=intervals.length;
        Stack<int[]> stack=new Stack();
        while(i<n){
            if(stack.isEmpty()){
                stack.add(intervals[i]);
            }else{
                int[] temp=stack.peek();
                if(intervals[i][0]<=temp[1] && intervals[i][1]>temp[1]){
                    temp[1]=intervals[i][1];
                }else if(intervals[i][1]<=temp[1]){
                    //
                }else{
                    stack.add(intervals[i]);
                }
            }
            i++;
        }
        int[][] output=new int[stack.size()][2];

        for(int j=stack.size()-1;j>=0;j--){
            int[] temp=stack.pop();
            output[j]=temp;
        }

        return output;


    }
}











