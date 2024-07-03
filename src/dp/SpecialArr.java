package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialArr {


    public static int specialArr(List<Integer> nums) {
        //Write your code here
        int[] res = new int[nums.size()];
        Arrays.fill(res, -1);
        boolean[] visited = new boolean[nums.size()];
        getPermutation(nums, 0, true, res, visited);
        return count;
    }

    static int count = 0;

    private static void getPermutation(List<Integer> nums, int index, boolean flag, int[] res, boolean[] visited) {
        if (!flag) {
            return;
        }
        if (index == nums.size()) {
            count++;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!visited[i]) {
                res[i] = nums.get(index);
                visited[i] = true;
                flag = coreLogic(i, res, flag, nums);

                getPermutation(nums, index + 1, flag, res, visited);
                flag = true;
                visited[i] = false;
                res[i] = -1;
            }
        }
    }

    private static boolean coreLogic(int i, int[] res, boolean flag, List<Integer> nums) {
        int max;
        int min;
        if (i == 0 && res[i + 1] != -1) {
            max = Math.max(res[i + 1], res[i]);
            min = Math.min(res[i + 1], res[i]);
            flag = max % min == 0;
        } else if (i == nums.size() - 1 && res[i - 1] != -1) {
            max = Math.max(res[i - 1], res[i]);
            min = Math.min(res[i - 1], res[i]);
            flag = max % min == 0;
        } else if (i > 0 && i < nums.size() - 1) {
            boolean leftCompare = true;
            boolean rightCompare = true;
            if (res[i - 1] != -1) {
                max = Math.max(res[i - 1], res[i]);
                min = Math.min(res[i - 1], res[i]);
                leftCompare = max % min == 0;
            }
            if (res[i + 1] != -1) {
                max = Math.max(res[i + 1], res[i]);
                min = Math.min(res[i + 1], res[i]);
                rightCompare = max % min == 0;
            }
            flag = leftCompare && rightCompare;
        }
        return flag;
    }

    private static void swapValue(int i, int index, int[] res) {
        int temp = res[index];
        res[index] = res[i];
        res[i] = temp;
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(4);
        result.add(5);
        int res = specialArr(result);
        System.out.println(res);
    }
}
