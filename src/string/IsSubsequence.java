package string;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        if(s.length()==0 || t.length()==0){
            return false;
        }
        char[] ttempArr = t.toCharArray();
        char[] stempArr = s.toCharArray();
        int n = ttempArr.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if(left == s.length()){
                return true;
            }
            if (stempArr[left] == ttempArr[right]) {
                left++;
            }
            right++;
        }

        System.out.println("b");

        return left == s.length();

    }

    public static void main(String[] args) {
        String a = "b";
        String b = "abc";
        isSubsequence(a, b);
    }
}
