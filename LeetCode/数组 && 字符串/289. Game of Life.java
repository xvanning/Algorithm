/**
 * 289. Game of Life 需要记录状态，比较巧妙
 *
 * 状态0： 死细胞转为死细胞
 * 状态1： 活细胞转为活细胞
 * 状态2： 活细胞转为死细胞
 * 状态3： 死细胞转为活细胞
 */

class Solution {
    private final static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 0, -1 },
            { 1, -1 } };

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countOnes = getOneAround(board, i, j);
                if (board[i][j] == 1 && (countOnes < 2 || countOnes > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && countOnes == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }

    private int getOneAround(int[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < dir.length; k++) {
            int curI = i + dir[k][0];
            int curJ = j + dir[k][1];
            if (curI >= 0 && curI < board.length && curJ >= 0 && curJ < board[0].length
                    && (board[curI][curJ] == 1 || board[curI][curJ] == 2)) {
                count++;
            }
        }
        return count;
    }
}