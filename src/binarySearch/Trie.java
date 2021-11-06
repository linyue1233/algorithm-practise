package binarySearch;

import java.util.ArrayList;
import java.util.List;

class Trie {
    // 208
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i = 0;i<word.length();++i){
            char c = word.charAt(i);
            int index = c-'a';
            if( node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchNode(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Trie searchNode(String word){
        Trie node = this;
        for(int i = 0;i<word.length();++i){
            char c = word.charAt(i);
            int index = c - 'a';
            if( node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}