import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i ++){
            if (i > 0 && nums[i - 1] == nums[i]) continue; //后一个与前一个相同的话，跳过
            
            for (int j = i + 1; j < nums.length - 2; j ++){ //转换为3Sum
                if (j > i + 1 && nums[j - 1] == nums[j]) continue; //后一个与前一个相同的话，跳过
                int l = j + 1, r = nums.length - 1;
                while (l < r){ //转换为2Sum
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    //System.out.println("nums[i]: " + nums[i] + ", nums[j]: " + nums[j] + ", nums[l]: " + nums[l] + ", nums[r]: " + nums[r]);
                    if (sum == target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r - 1] == nums[r]) r --;
                        l ++; r --;
                    }else if (l < r && sum < target){
                        l ++;
                    }else {
                        r --;
                    }
                }
            }
        }
        return lists;
    }
}