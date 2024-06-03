package Recursion;

public class FairDistributionCookies {
    static int[] count;
    static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] arr = {8,15,10,20,8};
        int k = 2;
        count=new int[k];
        fairDistribution(arr,k,0);
        //distributeCookies(arr,k,0);
        System.out.println(ans);
    }

    public static void fairDistribution(int[] arr,int k,int index){
        if(index== arr.length){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                max=Math.max(max,count[i]);
            }
            ans=Math.min(ans,max);
            return;
        }
        for(int i=0;i<k;i++){
            count[i]+=arr[index];
            fairDistribution(arr,k,index+1);
            count[i]-=arr[index];
        }

    }

    public static void distributeCookies(int[] cookies, int k,int index) {
        if(index==cookies.length){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                max=Math.max(max,count[i]);
            }
            ans=Math.min(ans,max);
            return;
        }
        for(int i=0;i<k;i++){
            count[i]+=cookies[index];
            distributeCookies(cookies,k,index+1);
            count[i]-=cookies[index];
        }
    }
}
