package twoPointer;

import java.util.*;

public class LongestWord {
    //524
//    public static String findLongestWord(String s, List<String> dictionary) {
//        String res = "";
//        for (String item : dictionary) {
//            int i = 0, j = 0;
//            while (i < item.length() && j < s.length()) {
//                if (item.charAt(i) == s.charAt(j)) {
//                    i++;
//                }
//                j++;
//            }
//            if (i == item.length()) {
//                if (i > res.length() || (i == res.length() && item.compareTo(res) < 0)) {
//                    res = item;
//                }
//            }
//        }
//        return res;
//    }

    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,(a,b)-> a.length() != b.length() ? b.length()-a.length() : a.compareTo(b));
        for(String item : dictionary){
            int i = 0;
            for(char c : s.toCharArray()){
                if( i<item.length() && item.charAt(i) == c){
                    i++;
                }
            }
            if( i== item.length()){
                return item;
            }
        }
        return "";
    }
        //abpcplea
    // "ale","apple","monkey","plea"
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        list.add("abpcplaaa");
        list.add("abpcllllll");
        list.add("abccclllpppeeaaaa");
        findLongestWord("abpcplea", list);
    }
}
