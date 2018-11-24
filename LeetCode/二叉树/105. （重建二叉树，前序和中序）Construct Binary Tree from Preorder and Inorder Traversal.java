import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
 */
/**
 * 递归遍历，每次都把小的前序和中序来递归建立节点。最后递归完毕就是一颗树
 */
class Solution {
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        for(int i = 0; i < inorder.length; i ++){ //确定中序遍历的每个下标
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeCore(preorder,0,preorder.length - 1, inorder,0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTreeCore(int[] preorder,int preL,int preR, int[] inorder,int inL, int inR){
        if(preL > preR || inL > inR){
            return null;
        }
        int rootValue = preorder[preL];
        TreeNode root = new TreeNode(rootValue);

        int leftSize = map.get(rootValue) - inL; //第一次值为1
        int rightSize = inR - map.get(rootValue); //第一次值为3

        root.left = buildTreeCore(preorder,preL + 1, preR - rightSize,inorder, inL, inR - rightSize - 1);
        root.right = buildTreeCore(preorder,preL + leftSize + 1, preR,inorder, inL + leftSize + 1, inR );
        return root;
    }
}