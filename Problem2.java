/*
Real Life Use Case of Longest Divisible Subset (LDS):
An example is deciding packet sizes in networking or warehouse box stacking:

Example:
If box sizes are: 1, 4, 8, 16
We want to choose sizes such that each larger box can perfectly contain the smaller one.
Longest divisible subset: 1 → 4 → 8 → 16

So this algorithm is useful in:
- Selecting compatible container/packet sizes
- Grouping tasks or resources where one must fully depend on another
- Any system where “one must be a multiple of the other” relationship is required
*/

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
