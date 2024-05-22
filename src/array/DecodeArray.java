package array;

public class DecodeArray {
    public static void main(String[] args) {
       int[] encoded = {1,2,3};
       int first = 1;
       int[] result=new int[encoded.length+1];
       for(int i=0;i<result.length;i++){
           if(i==0){
               result[i]=first;
           }else{
               result[i]=result[i-1]^encoded[i-1];
           }
       }
       for(int i=0;i<result.length;i++){
           System.out.print(result[i]+",");
       }
    }
}
