package string;

import java.util.HashMap;

public class MaxVowels {
    public static int maxVowels(String s, int k) {
        HashMap<Character,Integer> map=new HashMap();
        if(s.length()<k){
            return -1;
        }

        int left=0;
        int right=0;

        char[] charArray=new char[]{'a','e','i','o','u'};
        for(int i=0;i<charArray.length;i++)
            map.put(charArray[i],0);

        int window_size=0;
        int max=Integer.MIN_VALUE;
        while(right<s.length()){
            if(isVowel(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))+1);
            }
            window_size++;
            if(window_size==k){
                int count=0;
                for(Character key:map.keySet()){
                    count+=map.get(key);
                }
                max=Math.max(max,count);
                if(isVowel(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))-1);
                }
                left++;
                window_size--;
            }

            right++;
        }
        return max;

    }

    public static boolean isVowel(Character input){
        return input=='a' || input=='e' || input=='i' || input=='o' || input=='u' ;
    }
    public static void main(String[] args) {
        int res = maxVowels("abciiidef",3);
        System.out.println(res);
    }
}
