package amazone;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    // 909
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<int[]> deque = new LinkedList<>();
        boolean[] visited = new boolean[n*n+1];
        // the first means the index of matrix, the second means movement
        deque.offer(new int[]{1,0});

        while( !deque.isEmpty()){
            int[] temp = deque.pollFirst();
            for(int i = 1;i<=6;++i){
                int next = temp[0] + i;
                if(next > n * n){
                    break;
                }
                int[] grid = transformMatrix(next,n);
                if(board[grid[0]][grid[1]] > 0){
                    next = board[grid[0]][grid[1]];
                }
                if( next == n*n){
                    return temp[1]+1;
                }
                // avoid repeat circle
                if( !visited[next]){
                    deque.offerLast(new int[]{next,temp[1]+1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }

    // transfer the index
    private int[] transformMatrix(int next, int n){
        int r = (next-1) / n, c = (next-1) % n;
        if(r%2==1){
            c = n-1-c;
        }
        return new int[]{n-1-r,c};
    }
}
