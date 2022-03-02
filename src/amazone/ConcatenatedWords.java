package amazone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {
    // 472
    Trie trie;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) continue;
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, 0, visited)) {
                ans.add(word);
            } else {
                insertWord(word);
            }
        }
        return ans;
    }

    public boolean dfs(String word, int index, boolean[] visited) {
        if (index == word.length()) {
            return true;
        }
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        Trie t = trie;
        for (int i = index; i < word.length(); ++i) {
            int temp = word.charAt(i) - 'a';
            t = t.tree[temp];
            if (t == null) {
                return false;
            }
            if (t.isEnd && dfs(word, i + 1, visited)) {
                return true;
            }
        }
        return false;
    }

    public void insertWord(String word) {
        Trie t = trie;
        for (int i = 0; i < word.length(); ++i) {
            int temp = word.charAt(i) - 'a';
            if (t.tree[temp] == null) {
                t.tree[temp] = new Trie();
            }
            t = t.tree[temp];
        }
        t.isEnd = true;
    }
}

class Trie {
    Trie[] tree;
    boolean isEnd;

    public Trie() {
        tree = new Trie[26];
        isEnd = false;
    }


}