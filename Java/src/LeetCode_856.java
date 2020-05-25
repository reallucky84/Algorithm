import java.util.Stack;

// https://leetcode.com/problems/score-of-parentheses/submissions/
public class LeetCode_856 {

    public static void main(String args[]) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(result);
                result = 0;
            } else {
                result = stack.pop() + Math.max(2 * result, 1);
            }
        }
        return result;
    }
}
