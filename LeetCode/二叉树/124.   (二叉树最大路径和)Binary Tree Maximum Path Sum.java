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
    int maxVal;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxVal = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxVal;
    }

    private int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathDown(root.left), 0);
        int right = Math.max(maxPathDown(root.right), 0);
        maxVal = Math.max(maxVal, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}