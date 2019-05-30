/**
 * 。我们可以先给数组排序，然后在做调整。
 * 调整的方法是找到数组的中间的数，相当于把有序数组从中间分成两部分，然后从前半段的末尾取一个，
 * 在从后半的末尾去一个，这样保证了第一个数小于第二个数，
 * 然后从前半段取倒数第二个，从后半段取倒数第二个，
 * 这保证了第二个数大于第三个数，且第三个数小于第四个数，以此类推直至都取完
 */
import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
        int n = nums.length;
        int i = (n + 1) / 2;
        int j = n;
        Arrays.sort(copy);
        for (int k = 0; k < n; k++) {
            nums[k] = k % 2 == 0 ? copy[--i] : copy[--j];
        }
    }
}