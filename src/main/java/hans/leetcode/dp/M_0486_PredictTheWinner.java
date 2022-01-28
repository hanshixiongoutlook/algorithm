package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 You are given an integer array nums. Two players are playing a game with this
 array: player 1 and player 2.

 Player 1 and player 2 take turns, with player 1 starting first. Both players
 start the game with a score of 0. At each turn, the player takes one of the
 numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which
 reduces the size of the array by 1. The player adds the chosen number to their
 score. The game ends when there are no more elements in the array.

 Return true if Player 1 can win the game. If the scores of both players are
 equal, then player 1 is still the winner, and you should also return true. You may
 assume that both players are playing optimally.


 Example 1:


 Input: nums = [1,5,2]
 Output: false
 Explanation: Initially, player 1 can choose between 1 and 2.
 If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player
 2 chooses 5, then player 1 will be left with 1 (or 2).
 So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 Hence, player 1 will never be the winner and you need to return false.


 Example 2:


 Input: nums = [1,5,233,7]
 Output: true
 Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5
 and 7. No matter which number player 2 choose, player 1 can choose 233.
 Finally, player 1 has more score (234) than player 2 (12), so you need to
 return True representing player1 can win.



 Constraints:


 1 <= nums.length <= 20
 0 <= nums[i] <= 10⁷

 Related Topics 递归 数组 数学 动态规划 博弈 👍 515 👎 0

 */
public class M_0486_PredictTheWinner {

    @Test
    public void test() {
        boolean result = this.PredictTheWinner(new int[]{1,5,2});
        Logger.log(result);
    }

    int[] nums;

    /**
     * 			Runtime:100 ms, faster than 5.02% of Java online submissions.
     * 			Memory Usage:39.4 MB, less than 5.02% of Java online submissions.
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        /*
        这道题适合使用递归方式解决，思路清晰
        寻找变量：
            1.可用的元素个数，经过角逐，数组中的可用元素会越来越少，显然是一个变量
            2.玩家分数，player1和player2的各自的分数会不断累加，显然是第二个变量
            3.player1先选player2再先，不断轮换，显然当前该谁选也是一个变量

        变化方式：
            1.可用的元素个数，要么取start，要么取end，因此每次有【两个选择】
            2.玩家分数，根据选择累加
            3.该谁选，不断轮换

        开始抽象递归函数：
        元素变化+选择轮换=>分数变化
        可以尝试将元素变化和选择轮换抽象到参数中
        二分数变化可以作为结果，得到一个抽象方法
        int[2] dfs(nums[],turn)
        再根据题目给出的信息，对函数做一些优化
        元素变化，每次只取start或end，中间不变因此可作如下调整
        int[2] dfs(int start,int end,turn)
        结果变化，记录两个结果需要增加判断很多计算，可以思考，最终结果只需要判断
        player1Score-player2Score>=0即可判定player1是否能胜出
        因此可以将这两个分数合并成一个结果
        int dfs(int start, int end, turn)
        此时，
        返回值表示:player1Score-player2Score，即player1比player2高几分
        start:可选元素起始索引
        end:可选元素结束索引
        turn：是轮换标识，可以用true/false标识，也可以用数字1，-1来表示，其他方式也行，只要能分出当前该谁选就行
        这里我们选1表示player1选择，-1表示player2选择，至于为什么从后边结果推导中可以看出来

        函数定义有了，接下推导递归过程：
        1.每个人都有两种选择，即
        选第一个：dfs(start+1,end,-turn) , 因为头元素用了因此下次递归，头元素就要向前进一步，下次就不能再用了
        最后一个：dfs(start,end-1,-turn) , 因为尾元素用了因此下次递归，尾元素就要向后退一步，下次就不能用了
        计算结果以后，选其中得分高的结果
        -turn则表示，轮换
        2.什么时候递归结束？
        显然只剩一个元素的时候，就改结束了，当前选手只有一个选择了，他选就结束了，
        此时，start==end

        3.返回结果计算，player1Score-player2Score，即player1比player2高几分
        ->先来看结束条件start==end的时候，这时候数组中只有一个数字N可以选了
          如果轮到player1选时，本轮player1得分N，player2得分0（因为没得选了），结果=N-0
          如果轮到player2选了，本轮player1得分0，player2得分N，结果=0-N
          显然，入参turn，用1表示player1得分，-1表示player2得分就会很方便
          此时，可以return nums[start]*turn;
        ->再来看通常情况
          选第一个元素得分  diffStart = nums[start]*turn + dfs(start+1,end,-turn)
          最后一个元素得分  diffEnd  = nums[end] + dfs(start,end-1,-turn)

          此时需要考虑，到底是选得分高的最为当前结果还是选得分低的作为当前结果
          题目中有一个重要信息，【player1一定能赢】
          因此在这场博弈中，无论player1还是player2一定都想着自己能赢
          player1一定希望，分差越大越好，这样自己就能赢
          player2则会希望，分差越小越好，如果分差变成负数，自己就赢了

          因此，结果就是这样

          轮到player1，我希望分差变大：
            if (turn>0) max(diffStart,diffEnd)
          轮到player2，我希望分差变小：
            if (turn<0) min(diffStart,diffEnd)

        OK，递归框架基本上出来了：
        int dfs(int start, int end, int turn) {
            if (start==end) {
                return nums[start]*turn;
            }
            // 选第一个，计算player1能比player2的多得几分
            int diffStart = nums[start]*turn + dfs(start+1,end,-turn)
            // 选最后一个，计算player1能比player2的多得几分
            int diffEnd = nums[end]*turn + dfs(start,end-1,-turn)
            if (turn>0) {
                max(diffStart,diffEnd)
            } else {
                min(diffStart,diffEnd)
            }
        }

        当然如果想优化下代码结构，最后的返回也可以调整成这样
        return max(diffStart*turn, diffEnd*trun)*turn;
         */
        this.nums = nums;
        return dfs(0, nums.length-1, 1)>=0;
    }

    /**
     * @param start 起始索引
     * @param end 结束索引
     * @param turn 轮换标志，1代表player1得分，-1代表player2得分
     * @return player1Score-player2Score，即两个选手的累计分数差
     */
    public int dfs(int start, int end, int turn) {
        if (start==end) {
            return nums[start]*turn;
        }
        int selectStart = nums[start]*turn + dfs(start+1, end, -turn);
        int selectEnd = nums[end]*turn + dfs(start, end-1, -turn);
        return Math.max(selectStart * turn, selectEnd * turn) * turn;
    }
}
