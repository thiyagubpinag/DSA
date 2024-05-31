package dp;

import java.io.CharConversionException;

public class Permutation {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("abc");

        permutation(a, "", 0, a.length());
    }

    static void permutation(StringBuilder a, String res, int index, int n) {
       if(index==n-1){
           System.out.println(a.toString());
           return;
       }

       for(int i=index;i<n;i++){
           char temp=a.charAt(i);
           a.setCharAt(i, a.charAt(index));
           a.setCharAt(index, temp);
           permutation(a, res+=temp, index+1, a.length());
           char tempIndex=a.charAt(index);
           a.setCharAt(index, a.charAt(i));
           a.setCharAt(i, tempIndex);
       }

    }

}
