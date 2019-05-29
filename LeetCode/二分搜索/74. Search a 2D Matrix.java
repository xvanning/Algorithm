/**
 * 把一个长度为n的一维数组转化为m*n的二维数组后，
 * 那么原一维数组中下标为i的元素将出现在二维数组中的[i/n][i%n]的位置，
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

/**
 * 两次二分搜索，先查找到行，再查找到列
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length -1;
        int n = matrix[0].length - 1;
        if (matrix[0][0] > target || matrix[m][n] <target) {
            return false;
        }
        int l = 0; int r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int tmp = r;
        l = 0;
        r = matrix[tmp].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[tmp][mid] == target) {
                return true;
            } else if (matrix[tmp][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}