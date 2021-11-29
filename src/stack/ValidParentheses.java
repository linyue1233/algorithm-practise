package stack;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {
    // 20
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if( c == '(') stack.push(')');
            else if( c == '[') stack.push(']');
            else if( c == '{') stack.push('}');
            else{
                if( stack.isEmpty() || c != stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
