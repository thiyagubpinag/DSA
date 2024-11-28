import java.util.HashMap;
import java.util.Map;

public class Qudraplet {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 4, 2, 6 };

        // Preprocessing: Create prefix and suffix maps
        Map<Integer, Map<Integer, Integer>> mp_pre = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> mp_suf = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> tmp = new HashMap<>();
            if (i > 0) {
                tmp.putAll(mp_pre.get(i - 1));
            }
            tmp.put(arr[i], tmp.getOrDefault(arr[i], 0) + 1);
            mp_pre.put(i, tmp);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Map<Integer, Integer> tmp = new HashMap<>();
            if (i < arr.length - 1) {
                tmp.putAll(mp_suf.get(i + 1));
            }
            tmp.put(arr[i], tmp.getOrDefault(arr[i], 0) + 1);
            mp_suf.put(i, tmp);
        }

        // Core logic
        int cnt = 0;
        for (int j = 1; j < arr.length - 1; j++) {
            for (int k = j + 1; k < arr.length - 1; k++) {
                if (j != k) {
                    double r = (double) arr[j] / arr[k];
                    Map<Integer, Integer> d_l = mp_pre.get(j - 1);
                    Map<Integer, Integer> d_r = mp_suf.get(k + 1);

                    int ans = 0;
                    for (Map.Entry<Integer, Integer> entry : d_l.entrySet()) {
                        int x = entry.getKey();
                        int v = entry.getValue();
                        int y = (int) (x * r);
                        if (d_r.containsKey(y)) {
                            ans += v * d_r.get(y);
                        }
                    }
                    cnt += ans;
                }
            }
        }

        System.out.println(cnt);
    }
}
