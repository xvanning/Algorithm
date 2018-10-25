//注意该题只能计算完全二叉树！分别计算左右子树的高度。如果相等就使用公式（2^h - 1 ），用代码表示为（1 << h），否则就进行递归计算左右子树的节点数，再加上根节点1；
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth){
            return (1 << leftDepth) - 1;
        }else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int rightDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rightDepth(root.right) + 1;
    }

    private int leftDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return leftDepth(root.left) + 1;
    }
}