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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (sum == root.val){
            res ++;
        }
        sum -= root.val;
        res += findPath(root.left,sum);
        res += findPath(root.right,sum);
        return res;
    }
}