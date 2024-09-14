package dp;

import java.util.ArrayList;
import java.util.List;

public class DiceComb {
    static List<List<Integer>> result=new ArrayList<>();
    static int getDiceCombination(int n, List<Integer> list) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            result.add(new ArrayList<>(list));
            return 1;
        }
        int ans = 0;
        for (int i = 1; i < 6; i++) {
            list.add(i);
            ans += getDiceCombination(n - i, list);
            list.removeLast();
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 4;
        List<Integer> list = new ArrayList<>();
        int comb = getDiceCombination(n, list);
        System.out.println(result);
    }
}
