package tree;

public class TreeTilt {
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

    int sum = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }


    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        sum += Math.abs(sumLeft-sumRight);
        return sumLeft+sumRight+root.val;
    }
}
