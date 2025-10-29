/*
Real Life Use Case of Multistage Graph (Shortest Path):

Flight ticket booking with layovers:
Each airport is a stage. Each flight has a cost.
We want the cheapest route from the first airport to the final destination.

Similar applications:
- Manufacturing pipeline steps (choosing cheapest machines in sequence)
- Task planning where tasks are divided in ordered phases
- Routing in communication networks where data must pass through fixed stages

The algorithm works backward from the destination computing minimum cost to reach the end from each node.
*/

import java.util.*;

public class Problem3 {
    static int nodes = 14;

    static int MSG(List<int[]>[] graph) {
        int[] cost = new int[nodes];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[nodes - 1] = 0;
        for (int u = nodes - 2; u >= 0; u--) {
            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                cost[u] = Math.min(cost[u], w + cost[v]);
            }
        }
        return cost[0];
    }

    public static void main(String[] args) {
        List<int[]>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++) graph[i] = new ArrayList<>();

        graph[0].add(new int[]{1, 4});
        graph[0].add(new int[]{2, 6});
        graph[1].add(new int[]{3, 7});
        graph[1].add(new int[]{4, 3});
        graph[2].add(new int[]{4, 5});
        graph[2].add(new int[]{5, 8});
        graph[3].add(new int[]{6, 2});
        graph[4].add(new int[]{6, 4});
        graph[4].add(new int[]{7, 78});
        graph[5].add(new int[]{7, 69});
        graph[6].add(new int[]{8, 67});
        graph[7].add(new int[]{8, 66});
        graph[8].add(new int[]{9, 2});
        graph[9].add(new int[]{10, 4});
        graph[10].add(new int[]{11, 6});
        graph[11].add(new int[]{12, 5});
        graph[12].add(new int[]{13, 3});

        System.out.println("Minimum cost is: " + MSG(graph));
    }
}
