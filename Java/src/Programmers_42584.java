import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42584
public class Programmers_42584 {

    public static void main(String[] args){
        int[] input = new int[]{1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(input)));
    }

    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        answer[len-1] = 0;
        for(int i = 0; i < len-1; i++){
            int count = 0;
            for(int k = i+1; k < len; k++){
                count++;
                if(prices[i] > prices[k]){
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
