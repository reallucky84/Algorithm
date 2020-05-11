import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/queries-on-a-permutation-with-key/
public class LeetCode_1409 {

    public int[] processQueries(int[] queries, int m) {

        List<Integer> p = new ArrayList<>();

        for(int i = 0; i < m ;i++){
            p.add(i+1);
        }

        int len = queries.length;
        int[] result = new int[len];


        for(int i = 0 ; i < len; i++){
            result[i] = findIndex(queries[i], p);
        }

        return result;
    }

    public int findIndex(int query, List<Integer> p){
        int index = p.indexOf(Integer.valueOf(query));
        p.remove(index);
        p.add(0, Integer.valueOf(query));
        return index;
    }
}
