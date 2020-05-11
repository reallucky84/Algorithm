// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

public class LeetCode_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int n = grid.length;
        int[] tToB = new int[n];
        int[] lTor = new int[n];

        for(int i = 0; i < n; i++){
            int topTobottomMax = 0;
            for(int j = 0; j < n; j++){
                topTobottomMax = Math.max(grid[j][i], topTobottomMax);
            }
            tToB[i] = topTobottomMax;
        }


        for(int i = 0; i < n; i++){
            int leftToRightMax = 0;
            for(int j = 0; j < n; j++){
                leftToRightMax = Math.max(grid[i][j], leftToRightMax);
            }
            lTor[i] = leftToRightMax;
        }

        // System.out.println(Arrays.toString(tToB));
        // System.out.println(Arrays.toString(lTor));

        int result = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int max = Math.min(lTor[i], tToB[j]);
                result += max - grid[i][j];
            }
        }

        return result;
    }
}
