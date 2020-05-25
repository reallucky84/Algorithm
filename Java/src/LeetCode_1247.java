
// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
public class LeetCode_1247 {

    public static int n = 0;

    public static void main(String[] args) {
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";
        System.out.println(minimumSwap(s1, s2));
    }


    public static int minimumSwap(String s1, String s2) {
        int result = 0;
        n = s1.length();

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        int xy = 0;
        int yx = 0;

        for (int i = 0; i < n; i++) {
            if (cs1[i] != cs2[i]) {
                if (cs1[i] == 'x') {
                    xy++;
                } else if (cs1[i] == 'y') {
                    yx++;
                }
            }
        }

        result += xy / 2;
        result += yx / 2;

        int xyR = xy % 2;
        int yxR = yx % 2;
        if (xyR == yxR) {
            result += xyR * 2;
        } else {
            result = -1;
        }

        return result;
    }
}
