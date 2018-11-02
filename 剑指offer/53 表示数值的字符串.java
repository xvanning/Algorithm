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
                if(i == 0){
                    continue;
                }else{
                    if(usedE == false){
                        return false;
                    }else{
                        if(str[i - 1] == 'e' || str[i - 1] == 'E'){
                            continue;
                        }else{
                            return false;
                        }
                    }
                }
            }

            //判断小数点
            if(str[i] == '.'){
                if(usedDot == true){
                    return false;
                }
                if(usedE == true){
                    return false;
                }
                usedDot = true;
                continue;
            }

            //判断e E
            if((str[i] == 'e' || str[i] == 'E') ){
                if(usedE == true){
                    return false;
                }
                if(i == str.length - 1){
                    return false;
                }
                usedE = true;
                continue;
            }

            //判断数字
            if(str[i] < '0' || str[i] > '9'){
                return false;
            }

        }
        return true;
    }
}