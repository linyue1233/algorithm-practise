package dynamicProgramming;

import java.util.List;

public class WordBreakProblem {
    // 139
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(String word: wordDict){
                int len = word.length();
                if(i>= len && word.equals(s.substring(i-len,i)) ){
                    flag[i] = flag[i] || flag[i-len];
                }
            }
        }
        return flag[s.length()];
    }
}
