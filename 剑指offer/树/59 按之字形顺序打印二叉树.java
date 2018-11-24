import java.util.ArrayList;
import java.util.Stack;

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
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return ret;
        }
        Stack<TreeNode> odd = new Stack<>(); //奇数行栈
        Stack<TreeNode> even = new Stack<>(); //偶数行栈
        boolean isOdd = true;
        odd.push(pRoot);
        while (!odd.isEmpty() || !even.isEmpty()) { //树没有遍历完
            ArrayList<Integer> list = new ArrayList<>();
            if (isOdd) { //奇数行，stack1中节点的孩子节点按先左孩子后右孩子的顺序入栈2
                while (!odd.isEmpty()) {
                    TreeNode cur = odd.pop(); //取队栈顶元素
                    list.add(cur.val); //添加当前列表
                    if (cur.left != null) {
                        even.push(cur.left);
                    }
                    if (cur.right != null) {
                        even.push(cur.right);
                    }
                }
                isOdd = false; //更新下一层扫描树为偶数行
            } else {
                while (!even.isEmpty()) {
                    TreeNode cur = even.pop();
                    list.add(cur.val);
                    if (cur.right != null) {
                        odd.push(cur.right);
                    }
                    if (cur.left != null) {
                        odd.push(cur.left);
                    }
                }
                isOdd = true;
            }
            ret.add(new ArrayList<>(list)); //添加当前行的节点值
        }
        return ret;
    }
}