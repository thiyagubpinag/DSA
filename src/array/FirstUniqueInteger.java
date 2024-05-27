package array;

import java.util.LinkedHashMap;

public class FirstUniqueInteger {
    public static int firstUniqueInteger(int[] v) {
        if(v.length<1){
            return -1;
        }
        if(v.length==1){
            return v[0];
        }
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap();

        for(int i=1;i<v.length;i++){
            map.put(v[i],map.getOrDefault(v[i],0)+1);
        }

        for(Integer key:map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        firstUniqueInteger(new int[]{9, 6, 7, 6});
    }
}
