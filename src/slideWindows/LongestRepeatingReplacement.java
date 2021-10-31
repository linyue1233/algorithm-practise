package slideWindows;

public class LongestRepeatingReplacement {
    // 424
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int[] letters = new int[26];
        int maxAccount = 0;
        while(right < s.length()){
            char temp = s.charAt(right);
            letters[temp - 'A']++;
            maxAccount = Math.max(maxAccount, letters[temp-'A']);
            if(right - left + 1 > maxAccount + k){
                letters[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return s.length() - left;
    }
}
