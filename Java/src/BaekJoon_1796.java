import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/1796
public class BaekJoon_1796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        int[] f = makeFail(p);
        List<Integer> list = kmp(t, p, f);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i + 1);
        }
    }

    public static List<Integer> kmp(String s, String p, int[] f) {
        int lenS = s.length();
        int lenP = p.length();
        int j = 0;

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < lenS; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = f[j - 1];
            if (s.charAt(i) == p.charAt(j)) {
                if (j == lenP - 1) {
                    list.add(i - lenP + 1);
                    j = f[j];
                } else {
                    j++;
                }
            }
        }
        return list;
    }

    public static int[] makeFail(String p) {
        int len = p.length();
        int[] f = new int[len];
        f[0] = 0;

        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = f[j - 1];
            if (p.charAt(i) == p.charAt(j)) {
                f[i] = ++j;
            } else {
                f[i] = 0;
            }
        }
        return f;
    }
}
