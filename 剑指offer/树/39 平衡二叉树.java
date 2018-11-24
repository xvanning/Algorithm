public class Solution {
    boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        treeDepth(root);
        return isBalanced;
    }

    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}