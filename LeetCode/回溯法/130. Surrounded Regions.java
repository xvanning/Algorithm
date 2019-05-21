// 总的思想就是先把四周的O和与四周O相连的O标记为$, 最后遍历一遍，将$转为O，将其余O转为X；
// dfs
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j <0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == '$' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '$';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}



// bfs
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = '$';
                    queue.offer(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k = 0; k < directions.length; k++) {
                            int tempI = directions[k][0] + point.x;
                            int tempJ = directions[k][1] + point.y;
                            if (tempI >= 0 && tempJ >= 0 && tempI <= m - 1 && tempJ <= n - 1 && board[tempI][tempJ] == 'O') {
                                board[tempI][tempJ] = '$';
                                queue.offer(new Point(tempI, tempJ));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }


}