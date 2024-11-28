package array;

public class KadanaAlgo {
    public static void main(String[] args) {
        int[] arr = {-1, -3, -8, -3, 0, -9};

        int maxStraightHere=Integer.MIN_VALUE;
        int minStraightHere=Integer.MAX_VALUE;
        int totalArray=0;
        int minHere=0;
        int maxHere=0;

        int n=arr.length;
        for(int i=0;i<n;i++){
            minHere+=arr[i];
            maxHere+=arr[i];
            totalArray+=arr[i];
            maxStraightHere=Math.max(maxStraightHere,maxHere);
            minStraightHere=Math.min(minStraightHere,minHere);

            maxHere=Math.max(0,maxHere);
            minHere=Math.min(0,minHere);
        }

        if(totalArray==minStraightHere){
            System.out.println(maxStraightHere);
        }else{
            System.out.println(totalArray-(minStraightHere));
        }


    }
}
