package tree;

import java.util.*;

public class FindDuplicateSubtrees {
    // 652
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        helper(ans,map,root);
        return ans;
    }

    private String helper(List<TreeNode> ans,Map<String,Integer> map, TreeNode root ){
        if(root == null){
            return "#";
        }
        String str;
        str = root.val + " " + helper(ans,map,root.left) + " " + helper(ans, map, root.right);
        if( map.containsKey(str) && map.get(str) == 1){
            ans.add(root);
        }
        map.put( str, map.getOrDefault(str,0)+1);
        return str;
    }
}
