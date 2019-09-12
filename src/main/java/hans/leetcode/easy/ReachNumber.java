package hans.leetcode.easy;

import org.junit.Test;

public class ReachNumber {

    /*
    在一根无限长的数轴上，你站在0的位置。终点在target的位置。
    每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
    返回到达终点需要的最小移动次数。

    示例 1:
    输入: target = 3
    输出: 2
    解释:
    第一次移动，从 0 到 1 。
    第二次移动，从 1 到 3 。

    示例 2:
    输入: target = 2
    输出: 3
    解释:
    第一次移动，从 0 到 1 。
    第二次移动，从 1 到 -1 。
    第三次移动，从 -1 到 2 。
    注意: target是在[-10^9, 10^9]范围中的非零整数。
    链接：https://leetcode-cn.com/problems/reach-a-number
     */
    public int reachNumber(int target) {
        int count = 0;
        int len = 0;
        // 处理target为负数的场景，其实和正数一样，因此做统一处理
        if (target < 0) target = -target;
        while (true) {
            if (len==target) break; // 当前步数刚好到终点
            // 如果步数累加后超过了target，此时就需要后退了，但是无论如何后退，都相当于要重走x2的长度，
            // 因此当超出的步数-目标位置为2的倍数时，刚好可以到达终点
            if (len > target && (len-target)%2==0) break;
            count ++;
            len += count;
        }
        return count;
    }
    @Test
    public void test() {
        System.out.println(reachNumber(5));
    }
}
