package array;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Arrays;
import java.util.Vector;

public class IndexMaxElement {
    public static int indexMaxElement(Vector<Integer> nums) {
        //Write your code here
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) > nums.get(mid - 1) && nums.get(mid) > nums.get(mid + 1)) {
                return mid;
            } else if (nums.get(low) < nums.get(mid) && nums.get(mid) < nums.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 2, 1};
        Vector<Integer> nums=new Vector<>();
        Arrays.stream(a).forEach(i->nums.add(i));
        int index=indexMaxElement(nums);
        System.out.println(index);
    }

}
