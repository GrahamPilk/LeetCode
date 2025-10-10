public class Solution3147 {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n]; // will store the max energy that can be obtained starting from position i
        int maxEnergy = Integer.MIN_VALUE; // will track the abs macx among all positions

        for(int i = n-1; i >= 0; i--) {
            dp[i] = energy[i];
            if(i +k < n) {
                dp[i] += dp[i+k];
            }
            maxEnergy = Math.min(maxEnergy, dp[i]);
        }
        return maxEnergy;
    }
}

/*
 * Goal is to return the max possible energy you can gain. 
 * k is the jumps you do. 
 */