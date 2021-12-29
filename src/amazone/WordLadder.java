package amazone;

import java.util.*;

public class WordLadder {
    // 127
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<Integer> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<Integer> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited1.contains(i)) {
                        continue;
                    }
                    if (!canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited2.contains(i)) {
                        return count + 1;
                    }
                    visited1.add(i);
                    queue1.offer(i);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++count > 1) return false;
            }
        }
        return count == 1;
    }
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        // find whether endString exist
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        int ans = 0;
//        // de-duplication
//        // Set<String> wordDict = new HashSet<>();
//        // for(String item : wordList){
//        //    wordDict.add(item);
//        // }
//        boolean[] visited = new boolean[wordList.size()];
//        int idx = wordList.indexOf(beginWord);
//        if (idx != -1) {
//            visited[idx] = true;
//        }
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        while (!queue.isEmpty()) {
//            ++ans;
//            int size = queue.size();
//            while (size-- > 0) {
//                String start = queue.poll();
//                for (int i = 0; i < wordList.size(); ++i) {
//                    if (visited[i]) {
//                        continue;
//                    }
//                    String temp = wordList.get(i);
//                    if (!isLadder(start, temp)) {
//                        continue;
//                    }
//                    if (temp.equals(endWord)) {
//                        return ans + 1;
//                    }
//                    visited[i] = true;
//                    queue.offer(temp);
//                }
//            }
//
//        }
//
//        return 0;
//
//    }
//
//    private boolean isLadder(String a, String b) {
//        int count = 0;
//        for (int i = 0; i < a.length() && count < 2; ++i) {
//            if (a.charAt(i) != b.charAt(i)) {
//                count++;
//            }
//        }
//        return count == 1;
//    }
}
