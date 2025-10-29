# DAA_TA_3


## Brief Explanations

---

### Q1. Longest Increasing Subsequence (LIS)

- Find longest subsequence with strictly increasing elements.
- DP:
  - `dp[i] = 1`
  - For each `i`, check all `j < i`
  - If `arr[j] < arr[i]` → `dp[i] = max(dp[i], dp[j] + 1)`
- Answer = `max(dp)`

---

### Q2. Longest Divisible Subset (LDS)

- Largest subset where every pair is divisible.
- Sort the array.
- DP + backtracking:
  - `dp[i] = 1`, `prev[i] = -1`
  - For each `i`, check all `j < i`
  - If `arr[i] % arr[j] == 0` → `dp[i] = dp[j] + 1`, `prev[i] = j`
- Reconstruct subset by backtracking from max `dp` index.

---

### Q3. Multistage Graph (Shortest Path)

- DAG divided into stages; find minimum cost path.
- Let `cost[i]` = minimum cost from `i` to destination.
- `cost[destination] = 0`
- For each node (from last stage to first):
  - `cost[u] = min(weight(u→v) + cost[v])` for all outgoing edges.
- Answer = `cost[source]`

---

### Q4. Minimum Path Sum in a Grid

- Move only right or down.
- DP:
  - `dp[0][0] = grid[0][0]`
  - First row → `dp[0][j] = dp[0][j-1] + grid[0][j]`
  - First column → `dp[i][0] = dp[i-1][0] + grid[i][0]`
  - Others → `dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])`
- Answer = `dp[m-1][n-1]`

---

