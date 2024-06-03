package string;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String res=removeDuplicateLetters("cbacdcbc");
        System.out.println(res);
    }


    public static String removeDuplicateLetters(String s) {
        //Write your code here
        StringBuilder res = new StringBuilder();
        int[] charCount = new int[26];
        int[] visited = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 97;
            charCount[index]++;
        }
        int right = 0;
        while (right < n) {
            if (charCount[s.charAt(right) - 97] > 1) {
                int leftIndex = -1;
                for (int i = 0; i < res.length(); i++) {
                    if (res.charAt(i) == s.charAt(right)) {
                        leftIndex = i;
                        break;
                    }
                }
                if (leftIndex != -1) {
                    res.deleteCharAt(leftIndex);
                    for (int i = res.length()-1; i >= 0; i--) {
                        if (res.charAt(i) < s.charAt(right)) {
                            res.insert(i+1, s.charAt(right));
                            break;
                        }
                    }
                    charCount[s.charAt(right) - 97]--;
                } else {
                    res.insert(res.length(), s.charAt(right));
                }
            } else {
                res.insert(res.length(), s.charAt(right));
            }
            right++;
        }

        return res.toString();
    }
}
