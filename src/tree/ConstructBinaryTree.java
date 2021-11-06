package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    // 105

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
    Map<Integer, Integer> indexMap = new HashMap<>();

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right){
        if(pre_left > pre_right) return null;

        // find the root index
        int pre_root = pre_left;
        int in_root = indexMap.get(preorder[pre_root]);


        // build the root node
        TreeNode root = new TreeNode(preorder[pre_root]);
        int left_size_subTree = in_root - in_left;

        root.left = buildMyTree(preorder,inorder, pre_left+1,pre_left + left_size_subTree,in_left,in_root-1);
        root.right = buildMyTree(preorder,inorder,pre_left + left_size_subTree+1, pre_right,in_root+1,in_right );

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0;i<n;++i){
            indexMap.put(inorder[i],i);
        }
        return buildMyTree(preorder,inorder, 0,n-1,0,n-1);
    }
}
