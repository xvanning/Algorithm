//经典回溯法，记得回溯的时候把visited置回为false；
class Solution {
    public static final int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (board == null || word.length() == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("outerLoop: " + " curI: " + i + " ,curY: " + j);
                if (backTracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, String word, int x, int y, int start) {
        if (start == word.length() - 1) {
            return board[x][y] == word.charAt(start);
        }
        if (word.charAt(start) == board[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + next[i][0];
                int newY = y + next[i][1];
                //System.out.println("curStart: " + start + " ,curX: " + x + " ,curY: " + y + " ,newX: " + newX + " ,newY: " + newY);
                if (isInArea(newX, newY) && !visited[newX][newY] && backTracking(board, word, newX, newY, start + 1)) {
                    return true;
                }
            }
            visited[x][y] = false; //记得回溯的时候把visited置回为false；
        }
        return false;
    }

    private boolean isInArea(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }
}