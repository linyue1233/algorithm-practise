package slideWindows;

public class PlusOne {
    // 66
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i>= 0 ;--i){
            digits[i]++;
            if(digits[i] % 10 !=0){
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
