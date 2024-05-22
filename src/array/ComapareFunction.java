package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComapareFunction {
    static class Compare {
        int key;
        int value;
        int temp;

        public Compare(int key, int value, int temp) {
            this.key = key;
            this.value = value;
            this.temp = temp;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public int getTemp() {
            return temp;
        }
    }

    public static void main(String[] args) {
        List<Compare> compareList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            compareList.add(new Compare(i, i + 1, i + 2));
        }
        compareList.add(new Compare(2, 2, 2));

        Collections.sort(compareList, (i1, i2) -> {
            if (i1.getKey() == i2.getKey()) {
                return i1.getValue() - i2.getValue();
            }
            return i1.getKey() - i2.getKey();
        });

        List<Integer> complist = compareList.stream().map(Compare::getKey).toList();
        complist.forEach(System.out::println);

        int[] a={1,2,3,-9,4,5};
        swapArr(a,0,2);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

    }

    private static void swapArr(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public int solve(ArrayList<Integer> arr, int x) {
        //Write your code here
        AtomicInteger at = new AtomicInteger();
        arr.forEach(val -> {
            if (val > x) {
                at.getAndIncrement();
            }
        });

        return at.get();

    }
}
