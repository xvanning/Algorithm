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
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            for(int i = 0; i < cnt; i ++){
                TreeNode cur = queue.remove();
                if(i == 0){
                    list.add(cur.val);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }

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