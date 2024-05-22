package string;

import java.util.Arrays;
import java.util.HashMap;

public class SortSentence {
    public static String sortSentence(String s) {
        String[] a = s.split(" ");
        String res="";
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put((int) a[i].charAt(a[i].length()-1),a[i].substring(0, a[i].length()-1));
        }
        int n=a.length;
        int k=49;
        while(n>0){
            res+=(map.get(k)+" ");
            k++;
            n--;
        }
        return res.trim();

    }
    public static void main(String[] args) {
        String inp="is2 sentence4 This1 a3";
        String res=sortSentence(inp);
        System.out.println(res);
        String s="a",t="a";
        String test= "edcba";
        char[] ar = test.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        String a="aab";
        String b="bbc";




        System.out.println(sorted);

        int[] res1=reverseArray(3, new int[]{1, 2, 3});
        for(int i=0;i<res1.length;i++){
            System.out.print(res1[i]+" ");
        }
    }

    public static String getSort(String test){
        char[] ar = test.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        Character a=null;
        return sorted;


    }

    public static int[] reverseArray(int n, int[] a) {
        //Write your code here
        int[] res=new int[2*n];
        int low=0;
        int high=(2*n)-1;
        while(low<=high){
            res[low]=a[low];
            res[high]=a[low];
            low++;
            high--;
        }
        return res;
    }
}
