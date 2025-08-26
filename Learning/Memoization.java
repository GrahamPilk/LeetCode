package Learning;

public class Memoization {
    /*
     * Most of dynamic programming is solved in two ways
     * 1. Tabulation: Bottom Up
     * 2. Memoization: Top Down
     * The steps to write the DP solution of Top-down approach to any probem is to :
     * 1. Write the recursive code
     * 2. Memoize the return value and use it to reduce recursive calls. 
     * 
     * Key Principles of Memoization in Java:
     * 1. Cachine Results:
     * - A data structure, typically a HashMap or ConcurrentHashMap, is used to store the computed result. The funtctions input serves as the key, and the computed result is the value.  
     * 2. Checking the cache:
     * - Before performaing any computation, the function first checks if the result for the given input already exists in the cache. 
     * 3. Storing New Results
     * - If the result is not found in the cache, the function proceeds with its computation. Once the result is obtained, it is stored in the cache for future use before being returned. 
     * 
     * 1D Memoization: Since only one parameter is constant it is known as 1-D memoization. 
     * Example: Fibonacci Series using Recusiion
     */

     static int fib(int n) {
        if(n<=1) return n; //base case;
        return fib(n-1) + ///recursive calls
               fib(n-2);
     } //Time ComplexityL O(2^n), Space Complexity: O(n)

     /*
      * 2-D Memoization is where the recursive program has two-non constant arguments to be shown. 
      Example: LCS Problem
      */
      static int max(int a, int b) { return (a > b) ? a : b; } //utility function to get max of 2 ints
      static int lcs(String X, String Y, int m, int n) { //Returns length of LCS for X[0..m-1], Y[0..n-1]
        if(m == 0 || n == 0) {
            return 0;
        }
        if(X.charAt(m-1) == Y.charAt(n-1)){
            return 1 + lcs(X, Y, m-1, n-1);
        } else {
            return max(lcs(X,Y,m,n-1), 
                       lcs(X,Y,m-1,n));
        }
      }

      /*
       * 3-D Memoization: three non constant arguments is done. 
       * Example: Recursion solution to the LCS problem:
       */
    public static int[][][] arr = new int[100][100][100];
    static int lcs(String X, String Y, String Z,
                 int m, int n, int o)
  {
    
      // base case
      if (m == 0 || n == 0 || o == 0)
          return 0;

      // if the same state has already been
      // computed
      if (arr[m - 1][n - 1][o - 1] != -1)
          return arr[m - 1][n - 1][o - 1];

      // if equal, then we store the value of the
      // function call
      if (X.charAt(m - 1) == Y.charAt(n - 1) && 
          Y.charAt(n - 1) == Z.charAt(o - 1)) {

          // store it in arr to avoid further repetitive work
          // in future function calls
          arr[m - 1][n - 1][o - 1] = 1 + lcs(X, Y, Z, m - 1,
                                              n - 1, o - 1);
          return arr[m - 1][n - 1][o - 1];
      }
      else
      {

          // store it in arr to avoid further repetitive work
          // in future function calls
          arr[m - 1][n - 1][o - 1] =
                                 max(lcs(X, Y, Z, m, n - 1, o),
                                   max(lcs(X, Y, Z, m - 1, n, o),
                                      lcs(X, Y, Z, m, n, o - 1)));
          return arr[m - 1][n - 1][o - 1];
      }
  }






     public static void main(String[] args){
        System.out.println(fib(6)); //Output: 8

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();

        System.out.print("Length of LCS is "
                         + lcs(X, Y, m, n)); // Output: 4




        for(int i = 0; i < 100; i++) 
    {
      for(int j = 0; j < 100; j++) 
      {
        for(int k = 0; k < 100; k++)
        {
          arr[i][j][k] = -1;
        }
      }
    }
        String P = "geeks";
    String L = "geeksfor";
    String Z = "geeksforgeeks";
        int y = P.length();
        int u = L.length();
        int o = Z.length();
        System.out.println("Length of LCS is " + lcs(P, L, Z, y, u, o));
     }
}
