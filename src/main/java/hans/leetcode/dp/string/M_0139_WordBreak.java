package hans.leetcode.dp.string;

import com.google.common.collect.Lists;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

public class M_0139_WordBreak {
    @Test
    public void test() {
//        boolean num = wordBreak("catsandog", Lists.newArrayList("cats","dog","sand","and","cat"));
//        boolean num = wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//                Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        boolean num = wordBreak("leetcode", Lists.newArrayList("leet","code"));
        Logger.log(num);
    }

    /**
     * TODO 解答失败
     * 			Runtime:7 ms, faster than 69.23% of Java online submissions.
     * 			Memory Usage:38.7 MB, less than 33.33% of Java online submissions.
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<dp.length; i++) {
            for (int j=0;j<i; j++) {
                if (dp[j]&&set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
