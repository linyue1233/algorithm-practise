package amazone;

public class CountUniqueLetterString {
    // 828
    int mod = 100000007;
    public int uniqueLetterString(String s) {
        int ans = 0;
        if(s.length() == 0){
            return 0;
        }
        int[] showLastPos = new int[26];
        int[] contribution = new int[26];
        int cur = 0;
        for(int i = 0;i<s.length();++i){
            char c = s.charAt(i);
            // if c doesn't exist, cur will not change
            cur = cur - contribution[c-'A'];
            // update contribution
            contribution[c-'A'] =  i - (showLastPos[c-'A'] - 1);
            cur = cur + contribution[ c-'A'];
            // update lastPlace
            showLastPos[c-'A'] = i + 1;
            ans += cur;
            ans = ans % mod;
        }
        return ans;
    }

}
