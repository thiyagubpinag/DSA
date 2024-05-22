package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class KWeakestRows {
    public static int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            int index = binarySearchSoldier(mat[i], 0, mat[i].length - 1);
            List<Integer> tmpList=map.getOrDefault(index,new ArrayList<>());
            tmpList.add(i);
            map.put(index, tmpList);
        }
        int[] res = new int[k];
        int index = 0;
        for (Integer key : map.keySet()) {
            boolean flag=false;
            List<Integer> tmpList=map.get(key);
            for(int i=0;i<tmpList.size();i++){
                if(k<=0){
                    flag=true;
                    break;
                }
                res[index]=tmpList.get(i);
                index++;
                k--;
            }
            if(flag){
                break;
            }
        }
        return res;
    }

    private static int binarySearchSoldier(int[] mat, int low, int high) {
        if (low == mat.length) {
            return low;
        }
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (mat[mid] == 0) {
            if (mid > 0) {
                if (mat[mid - 1] > 0) {
                    return mid;
                } else {
                    return binarySearchSoldier(mat, low, mid - 1);
                }
            } else {
                return 0;
            }
        }
        return binarySearchSoldier(mat, mid + 1, high);
    }

    public static void main(String[] args) {
        int[][] mat =
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}};
        int k = 3;
        int[] res = kWeakestRows(mat, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
