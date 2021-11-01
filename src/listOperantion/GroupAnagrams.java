package listOperantion;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for(String str: strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            List<String> stringList = ans.getOrDefault(key,new ArrayList<>());
            stringList.add(str);
            ans.put(key,stringList);
        }
        return new ArrayList<>(ans.values());
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> ans = new ArrayList<>();
//        if(strs.length == 0) return ans;
//        boolean[] visited = new boolean[strs.length];
//        for(int i = 0;i<strs.length;++i){
//            if(visited[i]){
//                continue;
//            }
//            visited[i] = true;
//            int index = i+1;
//            List<String> temp = new ArrayList<>();
//            temp.add(strs[i]);
//            while(index<strs.length){
//                if(visited[index]){
//                    index++;
//                    continue;
//                }
//                if( isAnagram(strs[i], strs[index])){
//                    visited[index] = true;
//                    temp.add(strs[index]);
//                }
//                index++;
//            }
//            ans.add(temp);
//        }
//        return ans;
//    }
//
//    public static boolean isAnagram(String s, String t) {
//        if( s.length() != t.length()) return false;
//        int[] store= new int[26];
//        for(int i = 0;i < s.length();++i){
//            store[s.charAt(i) -  'a']++;
//        }
//
//        for(int i = 0;i<t.length();++i){
//            char temp = t.charAt(i);
//            if(store[temp - 'a'] ==0){
//                return false;
//            }
//            store[temp - 'a']--;
//        }
//        return true;
//    }

}
