import java.util.ArrayList;

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
//法一： 麻烦点
public class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        inOrder(pRoot);
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}

// 法二： 最优解，比较巧妙，设置一个计数器
public class Solution {
    private TreeNode ret;
    private int cnt = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        inOder(pRoot, k);
        return ret;
    }

    private void inOder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOder(node.left, k);
        cnt++;
        if (cnt == k) {
            ret = node;
        }
        inOder(node.right, k);
    }

}