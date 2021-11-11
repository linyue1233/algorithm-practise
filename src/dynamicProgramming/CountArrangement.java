package dynamicProgramming;

public class CountArrangement {
    // 526
    int count = 0;
    public int countArrangement(int n) {
        int[] visited = new int[n+1];
        backTracking(1,n,visited);
        return count;
    }

    public void backTracking(int index , int n, int[] visited){
        if( index == n + 1){
            count++;
            return;
        }
        for(int i = 1;i<=n;++i){
            if( visited[i] == 0){
                visited[i] = 1;
                if( index % i == 0 || i % index ==0){
                    backTracking(index+1,n,visited);
                }
                visited[i] = 0;
            }
        }
    }
}
