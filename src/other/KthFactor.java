package other;

public class KthFactor {
    // 1492
    public int kthFactor(int n, int k) {
        int i = 1;
        for(;i*i<n;++i){
            if(n%i==0 && --k==0){
                return i;
            }
        }
        if( i*i != n){
            i = i - 1;
        }
        for(;i>0;--i){
            if( n % i== 0 && --k==0){
                return n/i;
            }
        }
        return -1;
    }
}
