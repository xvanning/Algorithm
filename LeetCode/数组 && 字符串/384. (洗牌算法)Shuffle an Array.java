/**
 * 参考
 * https://github.com/imhuay/Algorithm_Interview_Notes-Chinese/blob/master/C-%E7%AE%97%E6%B3%95/%E4%B8%93%E9%A2%98-C-%E6%B4%97%E7%89%8C%E3%80%81%E9%87%87%E6%A0%B7%E3%80%81%E9%9A%8F%E6%9C%BA%E6%95%B0.md
 */
import java.util.Random;

class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] temp = nums.clone();
        for (int i = 1; i < temp.length; i++) {
            int j = random.nextInt(i + 1);
            swap(temp, i, j);
        }
        return temp;
    }

    private void swap(int[] temp, int i, int j) {
        int t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */