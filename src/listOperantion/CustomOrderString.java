package listOperantion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomOrderString {
    // 791
    public String customSortString(String order, String s) {
        char[] count = new char[26];
        int len1= order.length(), len2 = s.length();

        // record the char in s times of frequence
        for(int i = 0;i<len2;++i){
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        // iterator order, append the appeared char in s to sb
        for(int i = 0;i<len1;++i){
            int temp= order.charAt(i) -'a';
            for(int j = 0;j<count[temp];++j){
                sb.append(order.charAt(i));
            }
            // remove the record
            count[temp] = 0;
        }

        for(int i = 0;i<len2;++i){
            for(int j = 0;j<count[s.charAt(i)-'a'];j++){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
