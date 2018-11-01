//因为行和列都是递增的，所有第一个开始查找的元素在右上角元素。
//当target大于当前值，则向下查找。如果target小于当前值，则向左查找。
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0){
            return false;
        }

        int row = 0; int col = array[0].length - 1;
        while(row <= array.length - 1 && col >= 0){
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                row ++;
            }else{
                col --;
            }
        }
        return false;
    }
}