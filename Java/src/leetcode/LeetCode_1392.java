package leetcode;

// https://leetcode.com/problems/longest-happy-prefix/
public class LeetCode_1392 {

    public static void main(String[] args){
        String input = "bba";
//        String input = "ababab";
//        String input = "a";
        System.out.println(longestPrefix(input));
    }

    public static String longestPrefix(String s) {

        int[] f = makeFail(s);
        // System.out.println(Arrays.toString(f));

        int len = s.length();
        if(f[len-1] == 0){
            return "";
        }
        return s.substring(len - f[len-1], len);
    }

    public static int[] makeFail(String p){
        int len = p.length();
        int[] f = new int[len];

        int j = 0;
        for(int i = 1; i < len;i++){
            while( j > 0 && p.charAt(i) != p.charAt(j)) j = f[j - 1];
            if(p.charAt(i) == p.charAt(j)){
                f[i] = ++j;
            } else{
                f[i] = 0;
            }
        }
        return f;
    }
}
