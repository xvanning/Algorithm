//参考leetcode 34题。
//二分搜索的变种，floor和ceil的最好理解方法。
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int floor = getFirstK(array, k);
        int ceil = getLastK(array, k);
        if (floor == -1 || ceil == -1) {
            return 0;
        } else {
            return ceil - floor + 1;
        }
    }
    //floor部分，如果在某次二分搜索的时候，array[mid] == k，
    //则要判断当前mid是不是在数组开头，如果是则肯定是K的floor；
    //如果不是数组开头，但是mid前一个数字不为K，则当前mid也一定为K的floor
    //如果不是以上两种情况，则floor一定在当前mid的前面，因此使得 r = mid - 1；
    //其他情况依照最普通的二分搜索。
    public int getFirstK(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == k) {
                if (mid == 0 || (mid > 0 && array[mid - 1] != k)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    //ceil部分，如果在某次二分搜索的时候，array[mid] == k，
    //则要判断当前mid是不是在数组末尾，如果是则肯定是K的ceil；
    //如果不是数组末尾，但是mid后一个数字不为K，则当前mid也一定为K的ceil
    //如果不是以上两种情况，则ceil一定在当前mid的后面，因此使得 r = mid + 1；
    //其他情况依照最普通的二分搜索。
    public int getLastK(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == k) {
                if (mid == array.length - 1 || (mid < array.length - 1 && array[mid + 1] != k)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}