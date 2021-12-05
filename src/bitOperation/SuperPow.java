package bitOperation;

public class SuperPow {
    //372
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        if(a == 1){
            return 1;
        }
        return dfs(a, b, b.length - 1);
    }

    private int dfs(int a,int[]b, int index){
        if(index == -1){
            return 1;
        }
        return pow(dfs(a,b,index-1),10) * pow(a,b[index])%MOD;
    }

    private int pow(int a, int open){
        a = a % MOD;
        int ans = 1;
        while(open-- > 0){
            ans = ans * a % MOD;
        }
        return ans;
    }
}
