//方法1： 比较巧妙，在原字符串上后面再拼接上一份原字符串。比如abc，变成了abcabc。
//然后再用substring进行截取；
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0){
            return "";
        }
        int oldLen = str.length();
        n = n % str.length();
        str = str + str;
        return str.substring(n, n + oldLen);
    }
}

//方法2：先翻转整个单词，再把左移的字母看成是单词，把原单词分为两部分，分别进行翻转。
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars,0, str.length() - 1); //翻转整个单词。

        n = n % str.length(); //取余操作。

        int beginIndex = 0; int endIndex = str.length() - 1 - n;
        reverse(chars,beginIndex, endIndex); //翻转前半部分；

        beginIndex = endIndex + 1;
        endIndex = str.length() - 1;
        reverse(chars,beginIndex, endIndex);

        return new String(chars);
    }

    public void reverse(char[] chars, int l, int r){
        while (l < r) {
            swap(chars, l ++ , r --);
        }
    }

    public void swap(char[] chars, int i , int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
