class Solution {
    public static final int[][] next = {{0,1},{1,0},{0,-1},{-1,0}};
    public int m,n,res;
    public boolean[][] visited;
    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        res = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("outerLoop: " + " curI: " + i + " ,curJ: " + j);
                if (grid[i][j] == '1' && !visited[i][j]){
                    backTracking(grid,i,j);
                    res ++;
                }
            }
        }
        return res;
    }

    private void backTracking(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newY = y + next[i][1];
            //System.out.println("curX: " + x + " ,curY: " + y + " ,newX: " + newX + " ,newY: " + newY);
            if(isInArea(newX,newY) && !visited[newX][newY] && grid[newX][newY] == '1'){
                backTracking(grid,newX,newY);
            }
        }

    }
    public boolean isInArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}