public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        boolean isNegative = false;
        if(exponent < 0){
            isNegative = true;
            exponent = -exponent;
        }
        double res = Power(base * base, exponent / 2);
        if(exponent % 2 == 1){
            res = res * base;
        }

        return isNegative == true ? 1/res : res;
  }
}