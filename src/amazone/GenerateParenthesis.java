package amazone;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    // 22 recursion and pruning dfs
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if( n == 0){
            return ans;
        }
        help(new StringBuilder(), n, ans,0,0);
        return ans;
    }

    private void help(StringBuilder sb, int n, List<String> ans,int left, int right){
        if( left > n || right >n || left < right){
            return;
        }
        if( left == n && right == n){
            ans.add(sb.toString());
            return;
        }
        help(sb.append('('), n,ans,left+1,right);
        sb.deleteCharAt(sb.length()-1);
        help(sb.append(')'), n,ans,left,right+1);
        sb.deleteCharAt(sb.length()-1);
        return;
    }
}
