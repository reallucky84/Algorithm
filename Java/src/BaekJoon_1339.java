import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1339
public class BaekJoon_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        Set<Character> set = new LinkedHashSet<>();
        for (String s : word) {
            for (char c : s.toCharArray()) {
                set.add(c);
            }
        }
//        Iterator<Character> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        int setSize = set.size();
        int[] d = new int[setSize];

        for (int i = 0; i < setSize; i++) {
            d[i] = 9 - i;
        }
        Arrays.sort(d);

        int result = 0;
        do{
            result = Math.max(result, cal(d, set, word));
        } while(next_permutation(d));

        System.out.println(result);

    }

    public static int cal(int[] d, Set<Character> set, String[] word){

        Map<Character, Integer> map = new HashMap<>();
        Iterator<Character> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            map.put(iterator.next(), d[i]);
            i++;
        }

        int sum = 0;
        for (String s : word) {
            int wordSum = 0;
            for (char c : s.toCharArray()) {
                wordSum = (wordSum *10) + map.get(c);
            }
            sum += wordSum;
        }
        return sum;

    }

    public static boolean next_permutation(int[] arr) {
        int len = arr.length;
        int i = len - 1;

        while (i > 0) {
            if (arr[i - 1] < arr[i]) break;
            i--;
        }

        if (i <= 0) return false;

        int j = len - 1;
        while (j >= i) {
            if (arr[i - 1] < arr[j]) break;
            j--;
        }

        swap(i - 1, j, arr);

        len--;
        while (i < len) {
            swap(i, len, arr);
            len--;
            i++;
        }
        return true;

    }

    public static void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
