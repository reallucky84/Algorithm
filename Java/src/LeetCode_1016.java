
// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
public class LeetCode_1016 {

    public static void main(String[] args) {

        System.out.println(queryString("0110", 3));
        System.out.println(queryString("0110", 4));
    }

    public static boolean queryString(String S, int N) {
        for(int i = 1 ; i <= N; i++){
            if(!S.contains(makeBinaryString(i))) return false;
        }
        return true;
    }

    public static String makeBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.reverse();
//        System.out.println(sb.reverse());
        return sb.toString();
    }
}
