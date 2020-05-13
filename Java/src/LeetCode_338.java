// https://leetcode.com/problems/counting-bits/
public class LeetCode_338 {

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;

        if(num == 0){
            return result;
        }

        if(num == 1){
            result[1] = 1;
            return result;
        }

        result[1] = 1;
        int count = 2;
        int half = count / 2;
        int k = -half;

        for(int i = 2; i <= num; i++){
            if(count > half){
                result[i] = result[i + k];
            } else{
                result[i] = result[i + k] + 1;
            }
            count--;

            if(count == 0){
                count = half * 4;
                half = count / 2;
                k = -half;
            }
        }

        return result;
    }
}
