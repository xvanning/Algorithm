//递归写法：简单
import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}

/**
 *
 *  5
   / \
  1   4
     / \
    3   6
 *
 */

//非递归，三种方法。第一种方法只需要push右子树。 后两种方法都需要puhs和pop所有的节点。不推荐。
//方法1：一直先向左子树推进，有右子树就加入到栈。效率100%
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return list;
        }
        while(root != null){
            list.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            root = root.left;
            if(root == null && !stack.isEmpty()){
                root = stack.pop();
            }
        }
        return list;
    }
}

//方法2：先push根节点，然后在循环中，对当前pop出的节点，进行先push右子树，再push左子树。 效率比较低。
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return list;
    }
}

//方法3（最经典写法，可以和中序遍历一起用，只要改个位置）：一直先把左子树push进栈。然后pop出当前节点。cur改为当前节点的右子树。一直循环下去。效率比较低。
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}