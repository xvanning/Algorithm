/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    private String desString = null;
    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
  }
    TreeNode Deserialize(String str) {
        desString = str;
        return desCore();
  }

    TreeNode desCore(){
        if(desString.length() == 0){
            return null;
        }
        int index = desString.indexOf(",");
        String node = index == -1 ? desString : desString.substring(0,index); //节点
        desString = index == -1 ? desString : desString.substring(index + 1); //新的序列化字符串

        if(node.equals("#")){
            return null;
        }

        int rootValue = Integer.valueOf(node);
        TreeNode t = new TreeNode(rootValue);
        t.left = desCore();
        t.right = desCore();
        return t;
    }
}