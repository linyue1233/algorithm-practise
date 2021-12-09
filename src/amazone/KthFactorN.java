package amazone;

public class KthFactorN {
    // 1492
    public int kthFactor(int n, int k) {
        int ans = -1;
        int cur = 1;
        for(;cur * cur <= n;++cur){
            if(n%cur == 0 && --k == 0){
                return cur;
            }
        }
        cur--;
        // same factor as one, if cur^2 != n means cur^2 > n, we need decrease 1
        if( cur * cur == n){
            cur--;
        }
        for(;cur>=1;cur--){
            if(n%cur == 0 && --k == 0){
                return n/cur;
            }
        }
        return -1;
    }
}
