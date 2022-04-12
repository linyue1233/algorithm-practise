package amazone;

public class MaxPathSum {
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

        int maxValue = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return maxValue;
        }


        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = Math.max(0, dfs(root.left));
            int rightMax = Math.max(0, dfs(root.right));
            maxValue = Math.max(maxValue, root.val + leftMax + rightMax);
            // ca only choose one branch
            return root.val + Math.max(leftMax, rightMax);

        }
    }
