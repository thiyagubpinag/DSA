package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSubTopTree {
    public static void main(String[] args) {
        String[] a = {"6", "5", "43", "37", "82"};
        List<String> b = Arrays.stream(a).collect(Collectors.toList());
        b.sort((i, j) -> {
            for (int k = 0; k < i.length(); k++) {
                for (int x = 0; x < j.length(); x++) {
                    int kTemp = Integer.parseInt(String.valueOf(i.charAt(k)));
                    int xTemp = Integer.parseInt(String.valueOf(j.charAt(x)));
                    if (kTemp != xTemp) {
                        return xTemp - kTemp;
                    }
                }
            }
            return 0;
        });
        b.forEach(i-> System.out.print(i));
    }
}

