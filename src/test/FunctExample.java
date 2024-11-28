package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctExample {

    static class CustomMap {
        int key;
        int value;

        public CustomMap(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public CustomMap() {

        }
    }

    public static void main(String[] args) {
        List<Map<String,String>> inputList = new ArrayList<>();

        HashMap<String,String> map=new HashMap<>();
        map.put("a","b");
        map.put("b","c");

        inputList.add(map);
        List<Map<String,String>> inputListStream=inputList.stream().toList();

        System.out.println(inputListStream.get(0).put("b","d"));

        System.out.println(inputListStream);

        //int k=3;

//        List<Integer> outputList=getTopElements(inputList,k);
//        System.out.println(outputList);
    }

    public static List<Integer> getTopElements(List<Integer> inputList, int k) {

        List<Integer> ouptutList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer input : inputList) {
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<CustomMap> customMapList = new ArrayList<>();
        map.forEach((key, value) -> {
            customMapList.add(new CustomMap(key, value));
        });

        customMapList.sort((i, j) -> {
            return Integer.compare(j.value, i.value);
        });

        for (int i = 0; i < k; i++) {
            ouptutList.add(customMapList.get(i).key);
        }

        return ouptutList;
    }

}
//o(nlogn)
//o(n)