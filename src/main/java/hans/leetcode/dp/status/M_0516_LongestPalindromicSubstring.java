package hans.leetcode.dp.status;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 * <p>
 * Related Topics 字符串 动态规划 👍 720 👎 0
 */
public class M_0516_LongestPalindromicSubstring {
    @Test
    public void test() {
        int num = longestPalindromeSubseq("affassf");
        Logger.log(num);
    }

    /**
     * 			Runtime:40 ms, faster than 26.07% of Java online submissions.
     * 			Memory Usage:50.3 MB, less than 15.31% of Java online submissions.
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        /*
        状态方程
        0<=i<=j<s.len
        dp[i][j] 表示 s[i,j] 回文数最大长度
        dp[i][i]=1 表示最小回文数长度为1

        dp[i][j] = dp[i+1][j-1] + 2   s[i]==s[j]
        dp[i][j] = MAX(dp[i+1][j],dp[i][j-1]) s[i]!=s[j]

        由于左右边界参与计算，因此需要倒着遍历
        如，
              i
              j
        0123456
        affassf
        1 6,6 1
        2 5,5 1
          5,6 (5,6)(6,6)->1
        3 4,4 1
          4,5 s[4]=s[5] dp[4+1][5-1]+2 = 2
          4,6 (4,5)(5,6) ->2
        4 3,3 1
          3,4 (3,3)(4,4) ->1
          3,5 (3,4)(4,5) ->2
          3,6 (3,5)(4,6) ->2
          ...

         */
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i=len-1; i>=0; i--) {
            dp[i][i]=1;
            for (int j=i+1; j<len; j++) {
                if (s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
