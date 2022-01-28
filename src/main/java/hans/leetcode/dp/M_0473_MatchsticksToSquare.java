package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 You are given an integer array matchsticks where matchsticks[i] is the length
 of the iᵗʰ matchstick. You want to use all the matchsticks to make one square.
 You should not break any stick, but you can link them up, and each matchstick must
 be used exactly one time.

 Return true if you can make this square and false otherwise.


 Example 1:


 Input: matchsticks = [1,1,2,2,2]
 Output: true
 Explanation: You can form a square with length 2, one side of the square came
 two sticks with length 1.


 Example 2:


 Input: matchsticks = [3,3,3,3,4]
 Output: false
 Explanation: You cannot find a way to form a square with all the matchsticks.



 Constraints:


 1 <= matchsticks.length <= 15
 1 <= matchsticks[i] <= 10⁸

 Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 237 👎 0

 */
public class M_0473_MatchsticksToSquare {

    @Test
    public void test() {
        // 6,6,6,6,4,2,2
        // 5,5,5,5,4,4,4,4,3,3,3,3
        /*
        0101000
        1000001 -,6,6,-,4,-,-
        1000010 -,6,6,-,4,-,-
        1000100
        1,1,1,1,1,1,3,2,1,4,2,6,6,6
        00100000000111  2055
        01000000111000  4152
        10000001000000  8256
        00011110000000  1920
         */
        boolean result = this.makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3});
        Logger.log(result);
        Logger.log(2055&4152&8256*1920);
        // 111
    }
    /**
     * 位运算
     * 			Runtime:83 ms, faster than 29.89% of Java online submissions.
     * 			Memory Usage:43.1 MB, less than 5.02% of Java online submissions.
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        /*
        根据题意，想组合出一个正方向，需要将数组中的元素组合成四份，每一份的和=总和/4
        首先看基本状态：
        1.nums.lenght<4，一定不能组合出来，边数不够
        2.sum(nums)%4!=0，一定不能组合出来，因为总和都不能四等分
        3.含有元素值>sum/4，一定不能组合出来

        思路：
        通过二进制标志matchsticks中的值是否已使用
        如，matchsticks=[1,3,2,2,4,4]，可使用6位二进制表示数组中哪些元素已使用
        很明显，例子中做如下划分，可以组成一个正方形
        000011 表示使用[1,3]
        001100 表示使用[2,2]
        010000 表示使用[4]（2后第一个4）
        100000 表示使用[4]（2后第二个4）
        这道题的难点就在于满足：可分成4组；每组和相同；元素不重复利用。
        通过二进制与操作可判定两组数据是否存在交叉使用元素的情况，
        如，没有重复使用元素的情况
        000011  [1,3]
        001100  [2,2]
       &------
        000000
        结果为0，即没有重复使用元素
        再如，有重复使用元素的情况
        000011  [1,3]
        000110  [3,2]
       &------
        000010
        结果不为0，显然有重复使用元素

        此时可以尝试归纳状态函数
        定义：dp[i]，
        i代表二进制数如000110，表示matchsticks中的一组子元素
        dp长度，显然为1<<matchsticks.length
        dp[i]代表，子元素之和
        显然dp[0]=0，即一个元素都不用，和为0
        即，int[] dp = new int[1<<matchsticks.length]

        接下来需要考虑如何把所有的元素组合都穷举出来
        可以使用一个辅助列表List<Integer> dpIndexList，来记录已经计算出和的dp索引
        由于dp[0]=0，为基本情况，因此dpIndexList需要先把0放进去
        还需要顶一个list存储和=sum/4的组合
        此时伪码如下：
        int[] dp = new int[1<<matchsticks.length];
        dp[0]=0;// java可以不初始化，默认就是0
        List<Integer> dpIndexList; // 以计算出和的索引
        List<Integer> squareSumList; // 和=sum/4的索引
        for(int i, i<matchsticks.length, i++)
            每一个元素都和已有和累加一次
            for(dpIndex: dpIndexList)
                // 计算dp值
                dp[1<<i|dpIndex]=matchsticks[i]+dp[dpIndex]
                // 将新产生的结果放进dpIndexList参与后续计算
                // 这里其实可以做一个优化，如果dp[1<<i|dpIndex]>=sum/4，就没有必要参与计算了，这样可以减少大量计算
                // 1<<i|dpIndex，如，dpIndex=000011  [1,3]，
                // 如果i=2，即
                // 000100
                // 000011
                // |------
                // 000111 ->[1,3,2]

                if(dp[1<<i|dpIndex]<sum/4)
                    dpIndexList.add(1<<i|dpIndex);
                // 寻找目标结果，即dp==sum/4
                if(dp[1<<i|dpIndex]==sum/4) {
                    // 先存到一个单独的list里
                    squareSumList.add(1<<i|dpIndex);
                    // 对于和刚好满足sum/4的组合，需要单独处理，从这些组合中找出4组不存在重复元素的组合，如果找到了就返回true否则就是false
                }

        接下来就是验证squareSumList中是否存在4个使用不同元素的组合
        // 定义一个分组集合，将元素不重复的元素进行分组
        List<List<Integer>> groupList;
        foreach(idx in squareSumList)
            foreach(group in groupList)
                // 判断当前idx是否和group中的其他元素有重复
                boolean isDuplicate = false
                foreach(gidx in group) {
                    // 取&操作，结果不为0则有重复元素
                    int and = gidx&idx
                    if (and!=0) {
                        isDuplicate = true
                    }
                }
                // 如果无重复，则把当前索引也放到这个分组里
                if (!isDuplicate) {
                    group.add(idx);
                    // 如果这个分组的元素刚好有4个了，那么就能拼成正方形了直接返回true就行了
                    if (group.size()==4) {
                        return true
                    }
                }
                // 同时为当前索引创建一个新分组，这样后续的元素也能和它进行组合
                groupList.add(new List().add(idx))

           遍历结束没有找到合适的组合
           return false
         */
        int squareSum = sum/4;
        // 1.和不能被4整除；2.总长度<4；3.数组中有元素>sum/4
        if (sum%4!=0||matchsticks.length<4||Arrays.stream(matchsticks).anyMatch(ele->ele>squareSum)) {
            return false;
        }
        // 索引为二进制形式0表示该位未使用1表示已使用，值代表已使用的数字和
        int[] dp = new int[1<<matchsticks.length+1];
        // 已计算出值的dp索引
        List<Integer> dpIndexList =new LinkedList<>();
        dpIndexList.add(0);
        List<List<Integer>> target = new LinkedList<>();
        for (int i=0; i<matchsticks.length; i++) {
            // 定义一个临时集合村粗dp index，因为dpIndexList在遍历的时候不能再操作，
            // 因此需要把产生的新值放到临时集合里，待遍历结束后再放到dpIndexList
            List<Integer> tmpDpIndexList = new LinkedList<>();
            for (int dpIndex: dpIndexList) {
                // 计算新的和
                int cSum = dp[dpIndex]+matchsticks[i];
                // 1<<i|dpIndex，表示在dpIndex的基础上使用了第i位元素
                dp[1<<i|dpIndex] = cSum;
                if (cSum==squareSum) {
                    for (List<Integer> cTarget: target) {
                        // 使用元素不存在交叉
                        boolean notExistOverlap = true;
                        for (int tIdx: cTarget) {
                            int andVal = (1<<i|dpIndex)&tIdx;
                            if (andVal!=0) {
                                notExistOverlap=false;
                            }
                        }
                        if (notExistOverlap) {
                            cTarget.add(1<<i|dpIndex);
                            if (cTarget.size()==4) {
                                return true;
                            }
                        }
                    }
                    List<Integer> l = new LinkedList<>();
                    l.add(1<<i|dpIndex);
                    target.add(l);
                }
                // 当前和<squareSum用于后续计算，>或=的没再计算的必要了
                if (cSum<squareSum) {
                    tmpDpIndexList.add(1<<i|dpIndex);
                }
            }
            dpIndexList.addAll(tmpDpIndexList);
        }
        return false;
    }
}
