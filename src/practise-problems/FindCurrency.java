package test;

import java.util.ArrayList;
import java.util.List;

public class FindCurrency {
    public List<Integer> findCurrency(List<Integer> votes) {
        int n = votes.size();
        int[] count = new int[n + 1];

        votes.forEach(i->{
            count[i]++;
        });

        List<Integer> result=new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (count[i] > 1) {
                result.add(i);
            }
        }

        return result;

    }
}
