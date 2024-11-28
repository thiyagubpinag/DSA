package string;

import java.util.ArrayList;
import java.util.Collections;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaaac");
        list.add("a");
        list.add("aaaab");
        list.add("b");
        Collections.sort(list, (i, j) -> {
            if (i.length() != j.length()) {
                return i.length() > j.length() ? -1 : 1;
            } else {
                return j.compareTo(i);
            }
        });

        System.out.println(list);

    }
}
