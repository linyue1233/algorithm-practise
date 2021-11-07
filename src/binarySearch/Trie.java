package binarySearch;

import java.util.*;

class WordDictionary {
    // 211
    // key records the length of the list of String
    private Map<Integer, Set<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        if( !map.containsKey(len) ){
            Set<String> temp = new HashSet<>();
            temp.add(word);
            map.put(len, temp);
        }else{
            map.get(len).add(word);
        }
    }

    public boolean search(String word) {
        int len = word.length();
        Set<String> ans = map.get(len);
        if( ans == null){
            return false;
        }
        if(ans.contains(word)) return true;

        for (String item : ans){
            int i = 0;
            for(i = 0;i < len;++i){
                if( item.charAt(i) == word.charAt(i) || word.charAt(i) == '.'){
                    continue;
                }
                break;
            }
            if( i == len) return true;
        }
        return false;
    }

}
