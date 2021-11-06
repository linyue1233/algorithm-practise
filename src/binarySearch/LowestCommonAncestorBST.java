package binarySearch;

public class LowestCommonAncestorBST {
    // 235 this is binary search tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // System.out.println(root.val);
        if (root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) {
            return root;
        } else {
            if (root.val < Math.min(p.val, q.val)) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
        }
    }
}
