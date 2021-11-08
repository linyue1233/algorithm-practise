package graph;

import java.util.*;

public class CourseSchedule {
    // 207
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] inStore = new int[numCourses];
        for(int i = 0;i<numCourses;++i){
            edges.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            edges.get(item[1]).add(item[0]);
            inStore[item[0]]++;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inStore[i] == 0) {
                deque.offer(i);
            }
        }

        int visited = 0;
        while (!deque.isEmpty()) {
            ++visited;
            int temp = deque.poll();
            for(int item : edges.get(temp)){
                inStore[item]--;
                if(inStore[item] == 0){
                    deque.offer(item);

                }
            }
        }

        return visited == numCourses;
    }
}
