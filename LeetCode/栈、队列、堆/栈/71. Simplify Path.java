//定义跳过的字符串。最后遍历栈进行输出
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        HashSet<String> skipString = new HashSet<>(Arrays.asList("..",".",""));
        for (String s: path.split("/")){
            if ("..".equals(s) && !stack.isEmpty()){
                stack.pop();
            }else if (!skipString.contains(s)){
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        if (stack.isEmpty()) {
            return res.append("/").toString();
        }
        for (String s: stack){
            res.append("/").append(s);
        }
        return res.toString();
    }
}