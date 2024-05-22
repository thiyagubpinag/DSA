package string;

public class SortString {
    public static String sortString(String s) {
        int arr[]=new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        while(true){
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(arr[i]!=0){
                    flag=false;
                    sb.append((char)('a'+i));
                    arr[i]--;
                }
            }
            for(int i=25;i>=0;i--){
                if(arr[i]!=0){
                    flag=false;
                    sb.append((char)('a'+i));
                    arr[i]--;
                }
            }
            if(flag)    break;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((char) 97);
        String s = "leetcode";
        String res = sortString(s);
        System.out.println(res);
    }
}
