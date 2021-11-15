package tree;

import java.util.*;

public class BinarySearchTreeToGST {
    // 1038
    public static class TreeNode {
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

    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        storeMap(root);
        computeTree();
        transTree(root);
        return root;
    }

    private void storeMap(TreeNode root){
        if(root == null){
            return;
        }
        sum += root.val;
        list.add(root.val);
        storeMap(root.left);
        storeMap(root.right);
    }

    private void computeTree(){
        list.sort(Comparator.comparingInt(a -> a));
        int index = 1;
        List<Integer> store = new ArrayList<>(list);
        map.put(list.get(0), sum);
        list.set(0,sum);
        while(index < list.size() ){
            int temp = list.get(index);
            list.set(index , list.get(index - 1)- store.get(index-1) );
            map.put(temp, list.get(index));
            index++;
        }
    }

    private void transTree(TreeNode root){
        if(root == null){
            return;
        }
        root.val = map.get(root.val);
        transTree(root.left);
        transTree(root.right);
    }
}
