package programmers;

//https://programmers.co.kr/learn/courses/30/lessons/12900
public class Programmers_12900 {

    public static void main() {

        System.out.println(solution(30));
    }

    public static int solution(int n) {
        int mod = 1000000007;
        int[] d = new int[n];
        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i < n; i++) {
            d[i] = (d[i - 1] % mod + d[i - 2] % mod) % mod;
        }
        return d[n - 1];
    }

}
