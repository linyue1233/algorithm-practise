package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Calculator {
    // 227
    public int calculate(String s) {
        char oper = '+';
        Deque<Integer> nums = new LinkedList<>();
        int result = 0;
        int num = 0;
        for(int i = 0;i<s.length(); ++i){
            char c = s.charAt(i);
            if( c >= '0'){
                num = num * 10 + (c -'0');
            }
            if( (c <'0' && c != ' ') || i == s.length()-1){
                switch(oper){
                    case '+': nums.push(num);break;
                    case '-': nums.push(-num);break;
                    case '*': nums.push( nums.pop()*num );break;
                    case '/': nums.push( nums.pop()/num);break;
                }
                oper = c;
                num = 0;
            }
        }
        while( !nums.isEmpty()){
            result += nums.pop();
        }
        return result;
    }
}
