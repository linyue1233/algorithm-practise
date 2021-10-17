package divided;

import java.util.ArrayList;
import java.util.List;

public class AddParentheses {
    // 241
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<expression.length();++i){
            char c = expression.charAt(i);
            if( c == '-' || c == '+' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(Integer itemL : left){
                    for(Integer itemR : right){
                        if( c == '+'){
                            ans.add(itemL+itemR);
                        }else if( c == '-'){
                            ans.add(itemL-itemR);
                        }else{
                            ans.add(itemL*itemR);
                        }
                    }
                }
            }
        }
        if(ans.isEmpty()) ans.add(Integer.valueOf(expression));
        return ans;
    }
}
