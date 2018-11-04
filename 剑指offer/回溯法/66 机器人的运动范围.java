public class Solution {
    public static final int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    public boolean[][] visited;
    int res = 0;

    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0 || threshold <= 0) {
            return res;
        }
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > threshold || j > threshold) {
                    break;
                }
                // System.out.println("Outer Loop: " + " curI: " + i + " ,curJ: " + j);
                if (!visited[i][j] && threshold >= digitSum(i, j)) {
                    backTracking(threshold, rows, cols, i, j);
                }
            }
        }
        return res;
    }

    private void backTracking(int threshold, int rows, int cols, int x, int y) {
        if (x > rows || y > cols) {
            return;
        }
        if (threshold >= digitSum(x, y)) {
            // System.out.println("curRes: " + res);
            res++;
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + next[i][0];
                int newY = y + next[i][1];
                // System.out.println("Inner Loop: " + " curX: " + x + " ,curY: " + y + " ,newX:
                // " + newX + " ,newY: " + newY);
                if (isInArea(newX, newY, rows, cols) && !visited[newX][newY] && threshold >= digitSum(newX, newY)) {
                    backTracking(threshold, rows, cols, newX, newY);
                }
            }
        }
    }

    public boolean isInArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int digitSum(int x, int y) {
        int xSum = 0;
        int ySum = 0;
        while (x != 0) {
            xSum += x % 10;
            x = x / 10;
        }
        while (y != 0) {
            ySum += y % 10;
            y = y / 10;
        }
        return xSum + ySum;
    }
}