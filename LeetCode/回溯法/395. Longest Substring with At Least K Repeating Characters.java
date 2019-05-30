public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] += 1;
        }
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < k && chars[i] > 0) {
                flag = false;
            }
        }
        // return the length of string if this string is a valid string
        if (flag) {
            return s.length();
        }

        int maxLen = 0;
        int start = 0;
        // otherwise we use all the infrequent elements as splits
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] < k) {
                maxLen = Math.max(maxLen, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        maxLen = Math.max(maxLen, longestSubstring(s.substring(start), k));
        return maxLen;
    }
}