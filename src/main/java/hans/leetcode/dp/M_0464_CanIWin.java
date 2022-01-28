package hans.leetcode.dp;

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
        boolean result = this.canIWin(18, 79);
        Logger.log("i={}, your={}", 79, result);
        result = this.canIWin2(18, 79);
        Logger.log("i={}, my={}", 79, result);
        for (int i=20; i<55; i++) {
        }
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        /*
        变量
        选择内容，
            从1~max中选，使用过的，不能再用
        目标值，
            desiredTotal-选择值
        轮换，

        决胜，player1 选完后，desiredTotal<=0
        boolean dfs(int state1, int state2, int max, int desire, boolean turn)
        if (desire<=0) {
            return !turn;
        }
        boolean win=false;
        // 选择数
        for(int i=1; i<=max; i++) {
            if (turn) {
                if (state1&1<<(i-1)==0) continue;
                win=win||dfs(state1|1<<(i-1), state2, max, desire-i);
            } else {
                // 跳过已使用过的数字
                if (state2&1<<(i-1)==0) continue;
                win=win||dfs(state1, state2|1<<(i-1), max, desire-i);
            }
        }
        return win&&turn;
10 2

         */

        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs(0, desiredTotal, new Boolean[1 << maxChoosableInteger], maxChoosableInteger);
    }

    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs2(0, desiredTotal, maxChoosableInteger, true);
    }

    private boolean dfs2(int state, int desired, int max, boolean turn) {
        boolean win = !turn;
        // 选择数
        for (int i = max; i > 0; i--) {
            // 跳过已使用过的数字
            if ((state & (1 << (i - 1))) != 0) continue;
            if (desired <= i) {
                return turn;
            }
            boolean result = dfs2(state | (1 << (i - 1)), desired - i, max, !turn);
            if (!turn&&!result) {
                win = false;
            }
            if (turn&&result) {
                win = true;
            }

        }
        return win;
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
