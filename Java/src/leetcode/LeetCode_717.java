package leetcode;

// https://leetcode.com/problems/1-bit-and-2-bit-characters/
public class LeetCode_717 {

    public static void main(String[] args){
        int[] input = new int[]{1, 1, 1, 0, 0, 1, 1, 0};
        System.out.println(isOneBitCharacter(input));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if(len == 1 || bits[len-2] == 0){
            return true;
        }

        boolean isLastBit = false;

        for(int i = 0; i < len; i++){
            if(bits[i] == 1){
                i++;
                isLastBit = false;
            } else{
                isLastBit = true;
            }
        }

        return isLastBit;
    }
}
