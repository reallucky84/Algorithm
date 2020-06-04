package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_406 {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (x, y) -> {
            return x[0]==y[0]? x[1]-y[1]:y[0]-x[0];
        });

        // for(int[] p : people){
        //     System.out.println(Arrays.toString(p));
        // }

        List<int[]> list = new LinkedList<>();
        for(int[] p : people){
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][]);
    }
}
