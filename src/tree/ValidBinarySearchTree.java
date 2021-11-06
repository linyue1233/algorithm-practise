package tree;

public class ValidBinarySearchTree {
    //98

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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minNode, long maxNode){
        if(root == null) return true;

        if(root.val <= minNode || root.val >= maxNode){
            return false;
        }
        return isValidBST(root.left,minNode,root.val) && isValidBST(root.right,root.val,maxNode);
    }
}
