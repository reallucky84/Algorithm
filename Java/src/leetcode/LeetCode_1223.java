package leetcode;// https://leetcode.com/problems/dice-roll-simulation/

public class LeetCode_1223 {

    public static int mod = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][] d = new int[n][7];
        for(int i = 0; i < 6; i++){
            d[0][i] = 1;
        }
        d[0][6] = 6;

        for(int i = 1; i < n; i++){
            int sum = 0;

            for(int j = 0; j < 6; j++){
                d[i][j] = d[i-1][6];

                if(i == rollMax[j]){
                    d[i][j]--;
                }

                if(i > rollMax[j]){
                    int sub = d[i - rollMax[j] - 1][6] - d[i - rollMax[j] - 1][j];
                    d[i][j] = ((d[i][j] - sub) % mod + mod) % mod;
                }
                sum = (sum + d[i][j]) % mod;
            }

            d[i][6] = sum;
        }
        return d[n-1][6];

    }
}
