package amazone;

import java.util.*;

public class MostCommonWord {
    // 819
    public String mostCommonWord(String paragraph, String[] banned) {
        // add a special character to store the last word
        paragraph += ".";
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        int count = 0;
        for( char c : paragraph.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }else if(sb.length() > 0 ){
                String temp = sb.toString();
                if(  !set.contains(temp)){
                    map.put(temp, map.getOrDefault(temp,0)+1);
                    if( count < map.get(temp) ){
                        ans = temp;
                        count = map.get(temp);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }
}
