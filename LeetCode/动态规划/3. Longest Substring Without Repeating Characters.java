//滑动窗口，两指针移动。
// 最优解：利用map记录第一次字母出现的下标值。当出现重复的时候，直接把下标往前挪一个。

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right ++){
            if (charMap[s.charAt(right)] >= left){
                left = charMap[s.charAt(right)] + 1;
            }
            charMap[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

//次优解，滑动窗口
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hasExisted = new boolean[256];
        int left = 0; int retLength = 0;
        for (int right = 0; right < s.length(); right ++){
            while (hasExisted[s.charAt(right)]){
                hasExisted[s.charAt(left)] = false;
                left ++;
            }
            hasExisted[s.charAt(right)] = true;
            retLength = Math.max(retLength,right - left + 1);
        }
        return retLength;
    }
}