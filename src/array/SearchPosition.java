package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPosition {
    public static void main(String[] args) {
        int target = 2;
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        int res=searchPosition(arrList,target);

    }
    public static int searchPosition(ArrayList<Integer> arr, int target) {
        int low=0;
        int high=arr.size()-1;
        int res=findBinarySearch(arr,low,high,target);
        System.out.println(res);
        return res;
    }


    public static int findBinarySearch(ArrayList<Integer> arr,int low,int high,int target){
        if (high >= low) {
            int mid = (low + high) / 2;

            if (arr.get(mid) == target)
                return mid;

            if (arr.get(mid) > target)
                return findBinarySearch(arr, low, mid - 1, target);

            return findBinarySearch(arr, mid + 1, high, target);
        }

        return low+1;
    }
}
