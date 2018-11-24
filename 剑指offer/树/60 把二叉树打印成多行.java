import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size(); //和22题的不同之处，就是记录队列的大小，当作每一行。
            while(cnt > 0){
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                cnt --;
            }
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }

}