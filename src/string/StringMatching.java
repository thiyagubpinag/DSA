package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatching {
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>(List.of(words));
        result.sort((i, j) -> {
            if (i.length() == j.length()) {
                return i.compareTo(j);
            }
            return i.length() - j.length();
        });
        Arrays.sort(words);
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(j).contains(result.get(i))) {
                    temp.add(result.get(i));
                }
            }
        }
        return temp.stream().distinct().toList();
    }

    public static void main(String[] args) {
        String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        List<String> result = stringMatching(words);
        System.out.println(result);
    }
}
