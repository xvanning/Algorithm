/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
 * 递归的解法，由于是完全二叉树，所以若节点的左子结点存在的话，其右子节点必定存在，
 * 所以左子结点的next指针可以直接指向其右子节点，对于其右子节点的处理方法是，
 * 判断其父节点的next是否为空，若不为空，则指向其next指针指向的节点的左子结点，若为空则指向NULL
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = null;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

/**
 * 非递归
 *
 */

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (i != size - 1) {
                    cur.next = q.peek();
                } else {
                    cur.next = null;
                }
            }
        }
        return root;
    }
}