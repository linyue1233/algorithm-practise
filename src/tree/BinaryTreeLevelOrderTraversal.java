package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    // 102
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tempAns = new ArrayList<>();
            for(int i = 0;i<len;++i){
                TreeNode tempNode = queue.peek();
                queue.poll();
                tempAns.add(tempNode.val);
                if(tempNode.left != null){
                    queue.add(tempNode.left);
                    tempAns.add(tempNode.left.val);
                }
                if(tempNode.right != null){
                    queue.add(tempNode.right);
                    tempAns.add(tempNode.right.val);
                }
            }
            ans.add(tempAns);
        }
        return ans;
    }
}
