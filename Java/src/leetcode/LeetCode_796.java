package leetcode;

//https://leetcode.com/problems/rotate-string/
public class LeetCode_796 {
    public boolean rotateString(String A, String B) {
        if(A.length() == B.length()){
            return (A + A).contains(B);
        }
        return false;
    }
}
