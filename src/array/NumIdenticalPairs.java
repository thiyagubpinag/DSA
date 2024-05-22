package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumIdenticalPairs {
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, List<Integer>> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            List<Integer> tempList=map.getOrDefault(nums[i],new ArrayList());
            tempList.add(i);
            map.put(nums[i],tempList);
        }
        int sum=0,n;
        for(Integer key:map.keySet()){
            n=map.get(key).size();
            if(n>=2){
                sum+=(n*(n-1))/2;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
       int[] arr={1,2,3,1,1,3};
        int res=numIdenticalPairs(arr);
        System.out.println(res);
    }
}
