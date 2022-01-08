package other;

public class CountPrime {
    // 204
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int ans = 0;
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; ++i) {
            if (!prime[i]) {
                ans++;
                for (int j = 2 * i; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }
        return ans;
    }
}
