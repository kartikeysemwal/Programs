import java.util.*;

class Solution {
    public int trapRainWater(int[][] height) {
        int n = height.length;
        int m = height[0].length;

        int postXMax[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    postXMax[i][j] = height[i][j];
                    continue;
                }

                postXMax[i][j] = Math.max(postXMax[i][j + 1], height[i][j]);
            }
        }

        int preYMax[][] = new int[n][m];
        int postYMax[][] = new int[n][m];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    preYMax[i][j] = height[i][j];
                    continue;
                }

                preYMax[i][j] = Math.max(preYMax[i - 1][j], height[i][j]);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    postYMax[i][j] = height[i][j];
                    continue;
                }

                postYMax[i][j] = Math.max(postYMax[i + 1][j], height[i][j]);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int preMax = height[i][0];

            for (int j = 0; j < m; j++) {
                int curMin = Math.min(preMax, Math.min(postXMax[i][j],
                        Math.min(preYMax[i][j], postYMax[i][j])));

                ans = ans + Math.max(0, curMin - height[i][j]);

                preMax = Math.max(preMax, height[i][j]);
            }
        }

        return ans;
    }
}