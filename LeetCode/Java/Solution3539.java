public class Solution3539 {
    public int magicalSum(int m, int k, int[] nums) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;
        int maxpos = (n - 1) + (32 - Integer.numberOfLeadingZeros(m) - 1);
        long[] fact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; ++i) fact[i] = fact[i - 1] * i % MOD;
        long[] ifac = new long[m + 1];
        ifac[m] = modPow(fact[m], MOD - 2, MOD);
        for (int i = m; i >= 1; --i) ifac[i - 1] = ifac[i] * i % MOD;
        long[][] pownums = new long[n][m + 1];
        for (int i = 0; i < n; ++i) {
            pownums[i][0] = 1;
            for (int c = 1; c <= m; ++c) pownums[i][c] = pownums[i][c - 1] * (nums[i] % MOD) % MOD;
        }
        long[][][] dp = new long[m + 1][m + 1][k + 1];
        dp[0][0][0] = 1;
        for (int pos = 0; pos <= maxpos; ++pos) {
            long[][][] ndp = new long[m + 1][m + 1][k + 1];
            if (pos < n) {
                long[] rowPow = pownums[pos];
                for (int used = 0; used <= m; ++used) {
                    int rem = m - used;
                    for (int carry = 0; carry <= m; ++carry) {
                        for (int pc = 0; pc <= k; ++pc) {
                            long val = dp[used][carry][pc];
                            if (val == 0) continue;
                            for (int c = 0; c <= rem; ++c) {
                                int nt = used + c;
                                int s = c + carry;
                                int bit = s & 1;
                                int npop = pc + bit;
                                if (npop > k) continue;
                                int nc = s >> 1;
                                long add = val * rowPow[c] % MOD * ifac[c] % MOD;
                                ndp[nt][nc][npop] += add;
                                if (ndp[nt][nc][npop] >= MOD) ndp[nt][nc][npop] -= MOD;
                            }
                        }
                    }
                }
            } else {
                for (int used = 0; used <= m; ++used) {
                    for (int carry = 0; carry <= m; ++carry) {
                        for (int pc = 0; pc <= k; ++pc) {
                            long val = dp[used][carry][pc];
                            if (val == 0) continue;
                            int s = carry;
                            int bit = s & 1;
                            int npop = pc + bit;
                            if (npop > k) continue;
                            int nc = s >> 1;
                            ndp[used][nc][npop] += val;
                            if (ndp[used][nc][npop] >= MOD) ndp[used][nc][npop] -= MOD;
                        }
                    }
                }
            }
            dp = ndp;
        }
        long res = dp[m][0][k] * fact[m] % MOD;
        return (int)res;
    }

    private long modPow(long a, long e, long mod) {
        long r = 1 % mod;
        a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) r = r * a % mod;
            a = a * a % mod;
            e >>= 1;
        }
        return r;
    }
}
