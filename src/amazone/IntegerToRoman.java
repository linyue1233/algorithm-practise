package amazone;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class IntegerToRoman {
    // 12
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < 13; ++i) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }


    // 13
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(int i = 0;i<s.length();++i){
            int curValue = map.get(s.charAt(i));
            if( i < s.length()-1 && curValue < map.get(s.charAt(i+1))){
                ans -= curValue;
            }else{
                ans += curValue;
            }
        }
        return ans;
    }
}

