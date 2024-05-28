package array;

public class CardArrangment {
    static int solve(int n, String s, int k) {
        //Write your code here
        int[] temp=new int[2];
        int min=Integer.MAX_VALUE;
        int count=0;
        int i=0;
        int j=0;
        while(i<s.length()){
            if(s.charAt(i)=='B'){
                temp[0]++;
            }else{
                temp[1]++;
            }

            count++;
            if(count==k){
                min=Math.min(min,k-temp[0]);
                if(s.charAt(j)=='B'){
                    temp[0]--;
                }else{
                    temp[1]--;
                }
                j++;
            }
            i++;
        }

        return min;

    }

    public static void main(String[] args) {
        int res=solve(5,"BBRBR",3);
        System.out.println(res);
    }
}
