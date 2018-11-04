// https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab

//参考leetcode 64 Minimum Path Sum
import java.util.*;

public class Bonus {
    public int getMost(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if( i == 0 && j == 0){
                    board[i][j] = board[0][0];
                }else if(i == 0 && j != 0){
                    board[i][j] = board[i][j] + board[i][j - 1];
                }else if(i != 0 && j == 0){
                    board[i][j] = board[i][j] + board[i - 1][j];
                }else{
                    board[i][j] = board[i][j] + Math.max(board[i][j - 1],board[i - 1][j]);
                }
            }
        }
        return board[rows - 1][cols - 1];
    }
}