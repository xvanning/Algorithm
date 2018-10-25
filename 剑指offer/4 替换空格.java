public class Solution {
    public String replaceSpace(StringBuffer str) {
        int OldLength = str.length();
        for (int i = 0; i < OldLength; i ++){
            if (str.charAt(i) == ' '){
                str.append("  ");
            }
        }

        int NewLength = str.length();
        int P1 = OldLength - 1; int P2 = NewLength - 1;
        while (P1 >= 0 && P1 < P2){
            char c = str.charAt(P1 --);
            if (c == ' '){
                str.setCharAt(P2 --,'0');
                str.setCharAt(P2 --,'2');
                str.setCharAt(P2 --,'%');

            }else {
               str.setCharAt(P2 --,c);
            }
        }

        return str.toString();
    }
}

//正则表达式
public String replaceSpace(StringBuffer str) {
        return str.toString.replaceAll("\\s", "%20");
    }