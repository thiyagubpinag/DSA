package array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class IteratorEx {
    static class Iter {
        List<Integer> values;

        public Iter(List<Integer> values) {
            this.values = values;
        }

        Iterator<Integer> iterator() {
            return new FirstFiveIterator(this.values);
        }

    }


    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        IntStream.range(1,11).forEach(i->values.add(i));
        Iter a=new Iter(values);
        a.iterator().forEachRemaining(i-> System.out.println(i));
    }
}
