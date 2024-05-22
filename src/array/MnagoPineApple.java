package array;

public class MnagoPineApple {
    public static int solve(String s, int n) {
        //Write your code here;
        int totalMangoCount=0;
        int totalPineAppleCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='M'){
                totalMangoCount++;
            }else{
                totalPineAppleCount++;
            }
        }

        int leftMangoCount=0;
        int rightMangoCount;
        int leftPineAppleCount=0;
        int rightPineAppleCount;
        int min=Integer.MAX_VALUE;
        int ans;
        for(int i=0;i<n;i++){
            ans=0;
            if(s.charAt(i)=='M'){
                leftMangoCount++;
            }else{
                leftPineAppleCount++;
            }
            rightMangoCount=totalMangoCount-leftMangoCount;
            rightPineAppleCount=totalPineAppleCount-leftPineAppleCount;
            if(leftMangoCount!=0){
                ans+=(Math.abs(rightMangoCount-leftMangoCount));
            }
            if(leftPineAppleCount!=0){
                ans+=(Math.abs(rightPineAppleCount-leftPineAppleCount));
            }
            min=Math.min(min,ans);
        }

        return min==Integer.MAX_VALUE?-1:min;

    }

    public static void main (String[] args){

        System.out.println(solve("MMPPPPMMMP",10));
    }

}
