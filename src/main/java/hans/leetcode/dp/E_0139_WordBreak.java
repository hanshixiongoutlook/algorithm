package hans.leetcode.dp;

import com.google.common.collect.Lists;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class E_0139_WordBreak {
    @Test
    public void test() {
//        boolean num = wordBreak("catsandog", Lists.newArrayList("cats","dog","sand","and","cat"));
//        boolean num = wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//                Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        boolean num = wordBreak("ddadddbdddadd", Lists.newArrayList("dd","ad","da","b"));
        Logger.log(num);
    }

    /**
     * TODO 解答失败
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i=0; i<wordDict.size(); i++) {
            String match = wordDict.get(i);
            if (s.startsWith(match)) {
                String sub = s.substring(match.length());
                if (sub.length()==0) {
                    return true;
                }
                s = sub;
                i = 0;
            }
        }

        return false;
    }
    public boolean dfs(String s, List<String> wordDict) {
        if (s.length()==0) {
            return true;
        }
        for (int i=0; i<wordDict.size(); i++) {
            String match = wordDict.get(i);
            if (s.startsWith(match)) {
                if (dfs(s.substring(match.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

}
