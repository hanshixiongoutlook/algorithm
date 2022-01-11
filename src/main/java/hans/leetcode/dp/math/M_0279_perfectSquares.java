package hans.leetcode.dp.math;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 Given an integer n, return the least number of perfect square numbers that sum
 to n.

 A perfect square is an integer that is the square of an integer; in other
 words, it is the product of some integer with itself. For example, 1, 4, 9, and 16
 are perfect squares while 3 and 11 are not.


 Example 1:


 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.


 Example 2:


 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.



 Constraints:


 1 <= n <= 10⁴

 Related Topics 广度优先搜索 数学 动态规划 👍 1187 👎 0

 */
public class M_0279_perfectSquares {

    @Test
    public void test() {
        // 25 9 16
        int result = this.numSquares(16);
        Logger.log(result);

//        Logger.log(2.0%1);
    }
    // num->result
    // 10
    // 1->1
    // 2->1,1
    // 3->1,2
    // 4->4
    // 5->4,1
    // 6->1,5->1,1,4
    // 7->1,6->1,1,5->1,1,1,4
    // 8->4,4
    // 9->9
    //4,9 10->1,9
    //11->1,1,9
    //12->4,4,4
    //13->4,9
    //14->9,4,1
    //15
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> squares = new LinkedList<>();
    public int numSquares(int n) {
        /*
          f(n) = 1       ->     sqir(n)%1==0.0
          f(n) = min(f(n-s)) +1 -> sqir(n)%1>0.0 (s表示小于n的平方数集合)
         */
        if (Math.sqrt(n)%1==0.0) {
            return 1;
        }
        for (int i=1; i<=n; i++) {
            if (Math.sqrt(i)%1==0.0) {
                map.put(i, 1);
                squares.add(i);
            } else {
                int min = n;
                for (int s: squares) {
                    min = Math.min(map.get(i-s), min);
                }
                map.put(i, min+1);
            }
        }
        return map.get(n);
    }
}
