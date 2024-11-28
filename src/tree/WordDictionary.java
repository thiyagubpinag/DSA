package tree;

public class WordDictionary {
    static class Node {
        char key;
        Node[] nodeArr;
        boolean isEndWord;

        Node(char key) {
            this.key = key;
            this.nodeArr = new Node[26];
            this.isEndWord = false;
        }
    }

    static Node root;

    public WordDictionary() {
        root = new Node('/');
    }

    public void addWord(String word) {
        Node temp = root;
        insertWord(temp, word, 0);
    }

    public void insertWord(Node temp, String word, int i) {
        if (i == word.length()) {
            temp.isEndWord = true;
            return;
        }
        if (temp.nodeArr[word.charAt(i) - 'a'] == null) {
            temp.nodeArr[word.charAt(i) - 'a'] = new Node(word.charAt(i));
        }
        temp = temp.nodeArr[word.charAt(i) - 'a'];
        insertWord(temp, word, i + 1);
    }

    public boolean search(String word) {
        Node temp = root;
        return search(temp, word, 0);
    }

    private boolean search(Node temp, String word, int i) {
        if (i == word.length()) {
            return temp.isEndWord;
        }
        if (temp.nodeArr[word.charAt(i) - 'a'] == null) {
            return false;
        }
        return search(temp.nodeArr[word.charAt(i) - 'a'], word, i + 1);
    }

    public static void main(String[] args) {
        String[] a = {"WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"};
        WordDictionary wd = new WordDictionary();
        wd.addWord("apple");
        boolean res=wd.search("apple");
        System.out.println(res);
    }
}
