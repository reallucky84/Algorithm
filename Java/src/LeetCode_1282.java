import java.util.*;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class LeetCode_1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String key = String.valueOf(groupSizes[i]);
            if(map.containsKey(key)){
                List<Integer> list = map.get(key);
                list.add(i);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }

        Set<Map.Entry<String, List<Integer>>> entrySet = map.entrySet();

        List<List<Integer>> result = new ArrayList<>();

        Iterator<Map.Entry<String, List<Integer>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {

            Map.Entry<String, List<Integer>> entry = iterator.next();
            List<Integer> valueList = entry.getValue();

            int size = valueList.size();
            int keyInteger = Integer.parseInt(entry.getKey());

            if (size > keyInteger) {
                for (int i = 0; i < size; i += keyInteger) {
                    result.add(valueList.subList(i, i + keyInteger));
                }

            } else {
                result.add(entry.getValue());
            }
        }

        return result;
    }

}
