package amazone;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumber {
    // 386
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for(int i = 1;i<=9;++i){
            if(i>n) break;
            ans.add(i);
            dfs(i,n);
        }
        return ans;
    }

    private void dfs(int num, int n){
        if( num > n){
            return;
        }
        int temp = num * 10;
        for(int i = 0;i<=9;++i){
            if( temp + i > n) break;
            ans.add(temp + i);
            dfs(temp+i,n);
        }
    }
}
