package array;

public class Shuffle {
    public static int[] shuffle(int[] nums, int n) {
        int half=n;
        int start=0;
        int index=0;
        int result[]=new int[n*2];
        for(int i=0;i<n;i++){
            result[index++]=nums[start];
            result[index++]=nums[half];
            half++;
            start++;
        }
        return result;
    }
    public static void main(String[] args){
        int[] result=shuffle(new int[]{2, 5, 1, 3, 4, 7},3);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+",");
        }
    }
}
