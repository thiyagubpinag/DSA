import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (inStack.isEmpty()) {
                result.add(0);
                inStack.push(nums[i]);
            } else {
                while (!inStack.isEmpty() && inStack.peek() >= nums[i]) {
                    outStack.push(inStack.pop());
                }
                result.add(inStack.size());
                inStack.push(nums[i]);
                while (!outStack.isEmpty()) {
                    inStack.push(outStack.pop());
                }
            }
        }

        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> rIntegers = countSmaller.countSmaller(new int[] { 5, 2, 6, 1 });
        System.out.println(rIntegers);

    }
}
