package amazone;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem {
    // 1268
    class Trie{
        Trie[] next = new Trie[26];
        boolean isEnd;
        String val;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie head = new Trie();
        List<List<String>> ans = new ArrayList<>();
        for(String pro : products){
            Trie temp = head;
            for(int i = 0;i<pro.length();++i){
                char c = pro.charAt(i);
                if(temp.next[c-'a'] == null){
                    temp.next[c-'a'] = new Trie();
                }
                temp = temp.next[c-'a'];
            }
            temp.isEnd = true;
            temp.val = pro;
        }

        for(int i = 0;i<searchWord.length();++i){
            List<String> tempList = new ArrayList<>();
            char c = searchWord.charAt(i);
            if(head != null){
                head = head.next[c-'a'];
            }
            dfs(head,tempList);
            ans.add(tempList);
        }
        return ans;
    }

    private void dfs(Trie head, List<String> tempList){
        if(head == null || tempList.size() == 3) return;
        if(head.isEnd) tempList.add(head.val);
        // search as lexicographically
        for(int i = 0;i<26;++i){
            dfs(head.next[i],tempList);
        }
    }

    // force
//    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        Arrays.sort(products);
//        List<List<String>> ans = new ArrayList<>();
//        for(int i  = 1;i<=searchWord.length();++i){
//            String prefix = searchWord.substring(0,i);
//            List<String> tempList = new ArrayList<>();
//            for(String tempString : products){
//                if(tempString.startsWith(prefix) && tempList.size() < 3){
//                    tempList.add(tempString);
//                }
//            }
//            ans.add(tempList);
//        }
//        return ans;
//    }
}
