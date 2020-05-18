
// https://leetcode.com/problems/long-pressed-name/
public class LeetCode_925 {

    public boolean isLongPressedName(String name, String typed) {

        int nameLen = name.length();

        int i = 0;
        char prev = ' ';
        for(char c: typed.toCharArray()){

            if(i < nameLen && c == name.charAt(i)){
                i++;
            } else if(c != prev){
                return false;
            }
            prev = c;
        }

        return i >= nameLen;
    }
}
