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
    List<List<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> currentPath = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return lists;
        }
        currentPath.add(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null){
            ArrayList<Integer> newPath = new ArrayList<>(currentPath);
            lists.add(newPath);
        }
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        currentPath.remove(currentPath.size() - 1); //回溯
        return lists;
    }
}