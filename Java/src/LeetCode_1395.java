// https://leetcode.com/problems/count-number-of-teams/
public class LeetCode_1395 {

    int result = 0;
    int n = 0;

    public int numTeams(int[] rating) {
        n = 3;
        int[] choices = new int[n];
        find(rating, 0, choices, 0);
        return result;
    }

    public void find(int[] rating, int pickCount, int[] choices, int index){

        if(pickCount == n){
            if(check(rating, choices)){
                result++;
            }
            return;
        }

        if(n - pickCount >= rating.length-index){
            //pick
            choices[pickCount] = index;
            find(rating, pickCount+1, choices, index+1);
        } else{
            //pick
            choices[pickCount] = index;
            find(rating, pickCount+1, choices, index+1);
            //not pick
            find(rating, pickCount, choices, index+1);
        }

    }

    public boolean check(int[] rating, int[] choices){
        // System.out.println(Arrays.toString(choices));
        boolean isIncrease = false;

        for(int i = 1; i < n; i++){
            if(rating[choices[i-1]] < rating[choices[i]]){
                isIncrease = true;
            } else{
                isIncrease = false;
                break;
            }
        }
        if(isIncrease){
            return true;
        }

        boolean isDecrease = false;

        for(int i = 1; i < n; i++){
            if(rating[choices[i]] < rating[choices[i-1]]){
                isDecrease = true;
            } else{
                isDecrease = false;
                break;
            }
        }

        return isDecrease;
    }
}
