package amazone;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    // 131
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrack(ans,s,new ArrayList<>(),0);
        return ans;
    }

    private void backTrack(List<List<String>> ans, String s, List<String> tempAns, int start){
        if( start == s.length() ){
            ans.add(new ArrayList<>(tempAns));
            return;
        }

        for(int i = start;i<s.length();++i){
            String temp = s.substring(start,i+1);
            if( isPalindrome(temp) ){
                tempAns.add(temp);
                backTrack(ans,s,tempAns,i+1);
                tempAns.remove(tempAns.size()-1);
            }
        }
    }


    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--) ){
                return false;
            }
        }
        return true;
    }
}
