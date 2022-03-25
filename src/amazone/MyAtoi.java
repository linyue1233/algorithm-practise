package amazone;

public class MyAtoi {
    // 8
    public int myAtoi(String s) {
        int index = 0;
        while( index < s.length() && s.charAt(index) == ' '){
            index++;
        }
        if( index == s.length()){
            return 0;
        }
        boolean flag = true;
        if( s.charAt(index) == '-'){
            flag = false;
            index++;
        }else if(s.charAt(index) == '+'){
            index++;
        }else if(!Character.isDigit(s.charAt(index))){
            return 0;
        }
        int ans = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int temp = s.charAt(index)-'0';
            // avoid that ans out of range
            // ans * 10 + temp will not limit, so put ans signal
            if( ans >(Integer.MAX_VALUE - temp)/10){
                return !flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + temp;
            index++;
        }
        return flag ? ans : -ans;
    }
}
