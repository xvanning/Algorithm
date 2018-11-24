/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//简单题。左右深度取最大值
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(roo == null){
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}