import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class LeetCode_983 {

    public static void main(String[] args) {
//        int[] days = new int[]{3, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 21, 23, 25, 26, 27, 29, 30, 33, 34, 35, 36, 38, 39, 40, 42, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 58, 59, 60, 61, 63, 64, 67, 68, 69, 70, 72, 74, 77, 78, 79, 80, 81, 82, 83, 84, 85, 88, 91, 92, 93, 96};
//        int[] costs = new int[]{3, 17, 57};

        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};

        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int endDay = days[days.length - 1];
        int startDay = days[0];
        int[] d = new int[endDay + 1];
        Set<Integer> daySet = new HashSet<>();
        for(int day: days){
            daySet.add(day);
        }
        Arrays.fill(d, 0);

        for (int i = startDay; i <= endDay; i++) {
            if(daySet.contains(i)){
                int day1 = ((i - 1) > 0 ? d[i - 1] : 0) + costs[0];
                int day7 = ((i - 7) > 0 ? d[i - 7] : 0) + costs[1];
                int day30 = ((i - 30) > 0 ? d[i - 30] : 0) + costs[2];
                d[i] = Math.min(day1, Math.min(day7, day30));
            } else{
                d[i] = d[i-1];
            }

//            System.out.println(Arrays.toString(d));
        }

        return d[endDay];
    }


}
