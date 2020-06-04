package leetcode;

import java.util.*;

// https://leetcode.com/problems/reduce-array-size-to-the-half/
public class LeetCode_1338 {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            if(map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            } else{
                map.put(a, 1);
            }
        }

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }

        Collections.sort(list);

        int result = 0;
        int len = arr.length;
        int half = len / 2;

        while(len > half){
            int lastIndex = list.size()-1;
            len -= list.get(lastIndex);
            list.remove(lastIndex);
            result++;
        }

        return result;
    }

}
