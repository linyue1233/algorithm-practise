package stack;

import java.util.Stack;

public class MinimumAddParentheses {
    // 921
    public int minAddToMakeValid(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if( c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    ans++;
                }else{
                    stack.pop();
                }
            }
        }
        return ans + stack.size();

    }
}
