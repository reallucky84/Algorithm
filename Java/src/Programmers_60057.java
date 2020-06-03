// https://programmers.co.kr/learn/courses/30/lessons/60057
public class Programmers_60057 {

    public static void main(String[] args) {
//        String s = "ababcdcdababcdcd";
        String s = "a";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 9999999;

        if(s.length() == 1){
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String needle = s.substring(0, i);
            int count = 0;
            for (int k = i; k < s.length(); k += i) {
//                System.out.print(needle + " " + k + " " + i + " ");
                String candidate;
                if (k + i < s.length()) {
                    candidate = s.substring(k, k + i);
                } else {
                    candidate = s.substring(k);
                }
//                System.out.println(candidate);
                if (candidate.equals(needle)) {
                    count++;
                } else {
                    if (count > 0) {
                        sb.append(count + 1);
                        count = 0;
                    }
                    sb.append(needle);
                    needle = candidate;
                }
            }
            if (count > 0) {
                sb.append(count + 1);
            }
            sb.append(needle);
//            System.out.println(sb);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
