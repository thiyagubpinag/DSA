package dp;

public class SubsetSumII {
    public static void main(String[] args) {
        int[] cookies = {8, 15, 10, 20, 8};
        int k=2;
        int res=distributeCookies(cookies,k);
        System.out.println(res);

    }
    static int ans=Integer.MAX_VALUE;
    static int[] count;
    public static int distributeCookies(int[] cookies, int k) {
       count =new int[k];
       distributeCookies(cookies,k,0);
       return ans;
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

