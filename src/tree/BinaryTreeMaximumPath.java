package tree;

public class BinaryTreeMaximumPath {
    // 124
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
    int maxAns = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return maxAns;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int maxLeft = Math.max(0, dfs(root.left));
        int maxRight = Math.max(0,dfs(root.right));
        maxAns = Math.max(maxAns, root.val + maxLeft + maxRight);
        return root.val + Math.max(maxLeft, maxRight);
    }

}
