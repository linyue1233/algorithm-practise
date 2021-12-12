package amazone;

public class NumberProvinces {
    //547
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int k = isConnected.length;
        boolean[] visited = new boolean[k];
        for(int i = 0;i<k;++i){
            if(!visited[i]){
                ans++;
                dfs(isConnected,i,visited);
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int index, boolean[] visited){
        visited[index] = true;
        for(int i = 0;i<isConnected.length;++i){
            if(isConnected[index][i] == 1 && !visited[i]){
                dfs(isConnected,i,visited);
            }
        }
    }
}
