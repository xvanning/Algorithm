//广度优先遍历，用队列，最后反转一下list
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            lists.add(0，subList);
        }
        return lists;
    }
}


//深度优先遍历，用一个深度来控制arraylist的项数。
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderHelper(lists,root,0);
        Collections.reverse(lists);
        return lists;
    }

    private void levelOrderHelper(List<List<Integer>> lists, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= lists.size()){
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth).add(root.val);
        levelOrderHelper(lists,root.left,depth + 1);
        levelOrderHelper(lists,root.right,depth + 1);
    }
}