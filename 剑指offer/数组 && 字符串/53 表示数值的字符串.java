public class Solution {
    public boolean isNumeric(char[] str) {
        if(str.length == 0){
            return false;
        }
        boolean usedE = false;
        boolean usedDot = false;

        for(int i = 0; i < str.length; i ++){
            //判断加减号
            if(( str[i] == '+' || str[i] == '-')){
                if(i == 0){ //字符串开头，继续
                    continue;
                }else{//如果不是字符串开头
                    if(usedE == false){ // 如果前面没有出现E 或者 e
                        return false;
                    }else{
                        if(str[i - 1] == 'e' || str[i - 1] == 'E'){ // 如果符号前面是E 或者 e
                            continue;
                        }else{ //其他情况
                            return false;
                        }
                    }
                }
            }

            //判断小数点
            if(str[i] == '.'){
                if(usedDot == true){ //只能出现一个小数点
                    return false;
                }
                if(usedE == true){ // 出现在 E 或者 e 后面
                    return false;
                }
                usedDot = true;
                continue;
            }

            //判断e E
            if((str[i] == 'e' || str[i] == 'E') ){
                if(usedE == true){ //只能出现一个E 或者 e
                    return false;
                }
                if(i == str.length - 1){ //指数在字符串末尾
                    return false;
                }
                usedE = true;
                continue;
            }

            //判断数字
            if(str[i] < '0' || str[i] > '9'){ //非数字的情况
                return false;
            }

        }
        return true;
    }
}