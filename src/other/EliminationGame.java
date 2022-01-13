package other;

public class EliminationGame {
    // 390
    public int lastRemaining(int n) {
        if(n==1){
            return 1;
        }
        // 1 means from left, 0 is right
        int flag = 0;
        // size: 表示当前整数列表中的数量；
        // start: 表示第一个有效的整数；
        // dis: 表示两个有效整数之间的距离
        int size = n/2,dis = 2;
        int start = 2;

        while( size > 1){
            if( flag %2==0){
                start = size % 2==0 ? start : start + dis;
            }else{
                start = start + dis;
            }
            size = size / 2;
            dis = dis * 2;
            flag++;
        }
        return start;
    }
}
