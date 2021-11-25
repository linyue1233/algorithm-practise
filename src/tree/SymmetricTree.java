package tree;

public class SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null){
            return  false;
        }else if(right == null){
            return false;
        }else if(left.val != right.val){
            return false;
        }

        boolean out = compare(left.left,right.right);
        boolean in = compare(left.right,right.left);

        return out && in;
    }
}
