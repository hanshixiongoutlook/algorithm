package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * We define the string s to be the infinite wraparound string of
 * "abcdefghijklmnopqrstuvwxyz", so s will look like this:
 * <p>
 * <p>
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * <p>
 * Given a string p, return the number of unique non-empty substrings of p are
 * present in s.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: p = "a"
 * Output: 1
 * Explanation: Only the substring "a" of p is in s.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: p = "cac"
 * Output: 2
 * Explanation: There are two substrings ("a", "c") of p in s.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: p = "zab"
 * Output: 6
 * Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab") of
 * p in s.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= p.length <= 10⁵
 * p consists of lowercase English letters.
 * <p>
 * Related Topics 字符串 动态规划 👍 184 👎 0
 */

public class M_0467_UniqueSubstringsInWraparoundString {

    @Test
    public void test() {
        int result = this.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcd");
        Logger.log(result);
    }

    /**
     * 			Runtime:10 ms, faster than 19.13% of Java online submissions.
     * 			Memory Usage:41.7 MB, less than 5.19% of Java online submissions.
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        /*
        TODO 怎么证明这个结论，没有想明白
        定义状态函数 dp[i]
        i, 表示a-z，如，0->a,1->b
           如何根据字母定位dp索引？
           很简单，char本身可以直接做数据运算，因此index=p[i]-'a'
        值, 表示以当前字母结尾的连续字符串最大长度，如，abxyzabcde，则以a结尾的连续字符串最大长度为，xyza=4
            值默认都是0，因为字母有可能是没有出现的
        结果, sum(dp[i])

        如何判定字符连续？
        1.相邻的字符差都是1
        2.由于是a-z无限循环，因此za这种情况也算连续，即差值为'a'-'z'也是连续的
        总结下，连续条件为： p[i]-p[i-1] = 1 || p[i]-p[i-1] = 'a'-'z'

        接下来就是计算最大连续串长度了，计数器可定少不了，定义一个计数器
        int count=1; // 只要出现了，至少是1
        // 接下来就是遍历计数了
        for (int i = 0; i < p.length(); i++) {
            // 先算出当前字母的dp索引
            int index = p[i]-'a';
            // i>0是为了避免数组越界，同时第一个元素，最大长度肯定是1
            // 第二个条件时连续条件
            if (i > 0 && (p[i]-p[i-1] = 1 || p[i]-p[i-1] = 'a'-'z')) {
                // 满足连续，计数+1
                count++;
            } else {
                // 连续中断，需要从头计数
                count = 1;
            }
            // 计算目前为止，已p[i]结尾的连续字符串最大长度
            // 因为p[i]可能会出现对此，因此要选最长的一个
            dp[index] = max(dp[index], count)
        }
        最后返回
        sum(dp)
         */
        int[] dp = new int[26];
        int cnt = 1;
        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';
            if (i > 0 && check(p.charAt(i - 1), p.charAt(i))) {
                cnt++;
            } else {
                cnt = 1;
            }
            dp[idx] = Math.max(dp[idx], cnt);
        }
        return Arrays.stream(dp).sum();
    }

    public boolean check(char a, char b) {
        return b - a == 1 || b - a == 'a'-'z';
    }
}
