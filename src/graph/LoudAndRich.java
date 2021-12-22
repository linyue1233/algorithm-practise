package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoudAndRich {
    // 851
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] answer = new int[n];
        int[] store = new int[n];
        List<Integer>[] graph = new List[n];
        for(int i = 0;i<n;++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] item : richer){
            graph[item[0]].add(item[1]);
            store[item[1]]++;
        }
        for(int i = 0;i<n;++i){
            answer[i] = i;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;++i){
            if(store[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int item : graph[temp]){
                if(quiet[answer[item]] > quiet[answer[temp]]){
                    answer[item] = answer[temp];
                }
                // no one have more money than item
                if(--store[item] == 0){
                    queue.offer(item);
                }
            }
        }
        return answer;
    }
}
