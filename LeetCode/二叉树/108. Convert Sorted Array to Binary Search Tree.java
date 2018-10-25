//与109题类似，找到中间节点。然后依次递归。注意边界条件。
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTHelper(nums,0,nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int head, int tail) {
        if (head >= tail){
            return null;
        }
        int mid = head + (tail - head) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = sortedArrayToBSTHelper(nums,head,mid);
        temp.right = sortedArrayToBSTHelper(nums,mid + 1,tail);
        return temp;
    }
}