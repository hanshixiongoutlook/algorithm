package hans.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    public void test() {
        //DDRRR
        /*
          D
         */
        String senate = "DDRRR";
        String rdd = predictPartyVictory(senate);

        System.out.println(rdd);
    }
    public String predictPartyVictory(String senate) {
        // 记录出局人下标
        boolean[] outs = new boolean[senate.length()];
        for (int cur=0; cur<outs.length; cur++) {
            // 判断如果当前人已被禁止，则他不再有投票权，直接跳过
            if (outs[cur]) continue;
            /* 行使投票权，寻找下一个敌对方。
               这里有一点需要注意，找敌对时，应该优先从当前位置后面找，如果后边没找到，才能再从前面找一遍
             */
            // 先标记下，当前投票人，是否已经使用了投票权，默认是没使用
            boolean isVote = false;
            // 开始从当前位置向后搜索敌对方成员
            for (int after=cur; after<outs.length; after++) {
                // 发现敌对成员，直接而禁止其投票。
                // 这里需要注意有两个判断条件：1.意见敌对；2.敌对方仍有投票权。
                // 简单解释下条件2，因为可能出现RRRDDDDD这种情况，当R3行使权力时，发现D1、D2已经被禁止了，就没必要再浪费权力了，需要接着往后找
                if (senate.charAt(cur)!=senate.charAt(after) && !outs[after]) {
                    outs[after]=true;
                    isVote = true;
                    break;
                }
            }
            // 如果投票权未使用，即向后遍历没发现敌对，就要从头再遍历一遍到当前位置，毕竟投票权是要用掉的
            if (!isVote) {
                for (int pre=0; pre<cur; pre++) {
                    // 这里判断逻辑和上边一样
                    if (senate.charAt(cur)!=senate.charAt(pre) && !outs[pre]) {
                        outs[pre]=true;
                        break;
                    }
                }
            }
        }

        // 这部分就是处理本轮投票结果了
        List<Character> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<outs.length; i++) {
            if (!outs[i]) {
                sb.append(senate.charAt(i));
                candidates.add(senate.charAt(i));
            }
        }
        // 如果候选人中包含了敌对双发，就需要在投一轮
        if (candidates.contains('D') && candidates.contains('R')) {
            return predictPartyVictory(sb.toString());
        } else {
            return candidates.get(0)=='D'?"Dire":"Radiant";
        }

    }
}
