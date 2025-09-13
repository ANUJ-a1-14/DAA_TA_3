# DAA_TA_3
Solutions of TA problems.

Q1. Longest Increasing Subsequence (LIS)
We desire the longest subsequence in increasing order.
For every element arr[i], compare all earlier arr[j] (j<i).
If arr[j] < arr[i], update subsequence:
dp[i] = max(dp[i], dp[j] + 1)
Initialize dp[i] = 1 (all elements are an LIS of length 1).
Answer = max(dp[i]).

Q2. Longest Divisible Subset (LDS)
We desire the greatest subset in which each pair (a,b) is divisible.
First sort the array.
For every number arr[i], check all earlier arr[j] (j<i).
If arr[i] % arr[j] == 0, then extend:
dp[i] = max(dp[i], dp[j] + 1)
Maintain a prev[] array to build the subset.
Answer = subset constructed by backtracking from the max index.

Q3. Multistage Graph (Shortest Path)
A multistage graph is a DAG partitioned into stages.
We compute the shortest path from source to sink through backward DP.
Let cost[i] = minimum cost from node i to sink.
Initialize: cost[sink] = 0.
For each node u (last to first):
cost[u] = minimum( w + cost[v] ) for all edges (u→v) with weight w
Answer = cost[source].

Q4. Minimum Path Sum in a Grid
Move right or down only from top-left to bottom-right.
Use DP table: dp[i][j] = min sum to reach (i,j).
Base:
dp[0][0] = grid[0][0]
dp[0][j] = dp[0][j-1] + grid[0][j]   (first row)
dp[i][0] = dp[i-1][0] + grid[i][0]   (first col)
Transition:
dp[i][j] = grid[i][j] + minimum of (dp[i-1][j], dp[i][j-1])
Answer = dp[m-1][n-1].
