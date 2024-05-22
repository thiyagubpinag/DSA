package array;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class MaximumFrequency {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 2,2,2,2, 3, 3,3,3));
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>(Collections.reverseOrder());
        for(int i=0;i<a.size();i++){
            map.put(a.get(i),map.getOrDefault(a.get(i),0)+1);
        }
        for(Integer value:map.keySet()){
            System.out.println(map.get(value));
        }

    }
}
