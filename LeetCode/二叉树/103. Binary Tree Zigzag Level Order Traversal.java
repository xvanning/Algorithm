//非递归，用两个栈
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        boolean isOdd = true;
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(root);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            if (isOdd) {
                while (!oddStack.isEmpty()) {
                    TreeNode currentNode = oddStack.pop();
                    subList.add(currentNode.val);
                    if (currentNode.left != null) {
                        evenStack.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        evenStack.push(currentNode.right);
                    }
                }
                lists.add(subList);
                isOdd = false;
            }else {
                while (!evenStack.isEmpty()){
                    TreeNode currentNode = evenStack.pop();
                    subList.add(currentNode.val);
                    if (currentNode.right != null) {
                        oddStack.push(currentNode.right);
                    }
                    if (currentNode.left != null){
                        oddStack.push(currentNode.left);
                    }
                }
                lists.add(subList);
                isOdd = true;
            }
        }
        return lists;
    }
}

//递归
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        zigzagLevelOrderHelper(lists,root,0);
        return lists;
    }

    private void zigzagLevelOrderHelper(List<List<Integer>> lists, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= lists.size()){
            lists.add(new ArrayList<>());
        }
        if (depth % 2 == 0){
            lists.get(depth).add(root.val);
        }else {
            lists.get(depth).add(0,root.val);
        }
        zigzagLevelOrderHelper(lists,root.left,depth + 1);
        zigzagLevelOrderHelper(lists,root.right,depth + 1);
    }
}