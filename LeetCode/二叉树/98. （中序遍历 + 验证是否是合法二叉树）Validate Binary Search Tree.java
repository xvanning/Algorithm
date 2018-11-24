//看discuss的非递归方法
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
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return isValidBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBSTHelper(TreeNode root,long minVal,long maxValue){
        if(root == null){
            return true;
        }
        if(root.val <= minVal || root.val >= maxValue){
            return false;
        }
        return isValidBSTHelper(root.left,minVal,root.val) && isValidBSTHelper(root.right,root.val,maxValue);
    }
}

//中序遍历（递归方法）：只要在中序遍历那边修改
class Solution {
    private TreeNode pre;
    private boolean ret = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        inOder(root);
        return ret;
    }

    private void inOder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOder(root.left);
        if(pre != null && root.val <= pre.val) {
            ret = false;
        }
        pre = root;
        inOder(root.right);
    }
}

//中序遍历（迭代）：只要在中序遍历那边修改
class Solution {
    public boolean isValidBST(TreeNode root) {
      if (root == null) return true;
      Stack<TreeNode> stack = new Stack<>();
      TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}
}