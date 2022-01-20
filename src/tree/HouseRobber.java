package tree;

public class HouseRobber {
    // 337
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

        public int rob(TreeNode root) {
            //以当前节点为根能抢到的最大值，0表示不抢当前节点，1表示抢当前节点
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] res = new int[2];
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = root.val + left[0] + right[0];
            return res;
        }
    }
}