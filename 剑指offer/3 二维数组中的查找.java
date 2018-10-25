public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (array == null || rows == 0 || cols == 0){
            return false;
        }
 
        int row = 0;
        int col = cols - 1;
        while (row <= rows -1 && col >= 0){
            if (target == array[row][col]){
                return true;
            }else if (target > array[row][col]){
                row ++;
            }else {
                col --;
            }
        }
        return false;
    }
}