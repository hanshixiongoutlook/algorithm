package hans.leetcode.dp.matrix;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 We are playing the Guessing Game. The game will work as follows:


 I pick a number between 1 and n.
 You guess a number.
 If you guess the right number, you win the game.
 If you guess the wrong number, then I will tell you whether the number I
 picked is higher or lower, and you will continue guessing.
 Every time you guess a wrong number x, you will pay x dollars. If you run out
 of money, you lose the game.


 Given a particular n, return the minimum amount of money you need to guarantee
 a win regardless of what number I pick.


 Example 1:


 Input: n = 10
 Output: 16
 Explanation: The winning strategy is as follows:
 - The range is [1,10]. Guess 7.
     - If this is my number, your total is $0. Otherwise, you pay $7.
     - If my number is higher, the range is [8,10]. Guess 9.
         - If this is my number, your total is $7. Otherwise, you pay $9.
         - If my number is higher, it must be 10. Guess 10. Your total is $7 + $9
 = $16.
         - If my number is lower, it must be 8. Guess 8. Your total is $7 + $9 =
 $16.
     - If my number is lower, the range is [1,6]. Guess 3.
         - If this is my number, your total is $7. Otherwise, you pay $3.
         - If my number is higher, the range is [4,6]. Guess 5.
             - If this is my number, your total is $7 + $3 = $10. Otherwise, you
 pay $5.
             - If my number is higher, it must be 6. Guess 6. Your total is $7 +
 $3 + $5 = $15.
             - If my number is lower, it must be 4. Guess 4. Your total is $7 + $
 3 + $5 = $15.
         - If my number is lower, the range is [1,2]. Guess 1.
             - If this is my number, your total is $7 + $3 = $10. Otherwise, you
 pay $1.
             - If my number is higher, it must be 2. Guess 2. Your total is $7 +
 $3 + $1 = $11.
 The worst case in all these scenarios is that you pay $16. Hence, you only need
 $16 to guarantee a win.


 Example 2:


 Input: n = 1
 Output: 0
 Explanation: There is only one possible number, so you can guess 1 and not have
 to pay anything.


 Example 3:


 Input: n = 2
 Output: 1
 Explanation: There are two possible numbers, 1 and 2.
 - Guess 1.
     - If this is my number, your total is $0. Otherwise, you pay $1.
     - If my number is higher, it must be 2. Guess 2. Your total is $1.
 The worst case is that you pay $1.



 Constraints:


 1 <= n <= 200

 Related Topics 数学 动态规划 博弈 👍 458 👎 0

 */
public class M_0375_GuessNumberHigherOrLower2 {

    @Test
    public void test() {
        for (int i=4; i<100; i++) {
            int result = this.getMoneyAmount(i);
            Logger.log(i+"="+result);

        }
    }

    /**
     * 			执行耗时:25 ms,击败了19.81% 的Java用户
     * 			内存消耗:37.5 MB,击败了51.79% 的Java用户
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        if (n==1) {
            return 1;
        }
        /*
      先给出状态函数：
      dp[x][y] 代表，x-y 猜中最少钱数

      以1-5为例，穷举所有分界点所需钱数：
      分界点=5，则dp[1][5] = 5 + dp[1][4] = 9
      分界点=4，则dp[1][5] = 4+ max(dp[1][3],dp[5][5]) = 6
      分界点=3，则dp[1][5] = 3+ max(dp[1][2],dp[4][5]) = 8
      分界点=2，则dp[1][5] = 2+ max(dp[1][1],dp[3][5]) = 5
      分界点=1，则dp[1][5] = 1+ dp[2][5] = 7

      求解：
      从所有情况中选择最优解，即以2为分界点时，代价最小，为5

      此时问题就在如如何填充整个二位数组来
      保证，每一个状态计算时，所依赖的状态已经填充过

      不难发现如下基本情况：
      x=y，  dp[x][y] = 0
      y-x=1, dp[x][y] = x

      可以采取纵坐标从小到大，横坐标从大到小填充
      举例
      x=y的部分不必填充，在java中int数组默认会初始化成0，其他编程语言则需要按需填充0
      第1趟：y=2, x=1, dp[1][2] = 1
      第2趟：y=3, x=2, dp[2][3] = 2
                 x=1, dp[1][3] = min(1+dp[2][3], 2+max(dp[1][1],dp[3][3]), 3+dp[1][2])
      第3趟：y=4, x=3, dp[3][4] = 3
                 x=2, dp[2][4] = min(2+dp[3][4], 3+max(dp[2][2],dp[4][4]), 4+dp[2][3])
                 x=1, dp[1][4] = min(1+dp[2][4], 2+max(dp[1][1],dp[3][4]), 3+max(dp[1][2],dp[4][4]), 4+dp[1][3])
       后边不再列举，可以推导出伪代码如下
       int[] dp = int[n+1][n+1]
       for : y=2; y<=n; y++
            for : x=y-1; x>0; x--
                if ( (y-x) == 1 )
                    dp[x][y] = x;
                else
                    // p要从x+1开始，因为左界限为 [x,p-1]，如果p=x，会出现dp[x][x-1]没有意义
                    // p要小于y，因为右界限为[p+1][y]，如果p=y，会出现dp[y+1][y]没有意义
                    for : p=x+1;p<y;p++
                        // 这是初始情况，尚未填充结果，需要先填充一个结果
                        if (dp[x][y]==0)
                            dp[x][y] = p+max(dp[x][p-1], dp[p+1][y])
                        else
                            dp[x][y] = min(dp[x][y], p+max(dp[x][p-1], dp[p+1][y]))

         */
        int[][] dp = new int[n+1][n+1];
        for (int y=2; y<=n; y++) {
            for (int x=y-1; x>0; x--) {
                if (y-x==1) {
                    dp[x][y] = x;
                } else {
                    for (int p=x; p<y; p++) {
                        if (dp[x][y]>0) {
                            dp[x][y] = Math.min(dp[x][y],p+Math.max(dp[x][p-1],dp[p+1][y]));
                        } else {
                            dp[x][y] = p+Math.max(dp[x][p-1],dp[p+1][y]);
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }
}
