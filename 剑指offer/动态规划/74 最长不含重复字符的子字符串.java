//leetcode 3. Longest Substring Without Repeating Characters
/**基本思想是，保留一个hashmap，它将字符串中的字符存储为键，将它们的位置存储为值，并保留两个定义max子串的指针。
 * 移动右指针扫描字符串，同时更新hashmap。
 * 如果该字符已经在hashmap中，则将左指针移动到最后找到的相同字符的右侧。
 * 请注意，两个指针只能向前移动。 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int res = 0; int j = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                /**可以改写为
                 * if(map.get(s.charAt(i)) > j){
                 * j = map.get(s.charAt(i)) + 1;
                 * }
                 *
                  */
                j = Math.max(j, map.get(s.charAt(i)) + 1); //即将左指针移动到最后找到的相同字符的右侧
            }
            map.put(s.charAt(i),i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}

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