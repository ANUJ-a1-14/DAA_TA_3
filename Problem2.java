import java.util.*;

public class Problem2 {
    public static List<Integer> LIH(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int[] len = new int[n];      
        int[] prev = new int[n];      
        Arrays.fill(len, 1);
        Arrays.fill(prev, -1);

        int bestLen = 1; 
        int bestIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
            if (len[i] > bestLen) {
                bestLen = len[i];
                bestIndex = i;
            }
        }

        List<Integer> subset = new ArrayList<>();
        while (bestIndex != -1) {
            subset.add(arr[bestIndex]);
            bestIndex = prev[bestIndex];
        }
        Collections.reverse(subset);
        return subset;
    }

    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};
        System.out.println("Ans " + LIH(arr));
    }
}
