package array;

public class MaxScore {
    public static int maxScore(int[] cardPoints, int k) {
        int max=Integer.MIN_VALUE;
        for(int i=cardPoints.length-k+1;i<cardPoints.length;i++){
            int j=i;
            int sum=0;
            while(j<i+k){
                sum+=cardPoints[j%cardPoints.length];
                j++;
            }
            max=Math.max(max,sum);
            if(i+1==cardPoints.length){
                i=-1;
            }else if(i==0){
                break;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] cardPoints = {100,40,17,9,73,75};
        int k = 3;
        int res=maxScore(cardPoints,k);
        System.out.println(res);
    }
}
