package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 Suppose you have n integers labeled 1 through n. A permutation of those n
 integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <=
 i <= n), either of the following is true:


 perm[i] is divisible by i.
 i is divisible by perm[i].


 Given an integer n, return the number of the beautiful arrangements that you
 can construct.


 Example 1:


 Input: n = 2
 Output: 2
 Explanation:
 The first beautiful arrangement is [1,2]:
 - perm[1] = 1 is divisible by i = 1
 - perm[2] = 2 is divisible by i = 2
 The second beautiful arrangement is [2,1]:
 - perm[1] = 2 is divisible by i = 1
 - i = 2 is divisible by perm[2] = 1


 Example 2:


 Input: n = 1
 Output: 1



 Constraints:


 1 <= n <= 15

 Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 280 👎 0

 */

public class M_0526_BeautifulArrangement {

    @Test
    public void test() {
        for (int i=0; i<=8; i++) {
        }
        Logger.log(1%2);
        Logger.log("i={}, count={}", 3, countArrangement(15));
    }

    /**
     * 			Runtime:60 ms, faster than 28.35% of Java online submissions.
     * 			Memory Usage:37.9 MB, less than 29.53% of Java online submissions.
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        /*
        1 -> *
        2 -> 1 2 4 6 8 10 12 14
        3 -> 1 3 6 9 12 15
        4 -> 1 2 4 8 12
        5 -> 1 5 10 15
        6 -> 1 6 12
        7 -> 1 7 14
        [8...15] -> 1 n
        穷举每个数字所能待的位置如上
        解题过程其实就是为每一个数字安排一个合适的位置
        显然对于1~15来说都有多个位置可选，并且已经被占用的位置就不能再选了

        比如为3找一个合适的位置，就需要遍历所有位置，找出一个可用的位置
        for(1...n)
            // 为num安排一个位置,需要保证两点，1.位置合适满足整除需求；2.位置可用
            // 1.整除需求按题目要求判断即可(3%i==0||i%3==0)
            // 2.位置可用，很容想到二进制表示位置是否可用，1表示已占用，0表示未占用
            int pos = 1<<(i-1)
            if( (3%i==0||i%3==0) && pos&flag>0)
        4、5、6...处理方式一样，即发现了可复用逻辑，很容易想到递归实现
        接下来设计递归方法
        入参：1.等待找位置的数字；2.位置占用情况
        出参：暂时不需要，可以定义一个全局计数器
        关键点：找出计数条件，显然就是为每个数字都找到合适的位置后就可以计数了
        即currentNum=n && currentNum%1==0||i%currentNum==0
        int count=0;
        dfs(int currentNum, flag)
            // 带入找位置的过程
            for(1...n)
                int pos = 1<<(i-1)
                // 位置不符合条件  或者 已被占用，需要跳过
                if( (3%i>0&&i%3>0) || pos&flag>0) continue;
                if(currentNum==n && (currentNum%1==0||i%currentNum==0)) {
                    count++;
                    return;
                }
                // 接着为下一个数字找位置
                dfs(currentNum+1, flag|pos)



         */
        max = n;
        dfs(1,0);
        return count;
    }
    int count=0;
    int max;
    public void dfs(int n, int flag) {
        if (n>max) {
            return;
        }
        for (int i=0; i<max; i++) {
            int pos = 1<<i;
            // 当前位已占用
            if ((pos&flag)>0) continue;
            if (n%(i+1)>0&&(i+1)%n>0) continue;
            if (n==max && (n%(i+1)==0||(i+1)%n==0)) {
                count++;
                return;
            }
            dfs(n+1, flag|pos);
        }
    }
}
