package array;

public class MaxConsecutiveAnswers {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAns(answerKey,k,'T'),maxConsecutiveAns(answerKey,k,'F'));
    }

    private static int maxConsecutiveAns(String answerKey, int k, char t) {
        int left=0;
        int right=0;
        int maxLength=0;
        int n=answerKey.length();
        while(right<n){
            if(answerKey.charAt(right++)!=t){
                --k;
            }
            while(k<0){
                if(answerKey.charAt(left++)!=t){
                    ++k;
                }
            }
            maxLength=Math.max(maxLength,right-left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int res=maxConsecutiveAnswers("TTFTTFTT",1);
        System.out.println(res);
    }
}
