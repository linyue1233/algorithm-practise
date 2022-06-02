package amazone;

public class DeleteNode {
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

    // 450
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root, curParent = null;
        // find the key
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        // not find the key
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            // node is the most left node, delete
            cur = null;
        } else if (cur.left == null) {
            cur = cur.right;
        } else if (cur.right == null) {
            cur = cur.left;
        } else {
            TreeNode minNode = cur.right;
            TreeNode minParent = cur;
            while (minNode.left != null) {
                minParent = minNode;
                minNode = minNode.left;
            }
            // delete the minNode
            if (minParent.val == key) {
                // only one level, minNode is the min node
                minParent.right = minNode.right;
            } else {
                minParent.left = minNode.right;
            }
            // reset the cur
            minNode.left = cur.left;
            minNode.right = cur.right;
            cur = minNode;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }
}
