package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10815
public class BaekJoon_10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int i = 0;
        for(String s: br.readLine().split(" ")){
            arr[i++] = Integer.parseInt(s);
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        i = 0;
        StringBuilder sb = new StringBuilder();
        for(String s: br.readLine().split(" ")){
            sb.append(' ');
            sb.append(binarySearch(arr, Integer.parseInt(s)));
        }
        sb.deleteCharAt(0);
        System.out.print(sb);

    }

    public static int binarySearch(int[] arr, int num){
        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] == num){
                return 1;
            }

            if(arr[mid] < num){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        return 0;
    }
}
