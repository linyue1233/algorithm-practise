package twoPointer;

public class KDistinctSubString {
    // lintcode 1375
    public long kDistinctCharacters(String s, int k) {
        int n = s.length();
        int[] letters = new int[26];
        int uniqueLetter = 0;
        long ans = 0;
        int end = 0;

        for(int i = 0;i<n;++i){
            while(end < n && uniqueLetter < k){
                char c= s.charAt(end);
                letters[c-'a']++;
                if(letters[c-'a'] == 1){
                    uniqueLetter++;
                }
                end++;
            }

            if(uniqueLetter == k){
                ans += n - end + 1;
            }

            char startChar = s.charAt(i);
            letters[startChar - 'a']--;
            if(letters[startChar - 'a'] == 0){
                uniqueLetter--;
            }

        }
        return ans;
    }
}
