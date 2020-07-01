package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//부분 문자열
//https://www.acmicpc.net/problem/16916
public class BaekJoon_16916 {

    public static int mod = 127;
    public static int base = 256;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        System.out.println(find(s, p));
    }

    public static int find(String s, String p){

        int pHash = hash(p);
        int lenS = s.length();
        int lenP = p.length();

        if(lenS < lenP) return 0;

        int first = 1;
        for (int i = 0; i < lenP - 1; i++) {
            first = (first * base) % mod;
        }

        String sub = s.substring(0, lenP);
        int subHash = hash(sub);

//        System.out.println("pHash="+pHash);
//        System.out.println("---------------------------");

        for (int i = 0; i < lenS - lenP + 1; i++) {
//            System.out.println(s.substring(i, i + lenP));
//            System.out.println("subHash="+subHash);
            if (subHash == pHash && s.substring(i, i + lenP).equals(p)) {
                return 1;
            }

            if(i + lenP < lenS){
                subHash = subHash - (s.charAt(i) * first) % mod;
                subHash = (subHash + mod) % mod;
                subHash = ((subHash * base) % mod + s.charAt(i + lenP)) % mod;
            }
        }
        return 0;
    }

    public static int hash(String s) {

        int hash = 0;
        for (char c : s.toCharArray()) {
            hash = (hash * base + c) % mod;
        }
        return hash;
    }
}
