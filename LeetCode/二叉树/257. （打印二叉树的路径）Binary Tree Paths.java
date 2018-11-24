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
    private void searchBST(TreeNode root, String path, List<String> list){
        if(root == null){
            return;
        }
        path = path + root.val;

        if(root.left == null && root.right == null){
            list.add(path);
        }
        path = path + "->";

        searchBST(root.left, path, list);
        searchBST(root.right, path, list);
    }

}