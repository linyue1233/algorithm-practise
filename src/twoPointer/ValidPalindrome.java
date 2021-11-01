package twoPointer;

public class ValidPalindrome {
    //125
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left <= right){
            if( !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if( !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else{
                if( Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ){
                   return false;
                }else{
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "a";
//        System.out.println(a.substring(0,1));
        System.out.println(isPalindrome(a));
    }
}
