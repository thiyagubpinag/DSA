package tree;

public class MaxXOR {
    static class TrieNode {
        char data;
        TrieNode[] children;
        boolean isend;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[2];
            isend = false;
            for (int i = 0; i < 2; i++) {
                children[i] = null;
            }
        }
    }

    static void insertWord(String[] words, TrieNode root) {
        //Write your code here
        for (int i = 0; i < words.length; i++) {
            insertWord(root, words[i]);
        }

    }

    static void insertWord(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int) word.charAt(i);
            index -= 48;
            TrieNode child = temp.children[index];
            if (child == null) {
                child = new TrieNode(word.charAt(i));
                temp.children[index] = child;
            }
            temp = child;
        }
        temp.isend = true;
    }

    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        String[] words = new String[n];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String binStr = Integer.toBinaryString(nums[i]);
            words[i] = binStr;
            maxLength = Math.max(maxLength, binStr.length());
        }
        for (int i = 0; i < n; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < maxLength - words[i].length(); j++) {
                res.append("0");
            }
            res.append(words[i]);
            words[i] = res.toString();
        }
        TrieNode root = new TrieNode('/');
        insertWord(words, root);
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder(words[i]);
            String reverseString = stringBuilder.reverse().toString();
            max = Math.max(max, searchReverseString(root, reverseString));
        }
        return binaryToDecimal(String.valueOf(max));
    }

    static int binaryToDecimal(String n) {
        String num = n;
        int dec_value = 0;

        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1') dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }

    private int searchReverseString(TrieNode root, String reverseString) {
        TrieNode temp = root;
        String res = "";
        for (int i = 0; i < reverseString.length(); i++) {
            int index = (int) reverseString.charAt(i);
            index -= 48;
            if (temp.children[index] != null) {
                temp = temp.children[index];
            } else {
                temp = temp.children[1 - index];
            }
            res += temp.data;
        }
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        MaxXOR xor = new MaxXOR();
        int res = xor.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70});
        System.out.println(res);
    }


}
