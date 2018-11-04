import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode 239 (hard)

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1)); /* 大顶堆 */
        if (num.length == 0 || size <= 0 || size > num.length) { /* 初始化的一些定义 */
            return list;
        }
        /* 加入窗口的初始值 */
        for (int i = 0; i < num.length; i++) {
            if (queue.size() < size) {
                queue.add(num[i]);
            }
        }
        list.add(queue.peek());
        /* i表示窗口的左边，j表示窗口的右边，每次移除窗口的左边，加入窗口的右边值。然后输出窗口内的最大值。 */
        for (int i = 0; i < num.length - size; i++) {
                int j = i + size;  /*窗口的右边*/
                queue.remove(num[i]); //每次移除窗口的左边
                queue.add(num[j]); //加入窗口的右边值
                list.add(queue.peek()); //输出窗口内的最大值
            }
        return list;
    }
}