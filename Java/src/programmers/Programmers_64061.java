package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/64061
public class Programmers_64061 {
    public static void main(String[] args){
        int[][] board = new int[5][5];
        board[0] = new int[]{0, 0, 0, 0, 0};
        board[1] = new int[]{0, 0, 1, 0, 3};
        board[2] = new int[]{0, 2, 5, 0, 1};
        board[3] = new int[]{4, 2, 4, 4, 2};
        board[4] = new int[]{3, 5, 1, 3, 1};

        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> list = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            list.add(new Stack<Integer>());
        }

        for(int k = board.length - 1; k >=0; k--){
            int len = board[k].length;
            for(int i = 0; i < len; i++){
                if(board[k][i] > 0) list.get(i).push(board[k][i]);
            }
        }

        // for(Stack<Integer> s : list){
        //     System.out.println(s.size());
        // }

        int answer = 0;
        Stack<Integer> pops = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            if(!list.get(moves[i] - 1).isEmpty()){
                Integer val = list.get(moves[i] - 1).pop();
                // System.out.println(val);
                if(!pops.isEmpty() && pops.peek().equals(val)){
                    pops.pop();
                    answer += 2;
                } else{
                    pops.push(val);
                }
            }
        }

        return answer;
    }
}
