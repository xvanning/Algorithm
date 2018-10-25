//先计算左子树的节点个数，如果左子树节点 + 1刚好等于K,说明刚好就是根节点为返回值。否则小于的话，在左子树递归。大于的话在右子树递归。
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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        System.out.println(count);
        if(k < count + 1){
            return kthSmallest(root.left,k);
        }else if(k > count + 1){
            return kthSmallest(root.right,k - count - 1);
        }else{
            return root.val;
        }
    }
    
     public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

//中序遍历方法（迭代）： 只要在中序遍历那一句话里修改。
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(--k == 0){
                break;
            }
            cur = cur.right;
        }
        return cur.val;
    }
}