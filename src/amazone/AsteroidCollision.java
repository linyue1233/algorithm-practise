package amazone;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision {
    // 735
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (deque.isEmpty()) {
                deque.offerLast(asteroid);
            } else {
                int topNum = deque.peekLast();
                if (notExplode(topNum, asteroid)) {
                    deque.offerLast(asteroid);
                } else {
                    int tempTop = topNum > 0 ? topNum : -topNum;
                    int tempNum = asteroid > 0 ? asteroid : -asteroid;
                    deque.pollLast();
                    if (tempTop == tempNum) {
                        continue;
                    }
                    deque.offerLast(tempTop > tempNum ? topNum : asteroid);
                    checkQueue(deque);
                }
            }
        }
        int[] ans = new int[deque.size()];
        for(int i = 0;i<ans.length;++i){
            ans[i] = deque.pollFirst();
        }
        return ans;
    }

    private static void checkQueue(Deque<Integer> deque){
        if( deque.size() <=1 ){
            return;
        }
        int temp1 = deque.pollLast();
        int temp2 = deque.pollLast();
        if( notExplode(temp2,temp1) ){
            deque.offerLast(temp2);
            deque.offerLast(temp1);
            return;
        }
        while(!notExplode(temp2,temp1)){
            int t1 = temp1>0?temp1:-temp1;
            int t2 = temp2>0?temp2:-temp2;
            if( t1 == t2 ){
                if(deque.size()<=1){
                    break;
                }else{
                    temp1 = deque.pollLast();
                    temp2 = deque.pollLast();
                    if( notExplode(temp2,temp1) ){
                        deque.offerLast(temp2);
                        deque.offerLast(temp1);
                        return;
                    }
                }
                continue;
            }
            deque.offerLast( t1 > t2 ? temp1 : temp2);
            if(deque.size()<=1){
                return;
            }
            temp1 = deque.pollLast();
            temp2 = deque.pollLast();
            if( notExplode(temp2,temp1) ){
                deque.offerLast(temp2);
                deque.offerLast(temp1);
                return;
            }
        }
    }

    private static boolean notExplode(int in, int out){
        if(in >0 && out >0){
            return true;
        }else if(in < 0 && out < 0){
            return true;
        }else{
            return in < 0 && out > 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method2(new int[]{-9,5,-7,5,2,-5,-5,8,3,10})));
    }


    public static int[] method2(int[] asteroids){
        Deque<Integer> deque = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid <= 0) {
                while (!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() < -asteroid) {
                    deque.pollLast();
                }
                if (!deque.isEmpty() && deque.peekLast() == -asteroid) {
                    deque.pollLast();
                } else if (!deque.isEmpty() && deque.peekLast() > -asteroid) {
                    continue;
                } else {
                    deque.offerLast(asteroid);
                }
            } else {
                deque.offerLast(asteroid);
            }
        }
        int[] ans = new int[deque.size()];
        for(int i = 0;i<ans.length;++i){
            ans[i] = deque.pollFirst();
        }
        return ans;
    }
}
