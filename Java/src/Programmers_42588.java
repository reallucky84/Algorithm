import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42588
public class Programmers_42588 {

    public static void main(String[] args){
        int[] input = new int[]{6, 9, 5, 7, 4};
        System.out.println(solution(input));
    }

    public static int[] solution(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];

        int lastHeight = heights[0];
        int lastIndex = 0;
        answer[0] = 0;

        for(int i = 1 ; i < len ; i++){
            if(lastHeight > heights[i]){
                answer[i] = lastIndex + 1;
                if(i+1 < len && heights[i] > heights[i+1]){
                    lastHeight = heights[i];
                    lastIndex = i;
                }
            } else{
                lastHeight = heights[i];
                lastIndex = i;
                answer[i] = 0;
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
