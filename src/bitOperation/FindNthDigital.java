package bitOperation;

public class FindNthDigital {
    // 400
    public static int findNthDigit(int n) {
        int d = 1;
        int nine = 9;
        while (n > (long) d * nine) {
            n -= d * nine;
            d++;
            nine = nine * 10;
        }

        // determin the num
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        char c = String.valueOf(num).charAt((index) % d);
        return c - '0';
    }
    

    public static void main(String[] args) {
        findNthDigit(11);
    }
}
