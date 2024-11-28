package test;


import java.util.*;

class TrieNodeEx {
    TrieNodeEx[] children = new TrieNodeEx[2]; // 0 and 1 branches
    int value = -1; // Stores the value associated with the end of a word (optional)
}

class Trie {
    TrieNodeEx root;

    public Trie() {
        root = new TrieNodeEx();
    }

    public void insert(int num) {
        TrieNodeEx curr = root;
        for (int i = 31; i >= 0; i--) { // Iterate from MSB to LSB
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNodeEx();
            }
            curr = curr.children[bit];
        }
    }

    public int findMaxXor(int num) {
        TrieNodeEx curr = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = (bit ^ 1);

            // Prioritize following the branch with a child (potential match or larger value)
            if (curr.children[oppositeBit] != null) {
                maxXor += (1 << i); // Update maxXor with the current bit value
                curr = curr.children[oppositeBit];
            } else if (curr.children[bit] != null) {
                curr = curr.children[bit];
            } else {
                return -1; // No matching path found
            }
        }
        return maxXor;
    }
}

public class MAXXORPair {

    public static int findMaxXorPair(int[] arr) {
        Trie trie = new Trie();
        for (int num : arr) {
            trie.insert(num);
        }

        int maxXor = -1;
        for (int num : arr) {
            int currXor = trie.findMaxXor(num);
            maxXor = Math.max(maxXor, currXor);
        }
        return maxXor;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int maxXor = findMaxXorPair(arr);
        System.out.println("Max XOR pair: " + maxXor);
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
    }
    public String kthLargestElement(String[] arr, int k) {
        Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));
        return String.valueOf(arr[arr.length-k]);
    }
}
