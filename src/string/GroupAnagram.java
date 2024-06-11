package string;

import java.util.*;

public class GroupAnagram {


    public static void main(String[] args) {
        String[] s={"eat", "tea", "tan", "ate" ,"nat" ,"bat"};
        List<List<String>> resultList=groupAnagrams(s);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //Write your code here
        HashMap<Integer,List<String>> map=new HashMap<>();
        int n= strs.length;
        for(int i=0;i<n;i++){
            int key=0;
            for(int j=0;j<strs[i].length();j++){
                key+=(strs[i].charAt(j));
            }
            List<String> tempList=map.getOrDefault(key,new ArrayList<>());
            tempList.add(strs[i]);
            map.put(key,tempList);
        }
        List<List<String>> resultList=new ArrayList<>();
        for(Integer key:map.keySet()){
            Collections.sort(map.get(key));
            resultList.add(map.get(key));
        }

        resultList.sort(Comparator.comparing(List::getFirst));


        return resultList;

    }
}
