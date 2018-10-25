//类似 102，107题。不过反转之后，每一层都只出第一个元素。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (i == 0){
                    list.add(queue.peek().val); //这一句比较关键。
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                queue.poll(); //出队
            }
        }
        return list;
    }
}

//递归方法，只有当深度和list里面的长度相等的时候才加入元素，即每一层只加入一个元素。
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewHelper(list,root,0);
        return list;
    }

    private void rightSideViewHelper(List<Integer> list, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(root.val);
        }
        rightSideViewHelper(list,root.right,depth + 1);
        rightSideViewHelper(list,root.left,depth + 1);
    }
}