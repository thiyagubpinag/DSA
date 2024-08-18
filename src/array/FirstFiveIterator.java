package array;

import java.util.Iterator;
import java.util.List;

public class FirstFiveIterator implements Iterator<Integer> {
    List<Integer> values;
    int size;
    int capacity = 5;

    public FirstFiveIterator(List<Integer> values) {
        this.values = values;
        this.size = values.size();
    }

    @Override
    public boolean hasNext() {
        if (size < capacity) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Integer next() {
        return values.get(--size);
    }
}
