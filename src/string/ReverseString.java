package string;

public class ReverseString {
    public static void reverseString(char[] s) {
        char[] newRes=new char[s.length];
        reverseString(s.length-1,s,newRes);
        s=newRes;
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+",");
        }
    }

    public static void reverseString(int n,char[] s,char[] newRes) {
        if(n<0){
            return;
        }
        newRes[n]=s[s.length-n-1];
        reverseString(n-1,s,newRes);
    }

    public static void main(String[] args) {
        reverseString("hello".toCharArray());
    }
}
