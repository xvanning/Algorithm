//postorder = [3,9,20,15,7]
//先找到左子树和右子树的分界点
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }

        return verifyCore(sequence, 0, sequence.length - 1);
    }

    public boolean verifyCore(int [] sequence, int start, int end){
        if(start >= end){
            return true;
        }
        int rootValue = sequence[end];
        int cutIndex = start; //先找到左子树和右子树的分界点
        while(cutIndex < end && rootValue > sequence[cutIndex]){
            cutIndex ++;
        }

        for(int i = cutIndex; i < end; i ++){
            if(rootValue > sequence[i]){ //根节点都要比右子树的值要小
                return false;
            }
        }
        //分别在左右子树进行递归。
        return verifyCore(sequence, start, cutIndex - 1) && verifyCore(sequence, cutIndex, end - 1);
    }


}