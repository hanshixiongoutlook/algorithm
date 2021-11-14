package hans.leetcode.dp;

import hans.algorithm.utils.Logger;
import org.junit.Test;

public class Easy0509_FibonacciNumber {



    @Test
    public void test() {

        int num = fib(6);
        Logger.log(num);
    }
    /**
     * dynamic programming optimized
     * O(N) = n
     * f(n) = 0  n=0
     * f(n) = 1  0<n<=2
     * f(n) = f(n-1)+f(n-2) n>2
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:34.9 MB,击败了88.71% 的Java用户
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n==0) {
            return 0;
        }
        if (n<=2) {
            return 1;
        }
        int pre = 1,cur = 1;
        for (int i=3; i<=n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
    class Sulotion3 {
        /**
         * dynamic programming
         * O(N) = n
         * f(n) = 0  n=0
         * f(n) = 1  0<n<=2
         * f(n) = f(n-1)+f(n-2) n>2
         *			执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:35 MB,击败了86.15% 的Java用户
         * @param n
         * @return
         */
        public int fib(int n) {
            if (n==0) {
                return 0;
            }
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i=2; i<=n; i++) {
                dp[i] = dp[i-1] +dp[i-2];
            }
            return dp[n];
        }

    }
    class Sulotion2 {
        /**
         * recursion with dictionary
         * O(N) = n
         * f(n) = 0  n=0
         * f(n) = 1  0<n<=2
         * f(n) = f(n-1)+f(n-2) n>2
         *
         * 			执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:35 MB,击败了88.19% 的Java用户
         * @param n
         * @return
         */
        public int fib(int n) {
            if (n==0) {
                return 0;
            }
            if (n<=2) {
                return 1;
            }
            int[] dic = new int[n+1];
            dic[0] = 0;
            dic[1] = 1;
            dic[2] = 1;
            return helper(n, dic);
        }

        public int helper(int n, int[] dic) {
            if (dic[n]!=0) {
                return dic[n];
            }
            dic[n] = helper(n-1, dic)+helper(n-2, dic);
            return dic[n];
        }
    }
    class Sulotion1 {
        /**
         * simple recursion
         * O(N) = n^2
         * f(n) = 0  n=0
         * f(n) = 1  0<n<=2
         * f(n) = f(n-1)+f(n-2) n>2
         *
         * 			执行耗时:6 ms,击败了27.24% 的Java用户
         * 			内存消耗:34.8 MB,击败了96.22% 的Java用户
         * @param n
         * @return
         */
        public int fib(int n) {
            if (n==0) {
                return 0;
            }
            if (n<3) {
                return 1;
            }
            return fib(n-1)+fib(n-2);
        }
    }

}
