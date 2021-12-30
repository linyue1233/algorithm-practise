package other;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    // 17
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if( digits == "" || digits.length() == 0){
            return ans;
        }

        generateCombination(new StringBuilder(),digits,ans);
        return ans;
    }


    private void generateCombination(StringBuilder sb, String digits, List<String> ans){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        int curNum = digits.charAt(sb.length()) - '0';
        String letters = KEYS[curNum];
        for( char c : letters.toCharArray()){
            sb.append(c);
            generateCombination(sb,digits,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
