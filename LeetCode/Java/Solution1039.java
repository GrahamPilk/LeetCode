class Solution1039 {
    public int minScoreTriangulation(int[] values) {
        if(values == null || values.length < 3) return 0;
        int n = values.length;
        if(n == 3) return values[0] * values[1] * values[2]; //basic checks for edge cases. 
        int[][] dp = new int[n][n];
        for(int len = 3; len <= n; len++){
            for (int i = 0; i+len-1 < n; i++) {
                int j = i + len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i]*values[j]*values[k]);
                }
            }
        }
        return dp[0][n-1];
    }
}

/*
 * 1039. Minimum Score Triangulation of Polygon
 * Question: You have a convex n-sided polygon where each vertex has a positive integer value. You are given an integer array values where values[i] is the value of the ith vertex in clockwise order.
 * - Polygon triangulation is the process where you divide the polygon into a set of traingles and the vertices of each traingle must also be vertices of the original polygon. 
 * - You will triangulate the polyugon. FOr each triangle, the weight of that triangle is the product of the values at its verticies. The total score is the sum of these weights over all n-2 traingles. 
 * - Return the min possible score that you can achievewith some triangulation of the polygon
 * 
 * 
 */