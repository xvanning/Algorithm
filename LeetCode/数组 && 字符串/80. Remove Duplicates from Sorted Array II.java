//与26题形成对比。通解~
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n: nums){
            if (i < 2 || n > nums[i - 2]){
                nums[i ++] = n;
            }
        }
        return i;
    }
}