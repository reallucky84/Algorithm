
// https://leetcode.com/problems/student-attendance-record-i/

public class LeetCode_551 {

    public boolean checkRecord(String s) {

        int aNum = 0;
        int lNum = 0;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (aNum > 0) {
                    return false;
                }
                aNum++;
                lNum = 0;

            } else if (c == 'L') {
                if (lNum > 1) {
                    return false;
                }
                lNum++;

            } else {
                lNum = 0;
            }
        }
        return true;

    }
}

