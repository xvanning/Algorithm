//leetcode 79 Word Search ；
public class Solution {
    private final static int[][] next = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    boolean[][] visited;
    private int rows;
    private int cols;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || rows <= 0 || cols <= 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        visited = new boolean[rows][cols];
        char[][] board = buildMatrix(matrix);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTracking(board, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking(char[][] board, char[] str, int x, int y, int start) {
        if (start == str.length - 1) {
            return str[start] == board[x][y];
        }
        if (str[start] == board[x][y]) {
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = x + next[i][0];
                int newY = y + next[i][1];
                if (isInArea(newX, newY) && !visited[newX][newY]
                        && backTracking(board, str, newX, newY, start + 1)) {
                    return true;
                }
            }

            visited[x][y] = false;
        }

        return false;
    }

    public boolean isInArea(int x, int y) {
        return x < rows && x >= 0 &&  y < cols &&  y >= 0;
    }

    private char[][] buildMatrix(char[] matrix) {
        char[][] currentMatrix = new char[rows][cols];
        int id = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                currentMatrix[i][j] = matrix[id++];
            }
        }
        return currentMatrix;

    }
}