//与80题形成对比通解。
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums){
            if(i < 1 || n > nums[i - 1]){
                nums[i ++] = n;
            }
        }
        return i;
    }
}


// 初始指针位0。 指针移动，
//比较后一个元素与指针当前的元素是否相等，如果不想等，则指针位置先加一，再赋值。
//最后返回数组的时候，指针位置要加一。
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int resCnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[resCnt]){
                resCnt ++;
                nums[resCnt] = nums[i];
            }

        }
        return ++ resCnt;
    }
}


//光头哥解法：和上面解法类似，就是要注意初始位置赋值和比较大小之后才赋值。
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int resCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[resCnt - 1]){
                nums[resCnt] = nums[i];
                resCnt ++;
            }
        }
        return resCnt;
    }
}

