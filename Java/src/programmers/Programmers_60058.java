package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Programmers_60058 {

    public static void main(String[] args) {
        String s = "()))((()";
        System.out.println(trans(s));
    }

    public static String trans(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        int index = makeUV(s);
        String u = s.substring(0, index);
        String v = s.substring(index);

        StringBuilder sb = new StringBuilder();

        if (check(u)) {
            return sb.append(u).append(trans(v)).toString();
        } else {
            return sb.append('(').append(trans(v)).append(')').append(reverse(u)).toString();
        }

    }

    public static String reverse(String u) {
        StringBuilder sb = new StringBuilder(u);
        sb.deleteCharAt(u.length() - 1).deleteCharAt(0);

        for (int i = 0; i < u.length() - 2; i++) {
            if (sb.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        sb.delete(0, u.length() - 2);
        return sb.toString();
    }

    public static int makeUV(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) return i + 1;
        }
        return len;
    }

    public static boolean check(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
