package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sortJumbled {
    static class KeyPair {
        int key;
        int data;

        public KeyPair(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int[] output = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < mapping.length; i++) {
            map.put(i, mapping[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            int sum = 0;
            int temp = 1;
            while (j > 0) {
                int rem = map.get(j % 10);
                sum += (temp * rem);
                j /= 10;
                temp *= 10;
            }
            output[i] = sum;
        }
        List<KeyPair> pairList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairList.add(new KeyPair(nums[i], output[i]));
        }
        pairList.sort((i, j) -> {
            if (i.data != j.data) {
                return Integer.compare(i.key, j.key);
            }
            return 0;
        });

        for(int i=0;i<nums.length;i++) {
            output[i] = pairList.get(i).key;
        }

        return output;


    }

    public static void main(String[] args) {
        int[] mapping = {9,8,7,6,5,4,3,2,1,0};
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        sortJumbled(mapping, nums);
    }
}
