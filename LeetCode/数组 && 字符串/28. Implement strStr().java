//利用subString方法，寻找字串的第一个字符

class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(); int l2 = needle.length();
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; i ++){
            if (haystack.substring(i, i + l2).equals(needle)){
                return i;
            }
        }
        return -1;

    }
}


//·暴力解法，遍历数组
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i ++){
            for (int j = 0; ; j ++){
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}