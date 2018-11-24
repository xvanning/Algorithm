/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//简单题，直接交换就行
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }

        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}