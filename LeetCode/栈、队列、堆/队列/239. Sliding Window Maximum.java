import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            }
        }
        list.add(queue.peek());
        for (int i = 0; i < nums.length - k; i++) {
            int j = i + k;
            queue.remove(nums[i]);
            queue.offer(nums[j]);
            list.add(queue.peek());
        }

        int[] res = new int[nums.length - k + 1];
        int i = 0;
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }
}