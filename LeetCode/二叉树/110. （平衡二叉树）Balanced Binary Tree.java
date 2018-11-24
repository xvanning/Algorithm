//以二叉树的最大深度为基础，加一句判断即可。时间复杂度为O（n）

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return balanced;
        }
        getDepth(root);
        return balanced;
    }
    public int getDepth (TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1){ //加一句判断
            balanced = false;
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }
}