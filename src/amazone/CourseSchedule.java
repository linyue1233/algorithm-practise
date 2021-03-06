package amazone;

import java.util.*;

public class CourseSchedule {
    // 210
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // store the pre courses number
        int[] store = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        int index = 0;
        for(int i = 0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        for(int item[] : prerequisites){
            edges.get(item[1]).add(item[0]);
            store[item[0]]++;
        }
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<numCourses;++i){
            if(store[i] == 0){
                deque.offerLast(i);
                ans[index++] = i;
            }
        }
        while(index != numCourses && !deque.isEmpty()){
            int size = deque.size();
            for(int i = 0;i<size;++i){
                int temp = deque.pollFirst();
                for(int item : edges.get(temp)){
                    store[item]--;
                    if(store[item] == 0){
                        deque.offerLast(item);
                        ans[index++] = item;
                    }
                }
            }
        }
        return index == numCourses ? ans : new int[]{};
    }
}
