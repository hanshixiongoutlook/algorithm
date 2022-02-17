package hans.leetcode.dp.status.multi;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of
 * the remaining characters.
 * <p>
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * <p>
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 * <p>
 * Related Topics 字符串 动态规划 👍 838 👎 0
 */
public class M_1143_LongestCommonSubsequence {

    @Test
    public void test() {
        int result = this.longestCommonSubsequence("abc", "efab");
        Logger.log(result);
    }

    /**
     * 			Runtime:9 ms, faster than 73.68% of Java online submissions.
     * 			Memory Usage:45.2 MB, less than 9.78% of Java online submissions.
     * 		TODO 未解出
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        dp[i][j] 表示 text1.subString(0,i) 和 text2.subString(0,j)，最大公共子串长度

        举例
        text1=abc  text2=efab
        dp[1][1]=0 即 text1[0,1)=a text2[0,1)=e
        dp[1][2]=0 即 text1[0,1)=a text2[0,2)=ef
        dp[1][3]=1 即 text1[0,1)=a text2[0,3)=efa
        dp[1][4]=1 即 text1[0,1)=a text2[0,4)=efab

        dp[2][1]=0 即 text1[0,2)=ab text2[0,1)=e
        dp[2][2]=0 即 text1[0,2)=ab text2[0,2)=ef
        dp[2][3]=1 即 text1[0,2)=ab text2[0,3)=efa
        dp[2][4]=2 即 text1[0,2)=ab text2[0,4)=efab

        dp[3][1]=0 即 text1[0,3)=abc text2[0,1)=e
        dp[3][2]=0 即 text1[0,3)=abc text2[0,2)=ef
        dp[3][3]=1 即 text1[0,3)=abc text2[0,3)=efa
        dp[3][4]=2 即 text1[0,3)=abc text2[0,4)=efab

        e  f  a  b
      a 0  0  1  1
      b 0  0  1  2
      c 0  0  1  2
        显然dp[0][j] 即text1.subString(0,0)=""，无论如何都不能再和text2有共同子串，
        因此dp[0][j]=0，同理dp[i][0]=0

        dp[i][j] = dp[i-1][j-1]+1  text1[i-1]==text2[j-1]
        dp[i][j] = max(dp[i-1][j],dp[i][j-1]  text1[i-1]!=text2[j-1]

        res = dp[m][n]
         */
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i=1; i<=text1.length(); i++) {
            char t1 = text1.charAt(i-1);
            for (int j=1; j<=text2.length(); j++) {
                char t2 = text2.charAt(j-1);
                if (t1==t2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

//        int m = text1.length(), n = text2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            char c1 = text1.charAt(i - 1);
//            for (int j = 1; j <= n; j++) {
//                char c2 = text2.charAt(j - 1);
//                if (c1 == c2) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[m][n];
    }

}
