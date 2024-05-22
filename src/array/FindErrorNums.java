package array;

import java.util.HashSet;

public class FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int max = Integer.MIN_VALUE;
        int mis = -1, dup = -1;
        HashSet<Integer> sortedSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (sortedSet.contains(nums[i])) {
                dup = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            sortedSet.add(nums[i]);
        }
        for(int i=1;i<=max+1;i++){
            if(!sortedSet.contains(i)){
                mis=i;

            }
        }
        res[0]=dup;
        res[1]=mis;
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3, 2, 2,4};
        int[] res = findErrorNums(nums);
        System.out.println(res[0] + "," + res[1]);

        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        System.out.println(xor);

    }
}
