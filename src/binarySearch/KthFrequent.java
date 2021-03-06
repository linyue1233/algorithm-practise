package binarySearch;

import java.util.*;

public class KthFrequent {
    // 347
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        // build a min-heap
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (queue.size() == k) {
                int temp = queue.peek().getValue();
                if (temp < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            } else {
                queue.offer(entry);
            }
        }


        for (int i = k - 1; i >= 0; --i) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashSet<String> books = new HashSet<String>();
        String userInput;

        userInput = scnr.nextLine();
        while (userInput.compareTo("done") != 0) {
            if (books.add(userInput)) {
                System.out.println("a");
            }
            else {
                System.out.println("n");
            }
            userInput = scnr.nextLine();
        }

        System.out.println("Size: " + books.size());
    }
}
