package test;

public class Test3 {
    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        int numsN = nums.length;
        int queryLen = queries.length;
        int sum = 0;
        for (int i = 0; i < numsN; i++) {
            if (nums[i] > 0) sum += nums[i];
        }
        int res=0;
        for (int i = 0; i < queryLen; i++) {
            int temp=nums[queries[i][0]];
            nums[queries[i][0]]=queries[i][1];
            if(temp>=0){
                sum-=temp;
            }
            if(queries[i][1]>=0){
                sum+=queries[i][1];
            }
            res+=sum;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,3,3,1,-2};
        int[][] queries = {{4,0}, {1, 0}};
        int res = maximumSumSubsequence(nums, queries);
        System.out.println(res);
    }
}
