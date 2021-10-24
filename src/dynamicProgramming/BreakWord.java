package dynamicProgramming;

import java.util.List;

public class BreakWord {
    // 139
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(), wordLen = wordDict.size();
        boolean[] flag = new boolean[n+1];
        flag[0] = true;
        for(int i = 1;i<= n;++i){
            for(String item : wordDict){
                int len = item.length();
                if( i>= len && s.substring(i - len, i).equals(item)){
                    flag[i] = flag[i] || flag[i-len];
                }
            }
        }
        return flag[n];
    }
}
