package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    // 103
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tempList = new ArrayList<>();
            if (flag == 0) {
                for (int i = 0; i < len; ++i) {
                    TreeNode tempNode = queue.pollFirst();
                    tempList.add(tempNode.val);
                    if (tempNode.left != null) {
                        queue.offer(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        queue.offer(tempNode.right);
                    }
                }
                ans.add(tempList);
                flag += 1;
            } else {
                for (int i = 0; i < len; ++i) {
                    TreeNode tempNode = queue.pollLast();
                    tempList.add(tempNode.val);
                    if (tempNode.right != null) {
                        queue.offerFirst(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        queue.offerFirst(tempNode.left);
                    }
                }
                ans.add(tempList);
                flag -= 1;
            }
        }

        return ans;
    }
}
