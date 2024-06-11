package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FrequencySort {

    static class FSort {
        Character key;
        Integer value;

        public FSort(char key, int value) {
            this.key = key;
            this.value = value;
        }

        public Character getKey() {
            return key;
        }

        public Integer getValue(){
            return value;
        }
    }

    public static String frequencySort(String s) {
        //Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<FSort> fSortList = new ArrayList<>();
        for (Character c : map.keySet()) {
            FSort fSort = new FSort(c, map.get(c));
            fSortList.add(fSort);
        }


        fSortList.sort((f1, f2) -> {
            // Compare frequencies first (descending order)
            int freqCompare = f2.getValue() - f1.getValue();
            if (freqCompare != 0) {
                return freqCompare;
            }
            // If frequencies are equal, compare characters alphabetically
            return f1.getKey().compareTo(f2.getKey());
        });

        StringBuilder res=new StringBuilder("");
        for(int i=0;i<fSortList.size();i++){
            int temp=fSortList.get(i).value;
            while(temp-->0){
                res.append(fSortList.get(i).key);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = frequencySort("bucket");
        System.out.println(res);
    }
}
