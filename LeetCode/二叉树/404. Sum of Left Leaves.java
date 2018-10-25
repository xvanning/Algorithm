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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}