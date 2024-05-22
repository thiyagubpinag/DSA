package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Practice {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer key:map.keySet()){

        }
    }


    public int minAbsoluteDifference(List<Integer> a, int x) {

        if (x == 0) return 0;

        int i = 0, j = i + x;
        TreeSet<Integer> ts = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        while (j < a.size()) {
            ts.add(a.get(i));
            Integer vclr = ts.higher(a.get(j) - 1);
            Integer vcll = ts.lower(a.get(j) + 1);
            if (vcll != null) min = Math.min(min, Math.abs(a.get(j) - vcll));
            if (vclr != null) min = Math.min(min, Math.abs(a.get(j) - vclr));
            j++;
            i++;
        }
        return min;
    }
}
