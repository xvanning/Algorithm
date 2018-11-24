//Leetcode : 235. Lowest Common Ancestor of a Binary Search Tree https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
//Leetcode : 236. Lowest Common Ancestor of a Binary Tree https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// 235. easy题 二分搜索树的最低公共祖先
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//236. medium 二叉树的最低公共祖先
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){ //如果发现了root等于p或者q，则返回root；
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); //在左子树查找p或者q
        TreeNode right = lowestCommonAncestor(root.right, p, q); //在右子树查找p或者q
        if(left != null && right != null){ // 如果左右子树都不为空，则说明p q节点一左一右。则当前root就为最低公共祖先
            return root;
        }
        return left != null ? left : right; // 左边找到了p或者q就返回左边，不然返回右边。
    }
}