package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthTree {

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

    // 104
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            ans++;
            int len = queue.size();
            for(int i = 0;i<len;++i){
                TreeNode tempNode = queue.peek();
                queue.poll();
                if(tempNode.left!=null){
                    queue.add(tempNode.left);
                }
                if(tempNode.right!=null){
                    queue.add(tempNode.right);
                }
            }
        }
        return ans;
    }

//    public int maxDepth(TreeNode root) {
}
