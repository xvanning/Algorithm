import java.util.Arrays;

public class Solution {
    public int InversePairs(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        long result = mergeSort(array, 0, array.length - 1);
        return (int) (result % 1000000007);
    }

    // 求arr[l..r]范围的逆序数对个数
    public long mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        long res1 = mergeSort(array, l, mid); // 求出 arr[l...mid] 范围的逆序数
        long res2 = mergeSort(array, mid + 1, r); // 求出 arr[mid+1...r] 范围的逆序数
        return res1 + res2 + merge(array, l, mid, r);
    }

    // merge函数求出在arr[l...mid]和arr[mid+1...r]有序的基础上, arr[l...r]的逆序数对个数
    public long merge(int[] array, int l, int mid, int r) {
        int[] copy = Arrays.copyOfRange(array, l, r + 1);
        int i = l;// 初始化，i指向左半部分的起始索引位置l；
        int j = mid + 1; //j指向右半部分起始索引位置mid+1
        long res = 0L; // 初始化逆序数对个数 res = 0
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                array[k] = copy[j - l];
                j++;
            } else if (j > r) { // 如果右半部分元素已经全部处理完毕
                array[k] = copy[i - l];
                i++;
            } else if (copy[i - l] <= copy[j - l]) { // 左半部分所指元素 <= 右半部分所指元素
                array[k] = copy[i - l];
                i++;
            } else { // 右半部分所指元素 < 左半部分所指元素

                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - i + 1
                array[k] = copy[j - l];
                j++;
                res += mid - i + 1;
            }
        }
        return res;
    }
}