// 顺时针旋转九十度就是先转置再水平翻转
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i); // 转置要注意从对角线开始
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}

// 变形题，旋转K次
class Solution {
    public void rotate(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;
        int[] temp = new int[m * n + 1];
        if (k % 4 == 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[index++] = matrix[i][j];
                }
            }
        } else if (k % 4 == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    temp[index++] = matrix[j][i];
                }

            }
        } else if (k % 4 == 2) {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    temp[index++] = matrix[i][j];
                }

            }
        } else {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    temp[index++] = matrix[j][i];
                }

            }
        }
        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[index++];
            }
        }
    }
}