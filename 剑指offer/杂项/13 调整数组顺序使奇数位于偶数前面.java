//先统计奇数的个数。然后克隆一下原数组。遍历数组，当遇到偶数的话就放到下标为奇数的后面，遇到奇数就放到前面
public class Solution {
    public void reOrderArray(int [] array) {
        if(array.length == 0){
            return;
        }
        int oddNum = 0; int evenNum = 0;
        for(int num : array){
            if(num % 2 == 1){
                oddNum ++;
            }
        }
        int[] newArray = array.clone();
        for(int num : newArray){
            if(num % 2 == 1){
                array[evenNum ++] = num;
            }else{
                array[oddNum ++] = num;
            }
        }
    }
}