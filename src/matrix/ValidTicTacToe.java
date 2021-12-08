package matrix;

import java.util.HashMap;
import java.util.Map;

public class ValidTicTacToe {
    // 794
    public boolean validTicTacToe(String[] board) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<3;++i){
            for(int j  = 0;j<3;++j){
                char c = board[i].charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        int countX = map.getOrDefault('X',0), countO = map.getOrDefault('O',0);
        if( countX < countO || countX - countO > 1){
            return false;
        }
        boolean isA = false, isB = false;
        // only eight ways to vaild one way
        isA = checkVaild('X',board);
        isB = checkVaild('O',board);
        System.out.println(isA);
        System.out.println(isB);
        if(isA && isB){
            return false;
        }else if(isA){
            if(countX == countO){
                return false;
            }else{
                return true;
            }
        }else if(isB){
            if(countX > countO){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    private boolean checkVaild(char c, String[] board){
        if((board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c ) || (board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c)
                || (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c ) || (board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c)
                || (board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c ) || (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)
                || (board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c ) || (board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c)){
            return true;
        }else{
            return false;
        }
    }
}
