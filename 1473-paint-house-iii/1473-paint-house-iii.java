class Solution {
    int MAX = 100000000;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                Arrays.fill(dp[i][j], -1);
        }

        int ans = paintRecursively(houses, cost, m, n, target, 0, 0, -1, dp);
        if (ans == MAX) {
            return -1;
        }
        return ans;
    }

    public int paintRecursively(int[] houses, int[][] cost, int m, int n, int target,
                                int houseToBePainted,
                                int currentTarget,
                                int lastNbhColor,
                                int[][][] dp
    ) {
        if (houseToBePainted == m) {
            if (currentTarget == target) return 0;
            return MAX;
        }
        if (currentTarget == target + 1) return MAX;
        if (lastNbhColor != -1) {
            if (dp[houseToBePainted][lastNbhColor][currentTarget] != -1) {
                return dp[houseToBePainted][lastNbhColor][currentTarget];
            }
        }
        int minCost = MAX;
        for (int currentColor = 0; currentColor < n; ++currentColor) {
            boolean isFree = false;
            if (houses[houseToBePainted] != 0) {
                if (houses[houseToBePainted] != currentColor + 1)
                    continue;
                else
                    isFree = true;
            } 
            if (currentColor != lastNbhColor) {
                minCost = Math.min(minCost, paintRecursively(houses, cost, m, n, target, houseToBePainted + 1, currentTarget + 1, currentColor, dp) + ((isFree) ? 0 : cost[houseToBePainted][currentColor]));

            } else { 
                minCost = Math.min(minCost, paintRecursively(houses, cost, m, n, target, houseToBePainted + 1, currentTarget, currentColor, dp) + ((isFree) ? 0 : cost[houseToBePainted][currentColor]));
            }
        }
        if (lastNbhColor != -1) {
            dp[houseToBePainted][lastNbhColor][currentTarget] = minCost;
        }
        return minCost;
    }

}