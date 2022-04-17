package amazone;

public class DiameterBinaryTree {
    // 543
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

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftDepth = root.left == null ? 0 : dfs(root.left) + 1;
        int rightDepth = root.right == null ? 0 : dfs(root.right) + 1;
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }

}
