//多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
//使用 cnt 来统计一个元素出现的次数，
//当遍历到的元素和统计元素相等时，令 cnt++，
//否则令 cnt--。如果前面查找了 i 个元素，且 cnt == 0，
//说明前 i 个元素没有 majority，或者有 majority，
//但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
//此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int majority = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i ++){
            if(majority == array[i]){
                count ++;
            }else{
                count --;
                if(count == 0){
                majority = array[i];
                count = 1;
                }
            }
        }
        int realcount = 0;
        for(int num : array){
            if(majority == num){
                realcount ++;
            }
        }
        return realcount > array.length / 2 ? majority : 0;
    }
}