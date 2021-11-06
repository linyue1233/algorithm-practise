package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestInTree {
    // 230
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

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();


        while( !stack.isEmpty() || root != null){
            // when root is rightNode and null, it will pop the pre-node
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            if( ans.size() >= k){
                return ans.get(k-1);
            }
            root = root.right;
        }
        return 0;
    }
}
