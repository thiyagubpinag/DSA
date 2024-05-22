package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MinSwaps {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,0};
        int res = minSwaps(nums);
        System.out.println(res);
    }

    public static int minSwaps(int[] newArr) {
        int[] arr=new int[2*newArr.length];
        for(int i=0;i<2*newArr.length;i++){
            arr[i]=newArr[i% newArr.length];
        }
        double a=Math.pow(2,3);
        double b=Math.abs(-3);
        System.out.println(a);
        System.out.println(b);

        int totalCount = 0;

        // Count total no of ones
        int i;
        for(i = 0; i < newArr.length; i++)
            totalCount += arr[i];

        int currCount = 0; // To store count of ones in current window
        int maxCount = 0;  // To store maximum count ones out
        // of all windows

        // start of window
        i = 0;

        // end of window
        int j = 0;

        while (j < arr.length)
        {
            currCount += arr[j];

            // update maxCount when reach window size i.e.
            // total count of ones in array
            if ((j - i + 1) == totalCount)
            {
                maxCount = Math.max(maxCount, currCount);
                if (arr[i] == 1)
                    currCount--; // decrease current count
                // if first element of
                // window is 1

                // slide window
                i++;
            }
            j++;
        }

        return totalCount - maxCount; // return total no of ones in array
        // - maximum count of ones out of
        // all windows
    }
}
