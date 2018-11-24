/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//法一：直接进行比较

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return symmetrical(pRoot.left, pRoot.right);
    }
    boolean symmetrical(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 != null && t2 != null && t1.val == t2.val){
            return symmetrical(t1.left, t2.right) && symmetrical(t1.right, t2.left);
        }
        return false;
    }
}

// 法二：拷贝一份原二叉树，然后翻转原二叉树，与拷贝的二叉树进行比较。
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        TreeNode copy = copyTree(pRoot);
        mirror(pRoot);
        return isSameTree(copy, pRoot);
    }

    // 翻转二叉树
    void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // 拷贝原二叉树
    TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copy = new TreeNode(root.val);
        copy.left = copyTree(root.left); // 拷贝左子树
        copy.right = copyTree(root.right);// 拷贝右子树
        return copy;
    }

    // 验证是否是相同的树
    boolean isSameTree(TreeNode copy, TreeNode pRoot) {
        if (copy == null && pRoot == null) {
            return true;
        }

        if (copy != null && pRoot != null && copy.val == pRoot.val) {
            return isSameTree(copy.left, pRoot.left) && isSameTree(copy.right, pRoot.right);
        }
        return false;
    }
}