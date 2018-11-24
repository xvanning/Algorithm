//广度优先遍历，用队列
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
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < cnt; i ++){
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            ret.add(new ArrayList<>(list));
        }

        return ret;

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