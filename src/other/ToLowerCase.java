package other;

import java.util.Arrays;

public class ToLowerCase {
    // 709
    public static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();++i){
            char c = s.charAt(i);
            if( c >= 'A' && c <='Z'){
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("HELLO"));
    }
}
