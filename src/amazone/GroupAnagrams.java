package amazone;

import java.util.*;

public class GroupAnagrams {
    // 49
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String item : strs){
            char[] temp = item.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            List<String> tempAns = map.getOrDefault(key,new ArrayList<>());
            tempAns.add(item);
            map.put(key,tempAns);
        }
        return new ArrayList<>(map.values());
    }
}
