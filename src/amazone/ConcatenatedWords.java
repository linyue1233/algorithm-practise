package amazone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {
    Trie trie;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        trie = new Trie();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            if (canBeConcatenated(word, 0)) {
                ans.add(word);
            } else {
                trie.addWord(word);
            }
        }
        return ans;
    }

    public boolean canBeConcatenated(String word, int index) {
        if (index > 0 && index == word.length()) {
            return true;
        }
        Trie t = trie;
        for (int i = index; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (t.tree[k] == null) {
                return false;
            }
            t = t.tree[k];
            if (t.isEnd && canBeConcatenated(word, i + 1)) {
                return true;
            }
        }
        return false;
    }

    static class Trie {
        Trie[] tree;
        boolean isEnd;

        public Trie() {
            tree = new Trie[26];
            isEnd = false;
        }

        public void addWord(String s) {
            Trie t = this;
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (t.tree[c - 'a'] == null) {
                    t.tree[c - 'a'] = new Trie();
                }
                t = t.tree[c - 'a'];
            }
            t.isEnd = true;
        }
    }
}
