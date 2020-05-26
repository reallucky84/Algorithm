
// https://leetcode.com/problems/minimum-cost-for-tickets/
public class LeetCode_983 {

    static int min = 99999999;
    static int len = 0;

    public static void main(String[] args) {
        int[] days = new int[]{3, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 21, 23, 25, 26, 27, 29, 30, 33, 34, 35, 36, 38, 39, 40, 42, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 58, 59, 60, 61, 63, 64, 67, 68, 69, 70, 72, 74, 77, 78, 79, 80, 81, 82, 83, 84, 85, 88, 91, 92, 93, 96};
        int[] costs = new int[]{3, 17, 57};

        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        len = days.length;
        int[] prices = new int[days.length];
        buyTicket(days, 1, costs[0], days[0], costs, prices);
        buyTicket(days, 1, costs[1], days[0] + 6, costs, prices);
        buyTicket(days, 1, costs[2], days[0] + 29, costs, prices);

        return min;
    }

    public static void buyTicket(int[] days, int index, int price, int limit, int[] costs, int[] prices) {
        if (index == len) {
            min = Math.min(min, price);
            return;
        }

        if (prices[index] > 0 && price > prices[index]) {
            return;
        }

        if (days[index] > limit) {
            buyTicket(days, findIndex(days, days[index], index), price + costs[0], days[index], costs, prices);
            buyTicket(days, findIndex(days, days[index] + 6, index), price + costs[1], days[index] + 6, costs, prices);
            buyTicket(days, findIndex(days, days[index] + 29, index), price + costs[2], days[index] + 29, costs, prices);
        }
    }

    public static int findIndex(int[] days, int limit, int index) {
        for (int i = index + 1; i < len; i++) {
            if(days[i] > limit) return i;
        }
        return len;
    }
}
