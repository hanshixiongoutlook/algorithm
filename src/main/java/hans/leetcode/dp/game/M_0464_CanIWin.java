package hans.leetcode.dp.game;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * In the "100 game" two players take turns adding, to a running total, any
 * integer from 1 to 10. The player who first causes the running total to reach or exceed
 * 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of
 * numbers from 1 to 15 without replacement until they reach a total >= 100.
 * <p>
 * Given two integers maxChoosableInteger and desiredTotal, return true if the
 * first player to move can force a win, otherwise, return false. Assume both players
 * play optimally.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 11
 * Output: false
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2
 * up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >=
 * desiredTotal.
 * Same with other integers chosen by the first player, the second player will
 * always win.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 0
 * Output: true
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 1
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 * <p>
 * Related Topics 位运算 记忆化搜索 数学 动态规划 状态压缩 博弈 👍 295 👎 0
 */
public class M_0464_CanIWin {

    @Test
    public void test() {
        /*
        10 9 8 7
        1  2 1 2

         */
        boolean result = this.canIWin(16, 79);
        Logger.log("i={}, your={}", 79, result);
    }

    /**
     * 			Runtime:96 ms, faster than 35.54% of Java online submissions.
     * 			Memory Usage:45.1 MB, less than 33.68% of Java online submissions.
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        /*
        典型的博弈问题
        # 首先需要归纳【变量】和【决胜条件】

        变量：
        1.可选数字：这个很明显，不用多解释
        2.目标结果：即desiredTotal，这个也很好分析，每选一个数字，desiredTotal就要相应的减少，直到desiredTotal<=0时，就决出胜负了

        决胜条件：
        上边变量2已经分析出了决胜条件，即
        desiredTotal<=0时，比赛结束，此时出数的人赢

        # 接下来归纳变量的转换过程
        模拟一次比赛过程：
        maxChoosableInteger=10， desiredTotal=30
          选手    选择范围   本轮取值    desiredTotal
        1.A   -> [1,10]   -> 10    ->   20
          B   -> [1,9]    -> 9     ->   11
        2.A   -> [1,8]    -> 8     ->   3
          B   -> [1,7]    -> 7     ->   -4  -> B 胜了
        以上是该条件下的一种出牌方式
        对于A来说，第一轮，可以取[1,10]中任意一个值，只要有一个能赢就行
        对于B涞水，第一轮，同样可以取[1,10]剩余的9个数字，只要有一种能赢，B就胜了

        这不可避免的就需要遍历了，而且，观察发现A、B胜出的方式还是一样的
        接下来就是将决胜过程翻译成代码实现

        # 将变化过程翻译成程序过程
        1.先给出遍历，范围：1~maxChoosableInteger，第一个变量就用上了
        for[num in 1~maxChoosableInteger]

        2.接下来看在循环里干点什么，显然，我要尝试每个数字都选一遍看看最终那个能赢
        desiredTotal = desiredTotal-num // 拿出一个数字试试能不能赢
        if (desiredTotal<=0)  能赢 else 还得继续比，过程一样 // 这显然是个递归过程，需要设计递归函数了

        3.接下来设计递归函数，
        先看入参：
            maxChoosableInteger和desiredTotal少不了，
            接下来还需要标记哪些数字用过了，即需要一个flag
        在看返回值：
            只需要知道输赢就行，返回boolean就行
        退出条件：
            显然只要决出胜负就能退出了，desiredTotal<=0
        基本的函数体这就有了
        boolean dfs(maxChoosableInteger,desiredTotal,flag) {
            // 把决胜过程带进来
            for[num in 1~maxChoosableInteger] {
                // 先检查下num用过了没有，如果用过了就不能再用了
                if (num in flag) continue;

                desiredTotal = desiredTotal-num;
                // 退出条件带进来
                if (desiredTotal<=0) {
                    return true;
                }
                // 没决出胜负怎么办，继续玩儿就行了，
                boolean isOpponentWin = dfs(maxChoosableInteger,desiredTotal,flag)
                // 但是接下来就该对手了，如果对手赢了，那自己就输了，只有对手输了自己才稳赢
                if (!isOpponentWin) {
                    return true;
                }
            }
            // 最后返回什么？所有牌都试了都赢不了，那可定就输了
            return false;
        }

        整理简化下递归框架
        boolean dfs(maxChoosableInteger,desiredTotal,flag) {
            for[num in 1~maxChoosableInteger] {
                if (num in flag) continue;
                if (desiredTotal<=num || !dfs(maxChoosableInteger,desiredTotal-num,flag)) {
                    return true;
                }
            }
            return false;
        }

        4.接下来就是考虑怎样标记哪些元素已经用过了，
        因为maxChoosableInteger最大为20，可以考虑使用二进制标记方案
        1 表示已使用   0 表示未使用
        如，
          987654321  可选数字
          101000100  二进制标记
          表示，9、7、3已经用了，其他未使用
        接下来是两个操作
        a.判断某个数字是否已使用
         以4为例，很简单 1<<(4-1) = 1000
               1000
        & 101000100
        -----------
          000000000 = 0
         4没使用

        b.标记某个值已使用
         还是以4为例，同样很简单 1<<(4-1) = 1000
               1000
        | 101000100
        -----------
          101001010
          这就标记上了

        放到框架里看看
        boolean dfs(maxChoosableInteger,desiredTotal,flag) {
            for[num in 1~maxChoosableInteger] {
                // 计算当前数字的开关
                int switch = 1<<(num-1)
                // 判断一下开关是否已经打开了，如果已经开了，就要跳过
                if (flag&switch > 0) continue;
                // 这个数字用掉了，把开关打开
                flag = flag|switch;
                if (desiredTotal<=num || !dfs(maxChoosableInteger,desiredTotal-num,flag)) {
                    return true;
                }
            }
            return false;
        }
        简化下看看
        boolean dfs(maxChoosableInteger,desiredTotal,flag) {
            for[num in 1~maxChoosableInteger] {
                int switch = 1<<(num-1);
                if (flag&switch > 0) continue;
                if (desiredTotal<=num || !dfs(maxChoosableInteger,desiredTotal-num,flag|switch)) {
                    return true;
                }
            }
            return false;
        }

        # 优化算法时间复杂度
        这样问题其实就已经解决了，但是执行发现，效率很低

         */
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs(0, desiredTotal, new Boolean[1 << maxChoosableInteger], maxChoosableInteger);
    }
    private boolean dfs(int state, int desiredTotal, Boolean[] dp, int maxChoosableInteger) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << (i - 1);
            if ((cur & state) != 0) {
                continue;
            }
            if (i >= desiredTotal || !dfs(cur | state, desiredTotal - i, dp, maxChoosableInteger)) {
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}
