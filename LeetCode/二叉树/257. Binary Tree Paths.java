//使用StringBuilder，需要剪枝。

import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        searchBST(root, sb, list);
        return list;
    }

    private void searchBST(TreeNode root, StringBuilder sb, List<String> list) {
        if (root == null) {
            return;
        }
        int temp = sb.length();
        if (root.left == null && root.right == null) {
            list.add(sb.append(root.val).toString());
            sb.delete(temp, sb.length());
        }
        sb.append(root.val).append("->");
        searchBST(root.left,sb, list);
        searchBST(root.right,sb, list);
        sb.delete(temp, sb.length());
    }
}

//使用String，不需要减枝。
import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        searchBST(root,"",list);
        return list;
    }

    private void searchBST(TreeNode root, String path, List<String> list) {
        path = path + root.val;
        if (root.left == null && root.right == null){
            list.add(path);
        }
        path = path + "->";
        if (root.left != null) {
            searchBST(root.left, path,list);
        }
        if (root.right != null) {
            searchBST(root.right, path,list);
        }
    }
}