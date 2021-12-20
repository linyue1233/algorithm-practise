package amazone;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    // 909
    public int snakesAndLadders(int[][] board) {
        //[cur+1,min(cur+6,n^2)]
        int n = board.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n*n+1];
        // the first means the index of matrix, the second means movement
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i = 1;i<=6;++i){
                int next = temp[0]+i;
                // out of boundary
                if(next > n*n){
                    break;
                }
                int[] index = transformMatrix(next,n);
                if(board[index[0]][index[1]] > 0){
                    next = board[index[0]][index[1]];
                }
                if(next == n*n){
                    return temp[1]+1;
                }
                if( !visited[next] ){
                    queue.offer( new int[]{next,temp[1]+1} );
                    visited[next] = true;
                }
            }
        }
        return -1;
    }

    private int[] transformMatrix(int next, int n){
        int r = (next-1) / n, c = (next-1) % n;
        if(r%2==1){
            c = n-1-c;
        }
        return new int[]{n-1-r,c};
    }
}
