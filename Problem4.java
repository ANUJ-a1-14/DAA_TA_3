/* 
Real-Life Use Case:
-------------------
This algorithm is used in navigation and routing systems.

Example:
Imagine a delivery robot moving in a warehouse grid.
Each cell has a cost (time, energy, or difficulty to cross).
The robot must move from the entrance (top-left) to the exit (bottom-right),
but it can only move RIGHT or DOWN due to fixed aisle directions.

The DP algorithm finds the minimum total cost route, ensuring:
- The robot uses the least energy
- The path is efficient and optimal

This same concept applies to:
- Google Maps shortest walking/driving path in restricted zones
- Pipeline routing in factories
- Minimizing travel time in grid-based city layouts
*/

public class Problem4 {
    public static int findMinSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {10, 8, 2},
            {10, 5, 1000},
            {1, 1, 2}
        };
        System.out.println("Minimum: " + findMinSum(grid));
    }
}
