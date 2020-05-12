// https://leetcode.com/problems/hamming-distance/
public class LeetCode_461 {

    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;

        for(int i=0 ; i < 32; i++){
            if(((xor >> i) & 1) == 1){
                count++;
            }
        }
        return count;
    }
}
