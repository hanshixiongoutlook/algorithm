package hans.leetcode.tree.design;


import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

 请实现 KthLargest 类：


 KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。




 示例：


 输入：
 ["KthLargest", "add", "add", "add", "add", "add"]
 [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 输出：
 [null, 4, 5, 5, 8, 8]

 解释：
 KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 kthLargest.add(3);   // return 4
 kthLargest.add(5);   // return 5
 kthLargest.add(10);  // return 5
 kthLargest.add(9);   // return 8
 kthLargest.add(4);   // return 8



 提示：


 1 <= k <= 10⁴
 0 <= nums.length <= 10⁴
 -10⁴ <= nums[i] <= 10⁴
 -10⁴ <= val <= 10⁴
 最多调用 add 方法 10⁴ 次
 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素

 Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 332 👎 0

 */
public class E_0703_KthLargestElementInaStream {

    @Test
    public void test() {
        KthLargest k = new KthLargest(2, new int[]{0});

        Logger.log(k.add(-1));
        Logger.log(k.add(1));
        Logger.log(k.add(-2));
        Logger.log(k.add(-4));
        Logger.log(k.add(3));
    }

    class KthLargest {
        int k;
        List<Integer> list;
        public KthLargest(int k, int[] nums) {
            list = new ArrayList<>(nums.length*2);
            for (int i=0; i<nums.length; i++) {
                list.add(nums[i]);
            }
            list.sort((o1, o2) -> o2-o1);
            this.k = k-1;
        }
        public int add(int val) {
            if (list.isEmpty()) {
                list.add(val);
            } else {
                for (int i=0; i<list.size(); i++) {
                    if (val>=list.get(i)) {
                        list.add(i, val);
                        break;
                    }
                }
            }
            if (k<list.size()) {
                return list.get(k);
            }
            return 0;
        }
    }
}
