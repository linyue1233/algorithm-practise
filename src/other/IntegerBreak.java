package other;

public class IntegerBreak {
    // 343
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }
        int a = 1;
        while (n > 4) {
            n = n - 3;
            a = a * 3;
        }
        return a * n;
    }

}
