package leetcode;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/submissions/
public class LeetCode_1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[][] dp = new int[d+1][target+1];

        for(int i = 1; i <= Math.min(f, target); i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= d; i++){

            for(int j = 1; j <= target; j++){

                for(int m = 1; m <= Math.min(f, j); m++){

                    dp[i][j] = (dp[i][j] + dp[i-1][j-m]) % mod;
                }
            }
        }

        return dp[d][target];
    }
}
