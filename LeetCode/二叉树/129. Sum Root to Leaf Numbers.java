// 基于257题。 

import java.util.ArrayList;

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
    public int sumNumbers(TreeNode root) {
        ArrayList<String> list = findPath(root);
        int res = 0;
        if (root == null) {
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            res += Integer.valueOf(list.get(i));
        }
        return res;
    }
    public ArrayList<String> findPath(TreeNode root){
        ArrayList<String> list = new ArrayList<>();
        if (root == null){
            return null;
        }
        searchBST(root,"",list);
        return list;
    }

    private void searchBST(TreeNode root, String path, ArrayList<String> list) {
        path = path + root.val;
        if (root.left == null && root.right == null) {
            list.add(path);
        }

        if (root.left != null) {
            searchBST(root.left,path,list);
        }
        if (root.right != null) {
            searchBST(root.right,path,list);
        }
    }
}