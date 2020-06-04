package leetcode;

import java.util.*;

// https://leetcode.com/problems/sort-the-matrix-diagonally/
public class LeetCode_1329 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, List<Integer>> diffMap = new HashMap<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int diff = i - j;
                if(diffMap.containsKey(diff)){
                    List<Integer> list = diffMap.get(diff);
                    list.add(mat[i][j]);
                } else{
                    List<Integer> list = new ArrayList<>();
                    list.add(mat[i][j]);
                    diffMap.put(diff, list);
                }
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry: diffMap.entrySet()){
            Collections.sort(entry.getValue());
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int diff = i - j;
                List<Integer> list = diffMap.get(diff);
                mat[i][j] = list.get(0);
                list.remove(0);
            }
        }

        return mat;

    }

}
