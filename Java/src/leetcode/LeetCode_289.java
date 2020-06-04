package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/game-of-life/
public class LeetCode_289 {

    public static void main(String[] args) {
//        int[][] input = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] input = new int[][]{{1, 1}, {1, 0}};

        print(input);
        gameOfLife(input);
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isLive(i, j, board, m, n)) {
//                    System.out.println(" live");
                    board[i][j] |= 2;
                } else {
//                    System.out.println(" dead");
                    board[i][j] |= 0;
                }
                print(board);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }

    }

    public static boolean isLive(int x, int y, int[][] board, int m, int n) {

        int neighbor = check(x, y, board, m, n);

//        System.out.print(x + "," + y + "=" + neighbor + " " + board[x][y]);
        if (board[x][y] == 1) {
            return 1 < neighbor && neighbor < 4;
        } else {
            return neighbor == 3;
        }
    }

    public static int check(int x, int y, int[][] board, int m, int n) {
        int neighbor = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < m && j < n) {
                    if ((board[i][j] & 1) == 1) {
                        neighbor++;
                    }
                }
            }
        }
        neighbor -= board[x][y];
        return neighbor;
    }

    public static void print(int[][] arr){
        for (int[] in : arr) {
            System.out.println(Arrays.toString(in));
        }
        System.out.println("---------------");
    }
}
