public class Solution3370 {
    public int smallestNumber(int n) {
        int result = 0;
        int i = 0;
        while (result < n) {
            result += Math.pow(2, i);
            i++;
        }
        return result;
    }
}

/*
n = 5, i = 1, result = 2^0 = 1 -- result = 2^1  + prev = 3, i = 2 -- result = 2^2 + prev  = 7, i == 3 -- 7 < 5 so result = 7
Goal: is to find the smallest number that can be represented as the sum of distinct powers of 2 and is greater than or equal to n 
*/
