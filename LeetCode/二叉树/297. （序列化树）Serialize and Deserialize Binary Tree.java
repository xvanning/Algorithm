/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 注意corner case， 当最后递归是null的时候，index为-1；
public class Solution {

    String desString = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        desString = data;
        return deserializeHelper();
    }

    private TreeNode deserializeHelper() {
        if (desString.length() == 0) {
            return null;
        }
        int index = desString.indexOf(",");
        String curNodeValue = index == -1 ? desString : desString.substring(0, index);
        desString = index == -1 ? desString : desString.substring(index + 1);
        if (curNodeValue.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(curNodeValue));
        root.left = deserializeHelper();
        root.right = deserializeHelper();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));