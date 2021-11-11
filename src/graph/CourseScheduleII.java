package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII {
    // 210
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inStore = new int[numCourses];
        int[] ans = new int[numCourses];
        int count = 0;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0;i<numCourses;++i){
            edges.add(new ArrayList<>());
        }

        for(int[] item:prerequisites){
            edges.get(item[1]).add(item[0]);
            inStore[item[0]]++;
        }

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<numCourses;++i){
            if(inStore[i] == 0){
                deque.offer(i);
                ans[count++] = i;
            }
        }
        int visited = 0;
        while( !deque.isEmpty()){
            visited++;
            int tempItem = deque.poll();
            for(int item : edges.get(tempItem)){
                inStore[item]--;
                if(inStore[item]==0){
                    deque.offer(item);
                    ans[count++] = item;
                }
            }
        }
        if(visited != numCourses){
            return new int[]{};
        }
        return ans;
    }
}
