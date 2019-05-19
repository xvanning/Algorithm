//前序：
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

//中序：一直先把左子树push进栈。然后pop出当前节点。cur改为当前节点的右子树。一直循环下去。
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}

//后序：
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return list;
        }
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                list.add(0,cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        return list;
    }
}

//层序：
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            lists.add(subList);
        }
        return lists;
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            levelHelper(root, 0, res);
            return res;
        }

        private void levelHelper(TreeNode root, int level, List<List<Integer>> res) {
            if (root == null) {
                return;
            }
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            levelHelper(root.left, level + 1, res);
            levelHelper(root.right, level + 1, res);
        }
    }

}