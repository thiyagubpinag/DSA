package tree;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {
    static class TrieNode {
        public char data;
        public TrieNode[] children;
        public boolean isEnd;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            isEnd = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static List<String> autoComplete(String w, List<String> words) {
        if(w.equalsIgnoreCase("")){
            return new ArrayList<>();
        }
        TrieNode root = new TrieNode('/');
        String[] wordsStr = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            wordsStr[i] = words.get(i);
        }
        insertWord(wordsStr, root);
        return generateOutput(w, root);
    }

    static List<String> generateOutput(String word, TrieNode root) {
        List<String> result = new ArrayList();
        TrieNode temp = root;
        String resultStr = "";
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            TrieNode child = temp.children[index];
            resultStr += (child.data);
            if (child == null) {
                return result;
            }
            temp = child;
        }
        generateLower(result,resultStr,temp);
        return result;
    }

    static void generateLower(List<String> result, String resultStr, TrieNode root) {
        TrieNode temp = root;
        if(temp.isEnd){
            result.add(new StringBuilder(resultStr).toString());
        }
        for (int i = 0; i < 26; i++) {
            if (temp.children[i] != null) {
                resultStr += (temp.children[i].data);
                generateLower(result, resultStr, temp.children[i]);
                resultStr=resultStr.substring(0,resultStr.length()-1);
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
            int index = word.charAt(i) - 97;
            TrieNode child = temp.children[index];
            if (child == null) {
                child = new TrieNode(word.charAt(i));
                temp.children[index] = child;
            }
            temp = child;
        }
        temp.isEnd = true;
    }

    public static void main(String[] args) {
        String[] words = {"do", "dont", "no","nope","not","nox", "note", "notes", "den" };
        String word="";
        List<String> result=autoComplete(word,new ArrayList<>(List.of(words)));
        System.out.println(result);

    }
}
