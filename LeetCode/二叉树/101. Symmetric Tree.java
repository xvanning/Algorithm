//和100题相似。
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null){
            return left == right;
        }else if (left.val == right.val){
            return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
        }
        return false;
    }
}

//笨办法，先拷贝，然后反转，然后比较是否相同
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        TreeNode copyTree = copyTree(root);
        TreeNode invertTree = Mirror(root);
        return isSameTree(copyTree, invertTree);
    }

    public TreeNode Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
        return root;
    }

    public TreeNode copyTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = new TreeNode(root.val);
        temp.left = copyTree(root.left);
        temp.right = copyTree(root.right);
        return temp;
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;
        } else if (t1.val == t2.val) {
            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }
        return false;
    }
}