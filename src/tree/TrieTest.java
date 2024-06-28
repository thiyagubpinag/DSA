package tree;

public class TrieTest {
    static class TrieNode {
        char data;
        TrieNode[] children;
        boolean isend;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            isend = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static void insertWord(String[] words, TrieNode root) {
        //Write your code here
        for(int i=0;i<words.length;i++){
            insertWord(root,words[i]);
        }

    }

    static void insertWord(TrieNode root, String word) {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-97;
            TrieNode child=temp.children[index];
            if(child==null){
                child=new TrieNode(word.charAt(i));
                temp.children[index]=child;
            }
            temp=child;
        }
        temp.isend=true;
    }

    public static void main(String[] args) {
        TrieNode root=new TrieNode('/');
        String[] words={"big", "brigadier", "bison"};
        insertWord(words,root);
    }
}
