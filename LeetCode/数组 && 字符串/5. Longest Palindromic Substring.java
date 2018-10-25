class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendPalindrome(s,i,i); //奇数长度的回文串
            int len2 = extendPalindrome(s,i,i+1); //偶数长度的回文串
            int len = Math.max(len1,len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1); //substring方法，需要起始长度的下标，以及末尾长度的下标加一；
    }


    //从左右两边依次推进，最后会停在回文串长度的左右两侧。所以最后返回回文串的长度需要减去1；    
    public int extendPalindrome(String s,int L,int R){
        while (L >= 0 && R <s.length() && s.charAt(L) == s.charAt(R)){
            L --;
            R ++;
        }
        return R - L - 1;
    }
}