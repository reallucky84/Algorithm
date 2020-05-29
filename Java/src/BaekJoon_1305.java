import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/1305
public class BaekJoon_1305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(n - makeFail(s)[n - 1]);

    }

    public static List<Integer> kmp(String s, String p, int[] f) {
        List<Integer> list = new LinkedList<>();
        int lenS = s.length();
        int lenP = p.length();
        int j = 0;
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
