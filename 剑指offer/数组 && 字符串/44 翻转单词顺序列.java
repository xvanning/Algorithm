public class Solution {
    public String ReverseSentence(String str) {
        if(str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        //翻转整个字符串
        reverse(chars, 0, str.length() - 1);
        //标定每个单词的开始和结尾
        int beginIndex = 0; int endIndex = 0;

        while(beginIndex < str.length()){
            while(endIndex < str.length() && chars[endIndex] != ' ' ){ //第一个条件是为了防止后面一个条件出现异常OutofIndex
                endIndex ++;
            }
            reverse(chars, beginIndex, endIndex - 1); //因为上面的操作之后，endIndex处在空格位置。所以要减一。
            endIndex = endIndex + 1; // endIndex 移到下一个单词的开始
            beginIndex = endIndex; // beginIndex 开始重新赋值。
        }
        return new String(chars); //要返回新的字符串重新new一个
    }

    public void reverse(char[] chars, int l, int r){
        while(l < r){
            swap(chars, l++, r--);
        }
    }

    public void swap(char[] chars,int i ,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}