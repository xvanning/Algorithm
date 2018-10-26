//法一： 双指针，第一次遍历的时候，每次遇到空格就在末尾添加两个空格。然后设置，一左一右指针，同时移动，当左指针遇到空格的时候，右指针变为%20.否则就按原来的字符。
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int oldLenth = str.length();
        for(Character c: str.toString().toCharArray()){
            if(c == ' '){
                str.append("  ");
            }
        }
        int newLenth = str.length();
        int r = newLenth - 1; int l = oldLenth - 1;
        while(l >= 0 && r > l){
            if(str.charAt(l) == ' '){
                str.setCharAt(r --, '0');
                str.setCharAt(r --, '2');
                str.setCharAt(r --, '%');
            }else{
                str.setCharAt(r --, str.charAt(l));
            }
            l --;
        }
        return str.toString();
    }

//正则表达式
public String replaceSpace(StringBuffer str) {
        return str.toString.replaceAll("\\s", "%20");
    }