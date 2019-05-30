import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();

    /*
     * @Param res 保存逆变对数
     * @Param index 保存数组下标索引值，排序数组下标值。
     * 此算法使用归并算法，最大差异就在于merge()方法的转变
     *
     *
     */
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length - 1, res);
        List<Integer> list = new LinkedList<>();
        for (int i : res) {
            list.add(i);
        }
        return list;
    }

    private void mergeSort(int[] nums, int[] index, int l, int r, int[] res) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, index, l, mid, res);
        mergeSort(nums, index, mid + 1, r, res);
        merge(nums, index, l, mid, mid + 1, r, res);
    }

    /*
     * 将左右两边排序好的数组进行逆序对计算，分别从左边起始处和右边起始处开始比较，
     * 当左边索引值大于右边时，count++，否则 左边索引值++；
     * count值会一直保留，如果右边数组遍历到尾部，左边数组剩下的数的逆序数都会是count；
     *
     *
     *
     */
    private void merge(int[] nums, int[] index, int l1, int r1, int l2, int r2, int[] res) {
        int start = l1;
        int[] tmp = new int[r2 - l1 + 1];
        //记录逆序对数
        int count = 0;
        //temp数组的下标值
        int p = 0;
        while (l1 <= r1 || l2 <= r2) {
            //左边数组遍历结束后，将右边剩余的值放到temp数组中，
            if (l1 > r1) {
                tmp[p++] = index[l2++];
                //右边数组遍历结束后，将左边剩余的值放到temp数组中，
            } else if (l2 > r2) {
                //l1是原数组索引值，index[l1]是排序好的原数组中索引值。res[index[l1]]对应的原数组索引位置赋逆变数
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            } else if (nums[index[l1]] > nums[index[l2]]) {
                tmp[p++] = index[l2++];
                count++;
            } else {
                //res存放每个数的最大值
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            //根据数组值排序，将对应的索引值放到index数组中。
            index[start + i] = tmp[i];
        }
    }
}